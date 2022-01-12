package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ModifyProduct implements Initializable {
    public ObservableList<Part> associatedParts = FXCollections.observableArrayList();
    public Button addPartButton;
    public Button removePartButton;
    public TableColumn associatedPartsNameCol;
    public TableColumn associatedPartsStockCol;
    public TableColumn associatedPartsPriceCol;
    public TableColumn allPartsIDCol;
    public TableColumn allPartsNameCol;
    public TableColumn allPartsStockCol;
    public TableColumn allPartsPriceCol;
    public TableView associatedPartsView;
    public TableView allPartsView;
    public TableColumn associatedPartsIDCol;
    public TextField modifyProductIDText;
    public TextField modifyProductMinText;
    public TextField modifyProductPriceText;
    public TextField modifyProductNameText;
    public TextField modifyProductStockText;
    public TextField modifyProductMaxText;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        associatedParts = Main.tempAssociatedProduct.getAllAssociatedParts();
        allPartsView.setItems(Inventory.getAllParts());
        associatedPartsView.setItems(Main.tempAssociatedProduct.getAllAssociatedParts());

        allPartsIDCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        allPartsNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        allPartsStockCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        allPartsPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

        associatedPartsIDCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        associatedPartsNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        associatedPartsStockCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        associatedPartsPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

        modifyProductIDText.setText(String.valueOf(Main.tempAssociatedProduct.getId()));
        modifyProductNameText.setText(Main.tempAssociatedProduct.getName());
        modifyProductPriceText.setText(String.valueOf(Main.tempAssociatedProduct.getPrice()));
        modifyProductMinText.setText(String.valueOf(Main.tempAssociatedProduct.getMin()));
        modifyProductMaxText.setText(String.valueOf(Main.tempAssociatedProduct.getMax()));
        modifyProductStockText.setText(String.valueOf(Main.tempAssociatedProduct.getStock()));

    }



    public void cancelModifyProduct(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/Main.fxml"));
        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root,873,439);
        stage.setTitle("");
        stage.setScene(scene);
        stage.show();
    }




    public void saveModifyProduct(ActionEvent actionEvent) throws IOException {
        if (!InputValidator.intValidator(modifyProductStockText.getText()) || !InputValidator.intValidator(modifyProductMinText.getText()) || !InputValidator.intValidator(modifyProductMaxText.getText()) || !InputValidator.doubleValidator(modifyProductPriceText.getText())) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Something is not a number");
            alert.setContentText("One or more if the following are not numbers or blank: Inv, Min, Max, or Price");
            alert.show();
            return;

        } else if (Integer.parseInt(modifyProductStockText.getText()) > Integer.parseInt(modifyProductMaxText.getText()) || Integer.parseInt(modifyProductStockText.getText()) < Integer.parseInt(modifyProductMinText.getText())) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Inventory Levels out of Range Error");
            alert.setContentText("Inv cannot be higher than max or lower than min!");
            alert.show();
            return;

        } else {
            Inventory.deleteProduct(Main.tempAssociatedProduct);
            Product newProduct = new Product(IDRecord.getNextProductID(), modifyProductNameText.getText(), Double.parseDouble(modifyProductPriceText.getText()), Integer.parseInt(modifyProductStockText.getText()), Integer.parseInt(modifyProductMinText.getText()), Integer.parseInt(modifyProductMaxText.getText()), associatedParts);
            Inventory.addProduct(newProduct);
            Parent root = FXMLLoader.load(getClass().getResource("/view/Main.fxml"));
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(root, 873, 439);
            stage.setTitle("");
            stage.setScene(scene);
            stage.show();
            }
        }


    public void addPartToProduct(ActionEvent actionEvent) {
        Part part = (Part) allPartsView.getSelectionModel().getSelectedItem();
        if(part == null){
            return;
        }
        associatedParts.add(part);
    }

    public void removePartFromProduct(ActionEvent actionEvent) {
        Part part = (Part) associatedPartsView.getSelectionModel().getSelectedItem();
        if(part == null){
            return;
        }
        associatedParts.remove(part);
    }



}
