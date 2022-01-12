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
import java.util.Optional;
import java.util.ResourceBundle;
/** This class is the controller for ModifyProduct.fxml */
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
    public TextField partSearchText;
    public Label partSearchResult;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        associatedParts = PrimaryView.tempAssociatedProduct.getAllAssociatedParts();
        allPartsView.setItems(Inventory.getAllParts());
        associatedPartsView.setItems(PrimaryView.tempAssociatedProduct.getAllAssociatedParts());

        allPartsIDCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        allPartsNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        allPartsStockCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        allPartsPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

        associatedPartsIDCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        associatedPartsNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        associatedPartsStockCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        associatedPartsPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

        modifyProductIDText.setText(String.valueOf(PrimaryView.tempAssociatedProduct.getId()));
        modifyProductNameText.setText(PrimaryView.tempAssociatedProduct.getName());
        modifyProductPriceText.setText(String.valueOf(PrimaryView.tempAssociatedProduct.getPrice()));
        modifyProductMinText.setText(String.valueOf(PrimaryView.tempAssociatedProduct.getMin()));
        modifyProductMaxText.setText(String.valueOf(PrimaryView.tempAssociatedProduct.getMax()));
        modifyProductStockText.setText(String.valueOf(PrimaryView.tempAssociatedProduct.getStock()));

    }



    public void cancelModifyProduct(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/PrimaryView.fxml"));
        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root,873,439);
        stage.setTitle("");
        stage.setScene(scene);
        stage.show();
    }



    /** This saves modified Products. This method uses the InputValidator to check user input and saves all the changes
      to the modified.  LOGICAL ERROR: I was getting a logical error when I modified a product, it would waste the product ID of the original. This was corrected
     below by using int variable called reusedID to preserve the original ID for the new modified verison of the product */
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
            int reuseID =  PrimaryView.tempAssociatedProduct.getId();
            Inventory.deleteProduct( PrimaryView.tempAssociatedProduct);
            Product newProduct = new Product(reuseID, modifyProductNameText.getText(), Double.parseDouble(modifyProductPriceText.getText()), Integer.parseInt(modifyProductStockText.getText()), Integer.parseInt(modifyProductMinText.getText()), Integer.parseInt(modifyProductMaxText.getText()), associatedParts);
            Inventory.addProduct(newProduct);
            Parent root = FXMLLoader.load(getClass().getResource("/view/PrimaryView.fxml"));
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(root, 873, 439);
            stage.setTitle("");
            stage.setScene(scene);
            stage.show();
            }
        }

    /** This method adds parts to a product. It has an alert box. */
    public void addPartToProduct(ActionEvent actionEvent) {
        Part part = (Part) allPartsView.getSelectionModel().getSelectedItem();
        if(part == null){
            Alert alert2 = new Alert(Alert.AlertType.ERROR);
            alert2.setTitle("No Part Selected");
            alert2.setContentText("Unable to add a part when none are selected");
            alert2.show();
            return;
        }
        associatedParts.add(part);
    }
    /** This method removes parts from a product. It has an alert box. */
    public void removePartFromProduct(ActionEvent actionEvent) {
        Part part = (Part) allPartsView.getSelectionModel().getSelectedItem();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "This will remove the part from the product. Is that ok?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
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
    /** This method allows you to search top part list. It allows partial string matches and integer id searchs and shows results */
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

        allPartsView.setItems(partsList);
        partSearchResult.setText(partsList.size() + " part(s) returned.");
        partSearchText.setText("");
    }
}
