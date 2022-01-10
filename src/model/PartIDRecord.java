package model;

public class PartIDRecord {
    private static int nextPartID = 1000;

    public static int getNextPartID() {
        int tempID = nextPartID;
        nextPartID++;
        return tempID;
    }

    public static void setNextPartID(int nextPartID) {
        PartIDRecord.nextPartID = nextPartID;
    }
}
