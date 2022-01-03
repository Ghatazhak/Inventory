package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ModifyPart {
    public RadioButton inHouse;
    public RadioButton outSourced;
    public Label inHouseMachineIDLabel;
    public Label outSourcedCompanyNameLabel;
    public TextField outSourcedCompanyNameTextField;
    public TextField inHouseMachineIDTextField;

    public void saveModifyPart(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/Main.fxml"));
        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root,873,439);
        // main 873 439
        stage.setTitle("");
        stage.setScene(scene);
        stage.show();
    }

    public void cancelModifyPart(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/Main.fxml"));
        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root,873,439);
        // main 873 439
        stage.setTitle("");
        stage.setScene(scene);
        stage.show();
    }

    public void inHouse(ActionEvent actionEvent) {
        inHouseMachineIDLabel.setVisible(true);
        inHouseMachineIDTextField.setVisible(true);
        outSourcedCompanyNameLabel.setVisible(false);
        outSourcedCompanyNameTextField.setVisible(false);
    }

    public void outSourced(ActionEvent actionEvent) {
        outSourcedCompanyNameLabel.setVisible(true);
        outSourcedCompanyNameTextField.setVisible(true);
        inHouseMachineIDLabel.setVisible(false);
        inHouseMachineIDTextField.setVisible(false);
    }
}
