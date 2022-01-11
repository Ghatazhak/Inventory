package controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Inventory;
import model.Part;
import model.Product;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class Main implements Initializable {

    public TableView allParts;
    public TableColumn allpartsIDCol;
    public TableColumn allPartsNameCol;
    public TableColumn allPartsStockCol;
    public TableColumn allPartsPriceCol;
    public TableView allProducts;
    public TableColumn allProductsIDCol;
    public TableColumn allProductsNameCol;
    public TableColumn AllProductsStockCol;
    public TableColumn allProductsPriceCol;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        allParts.setItems(Inventory.getAllParts());
        allProducts.setItems(Inventory.getAllProducts());

        allpartsIDCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        allPartsNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        allPartsStockCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        allPartsPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

        allProductsIDCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        allProductsNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        AllProductsStockCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        allProductsPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));


    }

    public void addPartView(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/AddPart.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 480, 515);
        stage.setTitle("");
        stage.setScene(scene);
        stage.show();
    }


    public void modifyPartView(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/ModifyPart.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 480, 515);
        stage.setTitle("");
        stage.setScene(scene);
        stage.show();
    }

    public void addProductView(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/AddProduct.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 929, 708);
        stage.setTitle("");
        stage.setScene(scene);
        stage.show();
    }

    public void modifyProductView(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/ModifyProduct.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 929, 708);
        stage.setTitle("");
        stage.setScene(scene);
        stage.show();
    }

    public void exitApplication(ActionEvent actionEvent) {
        Platform.exit();
    }

    public void deletePart(ActionEvent actionEvent) {
        Part part = (Part) allParts.getSelectionModel().getSelectedItem();
        Inventory.deletePart(part);
    }

    public void deleteProduct(ActionEvent actionEvent) {
        Product product = (Product) allProducts.getSelectionModel().getSelectedItem();
        Inventory.deleteProduct(product);
    }
}



