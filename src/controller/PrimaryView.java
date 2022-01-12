package controller;

import javafx.application.Platform;
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
import model.Inventory;
import model.Part;
import model.Product;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

/** This class is the controller for the PrimaryView.fxml */
public class PrimaryView implements Initializable {

    public static Product tempAssociatedProduct;
    public static Part tempAssociatedPart;

    @FXML
    public TableColumn<Part, Integer> allpartsIDCol;

    @FXML
    public TableColumn<Part, String> allPartsNameCol;

    @FXML
    public TableColumn<Part, Integer> allPartsStockCol;

    @FXML
    public TableColumn<Part, Integer> allPartsPriceCol;

    @FXML
    public TableColumn<Part, Integer> allProductsIDCol;

    @FXML
    public TableColumn<Part, String> allProductsNameCol;

    @FXML
    public TableColumn<Part, Integer> AllProductsStockCol;

    @FXML
    public TableColumn<Part, Integer> allProductsPriceCol;

    @FXML
    public TableView allProductsTableView;

    @FXML
    public TableView allPartsTableView;
    public TextField partsSearchText;
    public TextField productSearchText;
    public Label partsSearchResults;
    public Label productSearchResults;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        allPartsTableView.setItems(Inventory.getAllParts());
        allProductsTableView.setItems(Inventory.getAllProducts());
        allpartsIDCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        allPartsNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        allPartsStockCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        allPartsPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        allProductsIDCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        allProductsNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        AllProductsStockCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        allProductsPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));


    }
    /** This method takes to you to the add part view. Nothing follows. */
    public void addPartView(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/AddPart.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 480, 515);
        stage.setTitle("");
        stage.setScene(scene);
        stage.show();
    }

    /** This method takes you to the modify part view. It also loads the selected part to modify */
    public void modifyPartView(ActionEvent actionEvent) throws IOException {
        tempAssociatedPart = (Part) allPartsTableView.getSelectionModel().getSelectedItem();

        if(tempAssociatedPart == null){
            return;
        }

        Parent root = FXMLLoader.load(getClass().getResource("/view/ModifyPart.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 480, 515);
        stage.setTitle("");
        stage.setScene(scene);
        stage.show();
    }

    /** This method shows the add product view. Nothing follows
     * @param actionEvent
     * */
    public void addProductView(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/AddProduct.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 929, 708);
        stage.setTitle("");
        stage.setScene(scene);
        stage.show();
    }
    /** This method loads the modify product view. It also loads the selected product for editing  */
    public void modifyProductView(ActionEvent actionEvent) throws IOException {
        tempAssociatedProduct = (Product) allProductsTableView.getSelectionModel().getSelectedItem();

        if(tempAssociatedProduct == null){
            return;
        }

        Parent root = FXMLLoader.load(getClass().getResource("/view/ModifyProduct.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 929, 708);
        stage.setTitle("");
        stage.setScene(scene);
        stage.show();
    }
    /** This method exits the application. Exits the application */
    public void exitApplication(ActionEvent actionEvent) {
        Platform.exit();
    }

    public void deletePart(ActionEvent actionEvent) {
        Part part = (Part) allPartsTableView.getSelectionModel().getSelectedItem();
        if(part == null || Inventory.getAllParts().isEmpty()){
            Alert alert2 = new Alert(Alert.AlertType.ERROR);
            alert2.setTitle("No Product Selected");
            alert2.setContentText("Unable to delete a product when none are selected");
            alert2.show();
            return;
        }
        Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION,"This will delete the selected Product. Do you want to continue?");
        Optional<ButtonType> result = alert1.showAndWait();
        if(result.isPresent() && result.get() == ButtonType.OK){
        Inventory.deletePart(part);
        }
    }

    public void deleteProduct(ActionEvent actionEvent) {
        Product product = (Product) allProductsTableView.getSelectionModel().getSelectedItem();
        if(product == null){
            Alert alert2 = new Alert(Alert.AlertType.ERROR);
            alert2.setTitle("No Product Selected");
            alert2.setContentText("Unable to delete a product when none are selected");
            alert2.show();
            return;
        }
        Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION,"This will delete the selected Product. Do you want to continue?");
        Optional<ButtonType> result = alert1.showAndWait();

        if(result.isPresent() && result.get() == ButtonType.OK){

            if(product.getAllAssociatedParts().isEmpty()){
                Inventory.deleteProduct(product);
            } else {
                Alert alert3 = new Alert(Alert.AlertType.ERROR);
                alert3.setTitle("Associated Parts");
                alert3.setContentText("Unable to delete Products with Associated parts. Please remove all parts before deleting.");
                alert3.show();

            }
        }
    }

    public void onPartsSearch(ActionEvent actionEvent) {
        String q = partsSearchText.getText();
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
        partsSearchResults.setText(partsList.size() + " part(s) returned.");
        partsSearchText.setText("");
    }


    public void onProductSearch(ActionEvent actionEvent) {
        String q = productSearchText.getText();
        ObservableList<Product> productsList = Inventory.lookupProduct(q);
        if(productsList.size() == 0){
            try {
                int id = Integer.parseInt(q);
                Product product = Inventory.lookupProduct(id);
                if (product != null) {
                    productsList.add(product);
                }
            }
            catch (NumberFormatException e){
                //ignore
            }
        }

        allProductsTableView.setItems(productsList);
        productSearchResults.setText(productsList.size() + " product(s) returned.");
        productSearchText.setText("");
    }
}



