package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import model.*;

import java.io.IOException;

public class AddPart {

    public RadioButton inHouse;
    public RadioButton outSourced;
    public ToggleGroup inHouseOutSourced;
    public Label machineIDLabel;
    public TextField machineIDText;
    public Label companyNameLabel;
    public TextField companyNameTextField;
    //public TextField partId;
    public TextField nameText;
    public TextField stockText;
    public TextField priceText;
    public TextField maxStockText;
    public TextField minStockText;


    public void saveAddPart(ActionEvent actionEvent) throws IOException {
        if(inHouse.isSelected()){
            Part newPart = new InHouse(PartIDRecord.getNextPartID(), nameText.getText(),Integer.parseInt(priceText.getText()),Integer.parseInt(stockText.getText()),Integer.parseInt(minStockText.getText()),Integer.parseInt(maxStockText.getText()),Integer.parseInt(machineIDText.getText()));
            Inventory.addPart(newPart);
        } else if(outSourced.isSelected()){
            Part newPart = new OutSourced(PartIDRecord.getNextPartID(),nameText.getText(),Integer.parseInt(priceText.getText()),Integer.parseInt(stockText.getText()),Integer.parseInt(minStockText.getText()),Integer.parseInt(maxStockText.getText()),companyNameTextField.getText());
            Inventory.addPart(newPart);
        }





        Parent root = FXMLLoader.load(getClass().getResource("/view/Main.fxml"));
        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root,873,439);
        stage.setTitle("");
        stage.setScene(scene);
        stage.show();
    }

    public void cancelAddPart(ActionEvent actionEvent)  {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/Main.fxml"));
            Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(root,873,439);
            stage.setTitle("");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e){
            System.out.println("No such FXML File");
        }
    }

    public void inHouse(ActionEvent actionEvent) {
        machineIDLabel.setVisible(true);
        machineIDText.setVisible(true);
        companyNameLabel.setVisible(false);
        companyNameTextField.setVisible(false);
    }

    public void outSourced(ActionEvent actionEvent) {
        companyNameLabel.setVisible(true);
        companyNameTextField.setVisible(true);
        machineIDLabel.setVisible(false);
        machineIDText.setVisible(false);

    }

}
