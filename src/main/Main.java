package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.InHouse;
import model.Inventory;

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
        InHouse gear = new InHouse(1,"gear",5.00,10,5,100, 3);
        InHouse chain = new InHouse(1,"chain",9.00,3,1,100, 4);
        Inventory.addPart(gear);
        Inventory.addPart(chain);
    }




}

