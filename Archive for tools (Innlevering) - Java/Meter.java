/**
 * Created by Emma Rasmusson
 */

public abstract class Meter implements Comparable <Meter>
{
    private String registrationNumber;
    private String status;
    private String placementCode;

    public Meter(String registrationNumber, String status, String placementCode){
        setRegNumber(registrationNumber);
        setStatus(status);
        setPlacementCode(placementCode);
    }

    public Meter(){
        this("Unknown", "Unknown", "Unknown");
    }

    // Register Registration number
    public void setRegNumber(String regNummer){
        this.registrationNumber = regNummer;
    }

    // Register status
    public void setStatus(String status){
        this.status = status;
    }

    // Register Placeringskod
    public void setPlacementCode(String placementCode){
        this.placementCode = placementCode;
    }

    // Return RegNummer
    public String getRegistrationNumber(){
        return registrationNumber;
    }

    // Return Status
    public String getStatus(){
        return status;
    }

    // Return placeringskod
    public String getPlacementCode(){
        return placementCode;
    }

    // Get objects attribut in a String
    public String toString(){
        return "Registration number: " + getRegistrationNumber() + "\nPlacement: " + getPlacementCode() + "\nStatus: " + getStatus();
    }

    // Compares two Meter objects. Return true if the objects are the same.
    public boolean equals(Object obj){
        if(!(obj instanceof Meter)){
            return false;
        }

        if(obj == this){
            return true;
        }

        Meter m = (Meter) obj;

        if(this.registrationNumber.equals(m.registrationNumber)){
            return true;
        }

        else{
            return false;
        }
    }

    public int compareTo(Meter obj){
        int result = getRegistrationNumber().compareTo(obj.getRegistrationNumber());
        return result;
    }
}

