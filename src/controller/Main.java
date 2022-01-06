package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class Main implements Initializable {


    public TableView allParts;
    public TableColumn partId;
    public TableColumn allpartsID;
    public TableColumn allPartsName;
    public TableColumn allPartsStock;
    public TableColumn allPartsPrice;
    public TableView allProducts;
    public TableColumn allProductsName;
    public TableColumn allProductsID;
    public TableColumn AllProductsStock;
    public TableColumn allProductsPrice;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void addPartView(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/AddPart.fxml"));
        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root,480,515);
        stage.setTitle("");
        stage.setScene(scene);
        stage.show();
    }


    public void modifyPartView(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/ModifyPart.fxml"));
        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root,480,515);
        stage.setTitle("");
        stage.setScene(scene);
        stage.show();
    }

    public void addProductView(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/AddProduct.fxml"));
        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root,929,708);
        stage.setTitle("");
        stage.setScene(scene);
        stage.show();
    }

    public void modifyProductView(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/ModifyProduct.fxml"));
        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root,929,708);
        stage.setTitle("");
        stage.setScene(scene);
        stage.show();
    }

    public void exitApplication(ActionEvent actionEvent) {
        // TO DO
    }
}
