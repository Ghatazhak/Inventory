package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/** This class holds the global(static) Part and Product list */
 public class Inventory {
    private static ObservableList<Part> allParts = FXCollections.observableArrayList();
    private static ObservableList<Product> allProducts = FXCollections.observableArrayList();
/**method adds parts to observablelist.
 * @param newPart the part to add. */
    public static void addPart(Part newPart){
        allParts.add(newPart);
    }
/**method adds product to observablelist.
 * @param newProduct product to add.*/
    public static void addProduct(Product newProduct){
        allProducts.add(newProduct);
    }
/** method to look up part by ID.
 * @param partId part id to lookup.
 * @return returns part associated to the id, or null if not found. */
    public static Part lookupPart(int partId){
        ObservableList<Part> allparts = Inventory.getAllParts();
        for (int i = 0; i < allparts.size(); i++) {
            Part part = allparts.get(i);
            if(part.getId() == partId){
                return part;
            }
        }
        return null;
    }
/** method looks up products by product id.
 * @param productId product id to lookup.
 * @return returns a product associated with the id, or returns null. */
    public static Product lookupProduct(int productId){
        ObservableList<Product> allProducts = Inventory.getAllProducts();
        for (int i = 0; i < allProducts.size(); i++) {
            Product product = allProducts.get(i);
            if(product.getId() == productId){
                return product;
            }
        }
        return null;
    }
/** method looks up part by name.
 * @param name the name of the part.
 * @return returns an observablelist of all parts that matched the name.*/
    public static ObservableList<Part> lookupPart(String name){
        ObservableList<Part> namedParts = FXCollections.observableArrayList();
        ObservableList<Part> allParts = Inventory.getAllParts();
        for(Part part: allParts){
            if(part.getName().contains(name)){
                namedParts.add(part);
            }
        }
        return namedParts;
    }
/** method looks up products by name.
 * @param productName name to loopup.
 * @return returns observablelist of products that match the string. */
    public static ObservableList<Product> lookupProduct(String productName){
        ObservableList<Product> namedProducts = FXCollections.observableArrayList();
        ObservableList<Product> allProducts = Inventory.getAllProducts();
        for(Product product: allProducts){
            if(product.getName().contains(productName)){
                namedProducts.add(product);
            }
        }
        return namedProducts;
    }
/**method to update parts by index.
 * @param index index of part to update.
 * @param selectedPart  part to insert into the index.*/
    public static void updatePart(int index, Part selectedPart){
        allParts.set(index, selectedPart);
    }
    /**method to update parts by index.
     * @param index index of part to update.
     * @param newProduct  part to insert into the index.*/
    public static void updateProduct(int index,Product newProduct){
        allProducts.set(index, newProduct);
    }
/** method to delete part by selected part.
 * @param selectedPart part selected.
 * @return returns boolean on whether deletion was successful. */
    public static boolean deletePart(Part selectedPart){
        if(selectedPart == null){
            return false;
        }
        allParts.remove(selectedPart);
        return true;
    }
/** method to delete product by selected product.
 * @param selectedProduct  selected product.
 * @return returns boolean on whether the deletion was successful or not. */
    public static boolean deleteProduct(Product selectedProduct){
        if(selectedProduct == null){
            return false;
        }
        allProducts.remove(selectedProduct);
        return true;
    }
/**method to get all parts in inventory.
 * @return  returns observablelist of all parts*/
    public static ObservableList<Part> getAllParts(){
        return allParts;
    }
    /**method to get all products in inventory.
     * @return  returns observablelist of all products*/
    public static ObservableList<Product> getAllProducts(){
        return allProducts;
    }
}
