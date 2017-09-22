import java.util.ArrayList;
import java.util.*;

public class MeterArchive
{
    private ArrayList<Meter> list;

    public MeterArchive(){
        list = new ArrayList<>();
    }

    // adds an object to the arraylist
    public void addMeter(Meter obj){
        boolean found = false;
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).equals(obj)){
                found = true;
                System.out.println("This object already exists in the list.\n");
            }
        }

        if(found == false){
            list.add(obj);
        }
    }

    // Removes a meter from the arraylist.
    public boolean removeMeter(String regNummer){
        boolean found = false;
        System.out.println("Deleting instrument with registration number: " + regNummer);
        Meter z = null;

        for(Meter m : list){
            if(m.getRegistrationNumber().equals(regNummer)){
                found = true;
                z = m;
            }
        }

        if(!found){
            System.out.println("Unknown number\n");
        }
        else if(found){
            list.remove(z);
            System.out.println("Deleted successfully.\n");
        }
        return found;
    }

    // Returns an meter objects state from the arraylist in a string.
    public Meter getMeter(String registrationNumber){
        int counter = 0;
        boolean found = false;
        Meter m = null;
        System.out.println("Fetching all instruments with registration number " + registrationNumber);

        while (counter < list.size() && !found){
            if(list.get(counter).getRegistrationNumber().equals(registrationNumber)){
                m = list.get(counter);
                System.out.println(m + "\n");
                found = true;
            }
            counter++;
        }
        return m;
    }

    // Changes attribut status to not OK.
    public boolean changeStatusNotOK(String registrationNumber){
        int counter = 0;
        boolean found = false;

        System.out.println("Changing object with number " + registrationNumber + " to broken.");
        while (counter < list.size() && !found){
            if(list.get(counter).getRegistrationNumber().equals(registrationNumber)){
                list.get(counter).setStatus("Not OK");
                System.out.println(list.get(counter));
                found = true;
            }
            counter++;
        }

        if(!found){
            System.out.println("Unknown number\n");
        }
        return found;
    }

    // Changes attribut placementCode of an object.
    public boolean changePlacement(String registrationNumber, String newPlacement){
        int counter = 0;
        boolean found = false;
        System.out.println("Changing placement for " + registrationNumber);
        while (counter < list.size() && !found){
            if(list.get(counter).getRegistrationNumber().equals(registrationNumber)){
                list.get(counter).setPlacementCode(newPlacement);
                System.out.println("The change is registered.\n");
                found = true;
            }
            counter++;
        }

        if(!found){
            System.out.println("Unknown meter\n");
        }
        return found;
    }

    // Sorts object in the arraylist.
    public void sort(){
        Collections.sort(list);
    }

    // Prints all objects in the arraylist.
    public void printAll(){
        System.out.println("\nAll instruments");
        for(Meter m : list){
            System.out.print(m);
        }
    }

}
