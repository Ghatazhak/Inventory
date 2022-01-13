package model;
/** This class extends the abstract part class */
public class OutSourced extends Part {
    private String companyName;
/** method is the constructor for outsourced.
 * @param name name of the part.
 * @param stock current stock level of the part.
 * @param price price per unit of the part.
 * @param min minimum stock level.
 * @param max maximum stock level.
 * @param id part id.
 * @param companyName name of company that manufacturers the part */
    public OutSourced(int id, String name, double price, int stock, int min, int max, String companyName) {
        super(id, name, price, stock, min, max);
        this.companyName = companyName;
    }
/** method to find the company name for the part.
 * @return  returns string of the company name.*/
    public String getCompanyName() {
        return companyName;
    }
/** method to set the company name of the part.
 * @param companyName name of the company. */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
