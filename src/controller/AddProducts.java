package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddProducts implements Initializable {
    public ObservableList<Part> associatedParts = FXCollections.observableArrayList();

    public TableView allPartsTableView;
    public TableView associatedPartsView;
    public TextField productNameText;
    public TextField productMaxStockText;
    public TextField productMinStockText;
    public TextField productPriceText;
    public TextField productStockText;
    public TableColumn associatedPartIDCol;
    public TableColumn associatedPartNameCol;
    public TableColumn associatedPartStockCol;
    public TableColumn associatedPartPriceCol;
    public TableColumn allPartIDCol;
    public TableColumn allPartNameCol;
    public TableColumn allPartStockCol;
    public TableColumn allPartPriceCol;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        allPartsTableView.setItems(Inventory.getAllParts());
        associatedPartsView.setItems(associatedParts);


        allPartIDCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        allPartNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        allPartStockCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        allPartPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

        associatedPartIDCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        associatedPartNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        associatedPartStockCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        associatedPartPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
    }

    public void saveProduct(ActionEvent actionEvent) throws IOException {




        if(!InputValidator.intValidator(productStockText.getText()) || !InputValidator.intValidator(productMinStockText.getText()) || !InputValidator.intValidator(productMaxStockText.getText())){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Something is not a number");
            alert.setContentText("One or more if the following are not numbers: Inv, Min, Max, or Price");
            alert.show();

        } else if(Integer.parseInt(productStockText.getText()) > Integer.parseInt(productMaxStockText.getText()) || Integer.parseInt(productStockText.getText()) < Integer.parseInt(productMinStockText.getText())) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Inventory Levels out of Range Error");
            alert.setContentText("Inv cannot be higher than max or lower than min!");
            alert.show();

        } else {
            Product newProduct = new Product(IDRecord.getNextProductID(), productNameText.getText() ,Integer.parseInt(productPriceText.getText()),Integer.parseInt(productStockText.getText()),Integer.parseInt(productMinStockText.getText()),Integer.parseInt(productMaxStockText.getText()));
            Inventory.addProduct(newProduct);
            Parent root = FXMLLoader.load(getClass().getResource("/view/Main.fxml"));
            Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(root,873,439);
            stage.setTitle("");
            stage.setScene(scene);
            stage.show();
        }

    }

    public void cancelProduct(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/Main.fxml"));
        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root,873,439);
        stage.setTitle("");
        stage.setScene(scene);
        stage.show();
    }

    public void addPart(ActionEvent actionEvent) {
        Part part = (Part) allPartsTableView.getSelectionModel().getSelectedItem();
        if(part == null){
            return;
        }
        associatedParts.add(part);
    }

    public void removePart(ActionEvent actionEvent) {
        Part part = (Part) allPartsTableView.getSelectionModel().getSelectedItem();
        if(part == null){
            return;
        }
        associatedParts.remove(part);
    }


}
