package main;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.*;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/view/Main.fxml"));
        stage.setTitle("");
        stage.setScene(new Scene(root,873, 439));
        stage.show();
    }

    public static void main(String[] args){
        addsTestData();
        launch(args);
    }
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

