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
        ObservableList<Part> allparts = Inventory.getAllParts();
        for (int i = 0; i < allparts.size(); i++) {
            Part part = allparts.get(i);
            if(part.getId() == partId){
                return part;
            }
        }
        return null;
    }

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
