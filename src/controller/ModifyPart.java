package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import model.InHouse;
import model.Inventory;
import model.OutSourced;
import model.Part;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ModifyPart implements Initializable {
    public Part modifiedPart;
    public RadioButton inHouse;
    public RadioButton outSourced;
    public Label inHouseMachineIDLabel;
    public Label outSourcedCompanyNameLabel;
    public TextField outSourcedCompanyNameTextField;
    public TextField inHouseMachineIDTextField;
    public ToggleGroup inHouseOutSourced;
    public TextField modifyPartNameText;
    public TextField modifyPartIDText;
    public TextField modifyPartStockText;
    public TextField modifyPartPriceText;
    public TextField modifyPartMaxText;
    public TextField modifyPartMinText;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        modifyPartIDText.setText(String.valueOf(Main.tempAssociatedPart.getId()));
        modifyPartNameText.setText(String.valueOf(Main.tempAssociatedPart.getName()));
        modifyPartPriceText.setText(String.valueOf(Main.tempAssociatedPart.getPrice()));
        modifyPartStockText.setText(String.valueOf(Main.tempAssociatedPart.getStock()));
        modifyPartMinText.setText(String.valueOf(Main.tempAssociatedPart.getMin()));
        modifyPartMaxText.setText(String.valueOf(Main.tempAssociatedPart.getMax()));

        if(Main.tempAssociatedPart instanceof InHouse){
            inHouse.setSelected(true);
            outSourcedCompanyNameTextField.setVisible(false);
            outSourcedCompanyNameLabel.setVisible(false);
            inHouseMachineIDTextField.setVisible(true);
            inHouseMachineIDLabel.setVisible(true);
            inHouseMachineIDTextField.setText(String.valueOf(((InHouse) Main.tempAssociatedPart).getMachineId()));

        } else if(Main.tempAssociatedPart instanceof OutSourced) {
            outSourced.setSelected(true);
            inHouseMachineIDTextField.setVisible(false);
            inHouseMachineIDLabel.setVisible(false);
            outSourcedCompanyNameTextField.setVisible(true);
            outSourcedCompanyNameLabel.setVisible(true);
            outSourcedCompanyNameTextField.setText(String.valueOf(((OutSourced) Main.tempAssociatedPart).getCompanyName()));
        }
    }

    public void saveModifyPart(ActionEvent actionEvent) throws IOException {
        int id = Main.tempAssociatedPart.getId();

        Main.tempAssociatedPart.setName(modifyPartNameText.getText());
        Main.tempAssociatedPart.setStock(Integer.parseInt(modifyPartStockText.getText()));
        Main.tempAssociatedPart.setMin(Integer.parseInt(modifyPartMinText.getText()));
        Main.tempAssociatedPart.setMax(Integer.parseInt(modifyPartMaxText.getText()));
        Main.tempAssociatedPart.setPrice(Double.parseDouble(modifyPartPriceText.getText()));
        if(Main.tempAssociatedPart instanceof InHouse){
            ((InHouse) Main.tempAssociatedPart).setMachineId(Integer.parseInt(inHouseMachineIDTextField.getText()));
        } else {
            ((OutSourced) Main.tempAssociatedPart).setCompanyName((outSourcedCompanyNameTextField.getText()));
        }

        int inbox = -1;
        for (Part tempAssociatedPart: Inventory.getAllParts()){
            inbox++;
            if(tempAssociatedPart.getId() == id){
                Inventory.getAllParts().set(inbox,tempAssociatedPart);
                break;
            }
        }

        Parent root = FXMLLoader.load(getClass().getResource("/view/Main.fxml"));
        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root,873,439);
        stage.setTitle("");
        stage.setScene(scene);
        stage.show();
    }

    public void cancelModifyPart(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/Main.fxml"));
        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root,873,439);
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
