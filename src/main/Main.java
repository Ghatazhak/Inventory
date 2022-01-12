package main;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.*;
/** This class is where the program starts. */
public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/view/PrimaryView.fxml"));
        stage.setTitle("");
        stage.setScene(new Scene(root,873, 439));
        stage.show();
    }
    /** This is the main method. This is the first method that gets called when you run your java program. FUTURE ENHANCEMENTS: The Add parts/products views are disorganized and need to be rethought out.  */
    public static void main(String[] args){
        addsTestData();
        launch(args);
    }

    /** Test Data. Test data used for testing my implementation  */
    public static void addsTestData (){

        ObservableList testList = FXCollections.observableArrayList();
        Part gear = new InHouse(IDRecord.getNextPartID(),"gear",5.00,10,5,100, 3);
        Part chain = new InHouse(IDRecord.getNextPartID(),"chain",9.00,3,1,100, 4);
        Part wheel = new InHouse(IDRecord.getNextPartID(),"wheel",20.00,8,2,50, 5);
        Product bike = new Product(IDRecord.getNextProductID(),"Bike",200.00,10,2,20, testList);
        Inventory.addPart(gear);
        Inventory.addPart(chain);
        Inventory.addPart(wheel);
        Inventory.addProduct(bike);
    }




}

