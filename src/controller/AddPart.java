package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
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
            if(!InputValidator.intValidator(stockText.getText()) || !InputValidator.intValidator(minStockText.getText()) || !InputValidator.intValidator(maxStockText.getText()) || !InputValidator.intValidator(machineIDText.getText())){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Something is not a number");
                alert.setContentText("One or more if the following are not numbers: Inv, Min, Max, Price, or Machine ID");
                alert.show();

            } else if(Integer.parseInt(stockText.getText()) > Integer.parseInt(maxStockText.getText()) || Integer.parseInt(stockText.getText()) < Integer.parseInt(minStockText.getText())) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Inventory Levels out of Range Error");
                alert.setContentText("Inv cannot be higher than max or lower than min!");
                alert.show();

            } else {
                Part newPart = new InHouse(IDRecord.getNextPartID(), nameText.getText(),Integer.parseInt(priceText.getText()),Integer.parseInt(stockText.getText()),Integer.parseInt(minStockText.getText()),Integer.parseInt(maxStockText.getText()),Integer.parseInt(machineIDText.getText()));
                Inventory.addPart(newPart);
                Parent root = FXMLLoader.load(getClass().getResource("/view/Main.fxml"));
                Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
                Scene scene = new Scene(root,873,439);
                stage.setTitle("");
                stage.setScene(scene);
                stage.show();
            }

        } else if(outSourced.isSelected()){
            if(!InputValidator.intValidator(stockText.getText()) || !InputValidator.intValidator(minStockText.getText()) || !InputValidator.intValidator(maxStockText.getText())){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Something is not a number or empty");
                alert.setContentText("One or more if the following are not numbers or blank: Inv, Min, Max, or Price");
                alert.show();
                return;

            } else if(Integer.parseInt(stockText.getText()) > Integer.parseInt(maxStockText.getText()) || Integer.parseInt(stockText.getText()) < Integer.parseInt(minStockText.getText())) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Inventory Levels out of Range Error");
                alert.setContentText("Inv cannot be higher than max or lower than min!");
                alert.show();
                return;
            } else {
                Part newPart = new OutSourced(IDRecord.getNextPartID(),nameText.getText(),Integer.parseInt(priceText.getText()),Integer.parseInt(stockText.getText()),Integer.parseInt(minStockText.getText()),Integer.parseInt(maxStockText.getText()),companyNameTextField.getText());
                Inventory.addPart(newPart);
                Parent root = FXMLLoader.load(getClass().getResource("/view/Main.fxml"));
                Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
                Scene scene = new Scene(root,873,439);
                stage.setTitle("");
                stage.setScene(scene);
                stage.show();
            }
        }
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
