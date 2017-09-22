public class main
{
    public static void main(String[] args){

        MeterArchive ma = new MeterArchive();

        // Creates new objects of weight, clocks and thermometer and adds them to ma.
        ma.addMeter(new Weight("V1000", "OK", "R101H1", 10.0, 0.01));
        ma.addMeter(new Weight("V1001", "OK", "R101H2", 100.0, 0.1));
        ma.addMeter(new Thermometer("T2001","OK","R101H5", 200, 1.0));
        ma.addMeter(new Clock("K3001", "OK", "R101H7", 0.1));
        ma.addMeter(new Weight("V1002", "OK", "R101H3", 1000.0, 1.0));
        ma.addMeter(new Clock("K3000", "OK", "R101H6", 0.1));
        ma.addMeter(new Thermometer("T2000","OK","R101H3", 100, 1.0));
        ma.addMeter(new Clock("K3002", "OK", "R101H8", 1.0));
        ma.addMeter(new Clock("K3002", "OK", "R101H8", 1.0));

        // Sorts the objects
        ma.sort();

        // Prints all the objects
        ma.printAll();

        // Removes an object
        ma.removeMeter("T2007");

        // Change placement of an object
        ma.changePlacement("T2001", "R101H4");

        ma.printAll();

        // Prints information about a meter
        ma.getMeter("T2001");

        // Changes status to not OK
        ma.changeStatusNotOK("T2001");
    }
}
