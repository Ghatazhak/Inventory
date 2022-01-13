package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/** This class represents our product concrete class for product objects. */

public class Product {
    private  ObservableList<Part> associatedParts = FXCollections.observableArrayList();
    private int id;
    private String name;
    private double price;
    private int stock;
    private int min;
    private int max;
/** this is the constructor that is called when new is used.
 * @param id product id.
 * @param max maximum stock level.
 * @param min minimum stock level.
 * @param price price per product.
 * @param stock current stock level.
 * @param name name of product.
 * @param associatedParts a list of all parts associated with the product. */
    public Product(int id, String name, double price, int stock, int min, int max, ObservableList<Part> associatedParts) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.min = min;
        this.max = max;
        this.associatedParts = associatedParts;
    }
/** method to get product ids.
 * @return returns the product id.*/
    public int getId() {
        return id;
    }
/** method sets the id of the product.
 * @param id */
    public void setId(int id) {
        this.id = id;
    }
/** method to get the name of a product.
 * @return returns the name of the product in a string. */
    public String getName() {
        return name;
    }
/** method sets the name of the product.
 * @param name name of the product in a string. */
    public void setName(String name) {
        this.name = name;
    }
/**method gets the price of a product.
 * @return returns the price of the product in a double.*/
    public double getPrice() {
        return price;
    }
/**method sets the price of the product.
 * @param price the price to be set in double.*/
    public void setPrice(double price) {
        this.price = price;
    }
/**method gets the current stock level of the product.
 * @return returns the current stock level as an integer.*/
    public int getStock() {
        return stock;
    }
/** method sets the current stock level.
 * @param stock stock level as an integer */
    public void setStock(int stock) {
        this.stock = stock;
    }
/** method to get the minimum allowed stock level of the product.
 * @return returns the minimum stock level as an integer. */
    public int getMin() {
        return min;
    }
/** method to set the minimum stock level.
 * @param min minimum stock level as an integer.*/
    public void setMin(int min) {
        this.min = min;
    }
/** method to get the maximum stock level of the product.
 * @return returns the max stock level as an integer.*/
    public int getMax() {
        return max;
    }
/** method to set maximum stock level of the part.
 * @param max maximum stock level as an integer. */
    public void setMax(int max) {
        this.max = max;
    }
    /**method to add associated part to list.
     * @param part part to add.*/
    public void addAssociatedPart(Part part){
        associatedParts.add(part);
    }
/** method to delete associated part.
 * @param selectedAssociatedPart  part to delete.*/
    public boolean deleteAssociatedPart(Part selectedAssociatedPart) {

        return true;
    }
/** method to get all parts associated with a product.
 * @return returns a list of parts associated with a product.*/
    public ObservableList<Part> getAllAssociatedParts(){
        return this.associatedParts;
    }

}
