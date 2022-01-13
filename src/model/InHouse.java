package model;
/** This class extends the part abstract class */
public class InHouse extends Part {
    private int machineId;
/** This is the constructor. It initializes the values of all the fields of a part of type InHouse.
 * @param id id of the part.
 * @param machineId the machine ID used for internal part manufacturing.
 * @param max maximum stock levels.
 * @param min minimum stock levels.
 * @param name name of the in house part.
 * @param price price for the part
 * @param stock current stock level.
 * */
    public InHouse(int id, String name, double price, int stock, int min, int max, int machineId) {
        super(id, name, price, stock, min, max);
        this.machineId = machineId;
    }
/** This method returns machine id. It returns the machine ID of the in house  part.
 @return integer */
    public int getMachineId() {
        return machineId;
    }
/** This method sets the machine id. It sets the field for machine ID.
 * @param machineId  The machine ID. */
    public void setMachineId(int machineId) {
        this.machineId = machineId;
    }
}
