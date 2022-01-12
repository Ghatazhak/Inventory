package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

 public class Inventory {
    private static ObservableList<Part> allParts = FXCollections.observableArrayList();
    private static ObservableList<Product> allProducts = FXCollections.observableArrayList();

    public static void addPart(Part newPart){
        allParts.add(newPart);
    }

    public static void addProduct(Product newProduct){
        allProducts.add(newProduct);
    }

    public static Part lookupPart(int partId){
        return allParts.get(partId);
    }

    public static Product lookupProduct(int productId){
        return allProducts.get(productId);
    }

    public static ObservableList<Part> lookupPart(String name){
        //TO DO
        return null;
    }

    public static ObservableList<Product> lookupProduct(String productName){
        //TO DO
        return null;
    }

    public static void updatePart(int index, Part selectedPart){
        allParts.set(index, selectedPart);
    }

    public static void updateProduct(int index,Product newProduct){
        allProducts.set(index, newProduct);
    }

    public static boolean deletePart(Part selectedPart){
        if(selectedPart == null){
            return false;
        }
        allParts.remove(selectedPart);
        return true;
    }

    public static boolean deleteProduct(Product selectedProduct){
        if(selectedProduct == null){
            return false;
        }
        allProducts.remove(selectedProduct);
        return true;
    }

    public static ObservableList<Part> getAllParts(){
        return allParts;
    }

    public static ObservableList<Product> getAllProducts(){
        return allProducts;
    }
}
