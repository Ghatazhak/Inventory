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
/** This class is the controller for ModifyPart.fxml */
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
        modifyPartIDText.setText(String.valueOf(PrimaryView.tempAssociatedPart.getId()));
        modifyPartNameText.setText(String.valueOf(PrimaryView.tempAssociatedPart.getName()));
        modifyPartPriceText.setText(String.valueOf(PrimaryView.tempAssociatedPart.getPrice()));
        modifyPartStockText.setText(String.valueOf(PrimaryView.tempAssociatedPart.getStock()));
        modifyPartMinText.setText(String.valueOf(PrimaryView.tempAssociatedPart.getMin()));
        modifyPartMaxText.setText(String.valueOf(PrimaryView.tempAssociatedPart.getMax()));

        if(PrimaryView.tempAssociatedPart instanceof InHouse){
            inHouse.setSelected(true);
            outSourcedCompanyNameTextField.setVisible(false);
            outSourcedCompanyNameLabel.setVisible(false);
            inHouseMachineIDTextField.setVisible(true);
            inHouseMachineIDLabel.setVisible(true);
            inHouseMachineIDTextField.setText(String.valueOf(((InHouse) PrimaryView.tempAssociatedPart).getMachineId()));

        } else if(PrimaryView.tempAssociatedPart instanceof OutSourced) {
            outSourced.setSelected(true);
            inHouseMachineIDTextField.setVisible(false);
            inHouseMachineIDLabel.setVisible(false);
            outSourcedCompanyNameTextField.setVisible(true);
            outSourcedCompanyNameLabel.setVisible(true);
            outSourcedCompanyNameTextField.setText(String.valueOf(((OutSourced) PrimaryView.tempAssociatedPart).getCompanyName()));
        }
    }
    /** This method saves the modified part. It will return you to the primary view. */
    public void saveModifyPart(ActionEvent actionEvent) throws IOException {
        int id = PrimaryView.tempAssociatedPart.getId();

        PrimaryView.tempAssociatedPart.setName(modifyPartNameText.getText());
        PrimaryView.tempAssociatedPart.setStock(Integer.parseInt(modifyPartStockText.getText()));
        PrimaryView.tempAssociatedPart.setMin(Integer.parseInt(modifyPartMinText.getText()));
        PrimaryView.tempAssociatedPart.setMax(Integer.parseInt(modifyPartMaxText.getText()));
        PrimaryView.tempAssociatedPart.setPrice(Double.parseDouble(modifyPartPriceText.getText()));
        if(PrimaryView.tempAssociatedPart instanceof InHouse){
            ((InHouse) PrimaryView.tempAssociatedPart).setMachineId(Integer.parseInt(inHouseMachineIDTextField.getText()));
        } else {
            ((OutSourced) PrimaryView.tempAssociatedPart).setCompanyName((outSourcedCompanyNameTextField.getText()));
        }

        int inbox = -1;
        for (Part tempAssociatedPart: Inventory.getAllParts()){
            inbox++;
            if(tempAssociatedPart.getId() == id){
                Inventory.getAllParts().set(inbox,tempAssociatedPart);
                break;
            }
        }

        Parent root = FXMLLoader.load(getClass().getResource("/view/PrimaryView.fxml"));
        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root,873,439);
        stage.setTitle("");
        stage.setScene(scene);
        stage.show();
    }
    /** This method cancels the modify part screen. It will return you to the primary view*/
    public void cancelModifyPart(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/PrimaryView.fxml"));
        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root,873,439);
        stage.setTitle("");
        stage.setScene(scene);
        stage.show();
    }
    /** This method changes the visibility of the radio buttons. Inhouse */
    public void inHouse(ActionEvent actionEvent) {
        inHouseMachineIDLabel.setVisible(true);
        inHouseMachineIDTextField.setVisible(true);
        outSourcedCompanyNameLabel.setVisible(false);
        outSourcedCompanyNameTextField.setVisible(false);
    }
    /** This method changes the visibility of the radio buttons. Outsourced */
    public void outSourced(ActionEvent actionEvent) {
        outSourcedCompanyNameLabel.setVisible(true);
        outSourcedCompanyNameTextField.setVisible(true);
        inHouseMachineIDLabel.setVisible(false);
        inHouseMachineIDTextField.setVisible(false);
    }


}
