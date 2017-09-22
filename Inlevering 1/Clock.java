/**
 * Created by Emma Rasmusson
 */

public class Clock extends Meter
{
    private double minTime;

    public Clock(String registrationNumber, String status, String placementCode, double minTime){
        super(registrationNumber, status, placementCode);
        setMinTime(minTime);
    }

    public Clock(){
        super("unknown", "unknown", "unknown");
        setMinTime(0.0);
    }

    // Registers minimum time of a clock
    public void setMinTime(double minTime){
        this.minTime = minTime;
    }

    // Returns minimum time of a clock
    public double getMinTime(){
        return minTime;
    }

    // Returns the objects state in a string
    public String toString(){
        return "Clock\n(Smallest interval of time: " + minTime + " )\n" + super.toString() + "\n\n";
    }

}
