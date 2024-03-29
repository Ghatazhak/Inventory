package model;
/** This class is used to increment part and product IDs. */
public class IDRecord {
    private static int nextPartID = 1000;
    private static int nextProductID = 100;
/** This method gets part ids. It keeps a permanent record of used part IDs.
 * @return returns next unique part id as an integer. */
    public static int getNextPartID() {
        int tempID = nextPartID;
        nextPartID++;
        return tempID;
    }
    /** This method gets product ids. It keeps a permanent record of used product IDs.
     * @return returns the next unique product id as an integer.*/
    public static int getNextProductID(){
        int tempID = nextProductID;
        nextProductID++;
        return tempID;
    }
}
