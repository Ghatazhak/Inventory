package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
import java.util.Optional;
import java.util.ResourceBundle;
/** This class is the controller for AddProducts.fxml */
public class AddProduct implements Initializable {
    public ObservableList<Part> associatedParts = FXCollections.observableArrayList();
    public TableView allPartsTableView;
    public TableView associatedPartsView;
    public TextField productNameText;
    public TextField productMaxStockText;
    public TextField productMinStockText;
    public TextField productPriceText;
    public TextField productStockText;

    @FXML
    public TableColumn<Part, Integer> associatedPartIDCol;
    public TableColumn associatedPartNameCol;
    public TableColumn associatedPartStockCol;
    public TableColumn associatedPartPriceCol;
    public TableColumn allPartIDCol;
    public TableColumn allPartNameCol;
    public TableColumn allPartStockCol;
    public TableColumn allPartPriceCol;
    public TextField partSearchText;
    public Label partSearchResult;


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

        if(!InputValidator.intValidator(productStockText.getText()) || !InputValidator.intValidator(productMinStockText.getText()) || !InputValidator.intValidator(productMaxStockText.getText()) || !InputValidator.doubleValidator(productPriceText.getText())){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Something is not a number");
            alert.setContentText("One or more if the following are not numbers or blank: Inv, Min, Max, or Price");
            alert.show();
            return;
        } else if(Integer.parseInt(productStockText.getText()) > Integer.parseInt(productMaxStockText.getText()) || Integer.parseInt(productStockText.getText()) < Integer.parseInt(productMinStockText.getText())) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Inventory Levels out of Range Error");
            alert.setContentText("Inv cannot be higher than max or lower than min!");
            alert.show();
            return;
        } else {
            Product newProduct = new Product(IDRecord.getNextProductID(), productNameText.getText() ,Double.parseDouble(productPriceText.getText()),Integer.parseInt(productStockText.getText()),Integer.parseInt(productMinStockText.getText()),Integer.parseInt(productMaxStockText.getText()),associatedParts);
            Inventory.addProduct(newProduct);
            Parent root = FXMLLoader.load(getClass().getResource("/view/PrimaryView.fxml"));
            Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(root,873,439);
            stage.setTitle("");
            stage.setScene(scene);
            stage.show();
        }
    }

    public void cancelProduct(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/PrimaryView.fxml"));
        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root,873,439);
        stage.setTitle("");
        stage.setScene(scene);
        stage.show();
    }

    public void addPart(ActionEvent actionEvent) {
        Part part = (Part) allPartsTableView.getSelectionModel().getSelectedItem();
        if(part == null){
            Alert alert2 = new Alert(Alert.AlertType.ERROR);
            alert2.setTitle("No Part Selected");
            alert2.setContentText("Unable to add a part when none are selected");
            alert2.show();
            return;
        }
        associatedParts.add(part);
    }

    public void removePart(ActionEvent actionEvent) {
        Part part = (Part) allPartsTableView.getSelectionModel().getSelectedItem();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"This will remove the part from the product. Is that ok?");
        Optional<ButtonType> result = alert.showAndWait();
        if(result.isPresent() && result.get() == ButtonType.OK){
            if(part == null || associatedParts.isEmpty()){
                Alert alert2 = new Alert(Alert.AlertType.ERROR);
                alert2.setTitle("No Part Selected");
                alert2.setContentText("Unable to remove a part when none are selected");
                alert2.show();
                return;
            }
            associatedParts.remove(part);
        }
    }


    public void onPartSearch(ActionEvent actionEvent) {
        String q = partSearchText.getText();
        ObservableList<Part> partsList = Inventory.lookupPart(q);
        if(partsList.size() == 0){
            try {
                int id = Integer.parseInt(q);
                Part part = Inventory.lookupPart(id);
                if (part != null) {
                    partsList.add(part);
                }
            }
            catch (NumberFormatException e){
                //ignore
            }
        }

        allPartsTableView.setItems(partsList);
        partSearchResult.setText(partsList.size() + " part(s) returned.");
        partSearchText.setText("");
    }
}
