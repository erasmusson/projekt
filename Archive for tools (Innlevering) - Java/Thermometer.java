/**
 * Created by Emma Rasmusson
 */
public class Thermometer extends Meter
{
    private double highestTemp;
    private double lowestTemp;

    public Thermometer(String registrationNumber, String status, String placementCode, double highestTemp, double lowestTemp){
        super(registrationNumber, status, placementCode);
        setHighestTemp(highestTemp);
        setLowestTemp(lowestTemp);

    }

    public Thermometer(){
        super("unknown", "unknown", "unknown");
        setHighestTemp(0.0);
        setLowestTemp(0.9);
    }

    // Registers highest temperature
    public void setHighestTemp(double highestTemp){
        this.highestTemp = highestTemp;
    }

    // Register lowest temperature
    public void setLowestTemp(double lowestTemp){
        this.lowestTemp = lowestTemp;
    }

    // Return highest temperature
    public double getHighestTemp(){
        return highestTemp;
    }

    // Return lowest temperature
    public double getLowestTemp(){
        return lowestTemp;
    }

    // Return the objects state in a string
    public String toString(){
        return "Thermometer\n(Min och max temp: " + lowestTemp + " - " + highestTemp + ")\n" + super.toString() + "\n\n";
    }

}

