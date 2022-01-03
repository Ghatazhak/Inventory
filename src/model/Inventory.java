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

        return null;
    }

    public static Product lookupProduct(int productId){

        return null;
    }

    public static ObservableList<Part> lookupPart(String name){

        return null;
    }

    public static ObservableList<Product> lookupProduct(String productName){

        return null;
    }

    public static void updatePart(int index, Part selectedPart){

    }

    public static void updateProduct(int index,Product newProduct){

    }

    public static boolean deletePart(Part selectedPart){

        return false;
    }

    public static boolean deleteProduct(Product selectedProduct){

        return false;
    }

    public static ObservableList<Part> getAllParts(){

        return null;
    }

    public static ObservableList<Product> getAllProducts(){

        return null;
    }
    static {
        addsTestData();
    }
     public static void addsTestData (){
         System.out.println("Called");
         InHouse gear = new InHouse(1,"gear",5.00,10,5,100, 3);
         InHouse chain = new InHouse(1,"chain",9.00,3,1,100, 4);
         Inventory.addPart(gear);
         Inventory.addPart(chain);
     }
}
