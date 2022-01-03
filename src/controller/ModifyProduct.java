package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ModifyProduct {

    public void cancelModifyProduct(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/Main.fxml"));
        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root,873,439);
        // main 873 439
        stage.setTitle("");
        stage.setScene(scene);
        stage.show();
    }

    public void saveModifyProduct(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/Main.fxml"));
        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root,873,439);
        // main 873 439
        stage.setTitle("");
        stage.setScene(scene);
        stage.show();
    }

    public void associatePart(ActionEvent actionEvent) {
        // TO DO
    }

    public void unassociatePart(ActionEvent actionEvent) {
        // TO DO
    }


}
