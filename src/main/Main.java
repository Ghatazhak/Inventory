package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.InHouse;
import model.Inventory;
import model.Part;
import model.PartIDRecord;

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
        System.out.println("Called");
        Part gear = new InHouse(PartIDRecord.getNextPartID(),"gear",5.00,10,5,100, 3);
        Part chain = new InHouse(PartIDRecord.getNextPartID(),"chain",9.00,3,1,100, 4);
        Part wheel = new InHouse(PartIDRecord.getNextPartID(),"wheel",20.00,8,2,50, 5);

        Inventory.addPart(gear);
        Inventory.addPart(chain);
        Inventory.addPart(wheel);
    }




}

