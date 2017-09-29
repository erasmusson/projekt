/**
 * Created by Emma Rasmusson
 */
public class Weight extends Meter

{
    private double highestWeight;
    private double lowestWeight;

    public Weight(String registrationNumber, String status, String placementCode, double highestWeight, double lowestWeight){
        super(registrationNumber, status, placementCode);
        setHighestWeight(highestWeight);
        setLowestWeight(lowestWeight);

    }

    public Weight(){
        super("unknown", "unknown", "unknown");
        setHighestWeight(10.0);
        setLowestWeight(0.0);
    }

    // Registers highest weight
    public void setHighestWeight(double highestWeight){
        this.highestWeight = highestWeight;
    }

    // Registers lowest weight
    public void setLowestWeight(double lowestWeight){
        this.lowestWeight = lowestWeight;
    }

    // Returns highest weight
    public double getHighestWeight(){
        return highestWeight;
    }

    // Returns lowest weight
    public double getLowestWeight(){
        return lowestWeight;
    }

    // Returns the objects state in a String
    public String toString(){
        return "Weight\n(Interval of weight: " + lowestWeight + " - " + highestWeight + ")\n" + super.toString() + "\n\n";
    }

}
