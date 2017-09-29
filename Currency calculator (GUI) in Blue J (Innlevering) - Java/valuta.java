// Emma Rasmusson 21042017 - In blueJ
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import static javax.swing.JOptionPane.*;

public class valuta extends JFrame implements ActionListener{
    private JTextField value1;
    private JTextField value2;
    private JLabel otherCurrency; 
    public valuta(){
        super("Valutakalkylator");

        // North Panel
        JPanel north = new JPanel(new GridLayout(1,2));

        // Nok textfält
        north.add(new JLabel("NOK"));
        value1 = new JTextField();
        north.add(value1);

        // Annan valutas textfält
        otherCurrency = new JLabel("Annan valuta");
        north.add(otherCurrency);
        value2 = new JTextField();
        north.add(value2);

        add(north, BorderLayout.NORTH);

        // Center Panel
        JPanel center = new JPanel(new GridLayout(2,2));

        // GBP knapp
        JButton btnGBP = new JButton("GBP");
        btnGBP.addActionListener(this);
        center.add(btnGBP);

        // EUR knapp
        JButton btnEUR = new JButton("EUR");
        btnEUR.addActionListener(this);
        center.add(btnEUR);

        // USD knapp
        JButton btnUSD = new JButton("USD");
        btnUSD.addActionListener(this);
        center.add(btnUSD);

        // SEK knapp
        JButton btnSEK = new JButton("SEK");
        btnSEK.addActionListener(this);
        center.add(btnSEK);

        add(center, BorderLayout.CENTER);

        // South Panel
        JPanel south = new JPanel(new GridLayout(1,4));

        // Fjern NOK knapp
        JButton btnRemoveNOK = new JButton("Fjern NOK");
        btnRemoveNOK.addActionListener(this);
        south.add(btnRemoveNOK);

        // Fjern annan valuta
        JButton btnRemoveOtherCurrency = new JButton("Fjern annan valuta");
        btnRemoveOtherCurrency.addActionListener(this);
        south.add(btnRemoveOtherCurrency);

        // Fjern båda
        JButton btnRemoveBoth = new JButton("Fjern båda");
        btnRemoveBoth.addActionListener(this);
        south.add(btnRemoveBoth);

        // Exit
        JButton btnExit = new JButton("Avslutt");
        btnExit.addActionListener(this);
        south.add(btnExit);

        add(south, BorderLayout.SOUTH);

        // Storlek på fönster, synlighet samt event vid exit.
        setSize(600,130);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    // Metod för att se om knappen som är tryckt på är fjern NOK, fjern annan valuta, fjern båda eller avslut. Om ja, utför den handlingen.
    public void checkRemove(String name){
        if(name.equals("Fjern NOK") || name.equals("Fjern annan valuta") || name.equals("Fjern båda") || name.equals("Avslutt")){
            if(name.equals("Fjern NOK")){
                value1.setText("");
            }   
            else if(name.equals("Fjern annan valuta")){
                value2.setText("");
            }
            else if(name.equals("Fjern båda")){
                value1.setText("");
                value2.setText("");
            }
            else if(name.equals("Avslutt")){
                System.exit(0);
            }
        }
    }

    // Ser om det är en knapp för valuta som trycks på. Om ja, checkar den om det är skrivit in belopp på ingen eller båda textfälten. Om det bara är fyllt i ett textfält räknar den ut valutakursen.
    public void checkCurrencyBtn(String name){
        // Alla valutakurser
        double GBP = 10.9770;
        double EUR = 9.2120;
        double USD = 8.5733;
        double SEK = 0.9576;
        
        double result = 0;

        if(name.equals("GBP") || name.equals("USD") || name.equals("SEK") || name.equals("EUR")){
            // Om ingen av textfälten är fyllda kommer ruta upp som informerar om att ett belopp måste skrivas in.
            if(value1.getText().equals("") && value2.getText().equals("")){
                showMessageDialog(null, "Du måste skriva ett belopp!");
            }

            // Om båda textfälten är fyllda kommer ruta upp som informerar om att ett belopp kan skrivas in.
            else if((!value1.getText().equals("")) && (!value2.getText().equals(""))){
                showMessageDialog(null, "Du kan bara skriva ett belopp!");
            } 
            
            // Om textfält 2 är fylld ut omvandlas valutan.
            else if(!(value2.getText().equals(""))){
                String textValue1 = value2.getText();
                double val1 = Double.parseDouble(textValue1);
                if(name.equals("GBP")){
                    result = GBP * val1;
                    value1.setText("" + result);
                    otherCurrency.setText("GBP");
                }

                else if(name.equals("EUR")){
                    result = EUR * val1;
                    value1.setText("" + result);
                    otherCurrency.setText("EUR");
                }

                else if(name.equals("USD")){
                    result = USD * val1;
                    value1.setText("" + result);
                    otherCurrency.setText("USD");
                }
                else if(name.equals("SEK")){
                    result = SEK * val1;
                    value1.setText("" + result);
                    otherCurrency.setText("SEK");
                }
            }
            
            // Om textfält 1 är fylld ut omvandlas valutan.
            else if(!(value1.getText().equals(""))){
                String textValue2 = value1.getText();
                double val2 = Double.parseDouble(textValue2);
                if(name.equals("GBP")){
                    result = val2 / GBP;
                    value2.setText("" + result);
                    otherCurrency.setText("GBP");
                }

                else if(name.equals("EUR")){
                    result = val2 / EUR;
                    value2.setText("" + result);
                    otherCurrency.setText("EUR");
                }

                else if(name.equals("USD")){
                    result = val2 / USD;
                    value2.setText("" + result);
                    otherCurrency.setText("USD");
                }
                else if(name.equals("SEK")){
                    result = val2 / SEK;
                    value2.setText("" + result);
                    otherCurrency.setText("SEK");
                }
            }
        }
    }

    public void actionPerformed(ActionEvent e){
        String clicked = e.getActionCommand();
        checkRemove(clicked);
        checkCurrencyBtn(clicked);
    }
}
