package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Inventory;
import model.Part;

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

        associatedParts = Main.tempAssociatedParts.getAllAssociatedParts();
        allPartsView.setItems(Inventory.getAllParts());
        associatedPartsView.setItems(Main.tempAssociatedParts.getAllAssociatedParts());

        allPartsIDCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        allPartsNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        allPartsStockCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        allPartsPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

        associatedPartsIDCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        associatedPartsNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        associatedPartsStockCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        associatedPartsPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

        modifyProductIDText.setText(String.valueOf(Main.tempAssociatedParts.getId()));
        modifyProductNameText.setText(Main.tempAssociatedParts.getName());
        modifyProductPriceText.setText(String.valueOf(Main.tempAssociatedParts.getPrice()));
        modifyProductMinText.setText(String.valueOf(Main.tempAssociatedParts.getMin()));
        modifyProductMaxText.setText(String.valueOf(Main.tempAssociatedParts.getMax()));
        modifyProductStockText.setText(String.valueOf(Main.tempAssociatedParts.getStock()));

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
        Parent root = FXMLLoader.load(getClass().getResource("/view/Main.fxml"));
        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root,873,439);
        stage.setTitle("");
        stage.setScene(scene);
        stage.show();
    }

    public void addPartToProduct(ActionEvent actionEvent) {
        // TO DO
    }

    public void removePartFromProduct(ActionEvent actionEvent) {
        // TO DO
    }



}
