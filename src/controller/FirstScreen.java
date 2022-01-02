package controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class FirstScreen implements Initializable {
    public Label theLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        theLabel.setText("Initialized");
    }

    public void onButtonAction(ActionEvent actionEvent) {
        System.out.println("I am clicked");
        theLabel.setText("You clicked it!");
    }
}
