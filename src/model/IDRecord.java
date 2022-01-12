package model;
/** This class is used to increment part and product IDs. */
public class IDRecord {
    private static int nextPartID = 1000;
    private static int nextProductID = 100;

    public static int getNextPartID() {
        int tempID = nextPartID;
        nextPartID++;
        return tempID;
    }

    public static int getNextProductID(){
        int tempID = nextProductID;
        nextProductID++;
        return tempID;
    }
}
