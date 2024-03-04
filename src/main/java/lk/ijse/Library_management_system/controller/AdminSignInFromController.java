package lk.ijse.Library_management_system.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class AdminSignInFromController {

    @FXML
    private AnchorPane root;

    @FXML
    private TextField textUserName;

    @FXML
    private PasswordField textPassword;

    @FXML
    private Button btnBack;

    @FXML
    private ToggleButton btnToggle;

    @FXML
    private Label lableUserNameWarning;

    @FXML
    private Label lablePasswordWarning;

    @FXML
    void backBtnOnAction(ActionEvent event) {

    }

    @FXML
    void btnToggleOnAction(ActionEvent event) {

    }

    @FXML
    void signInBtnOnAction(ActionEvent event) {

    }

    @FXML
    void backBtnMouseEnterOnAction(MouseEvent event) {
        btnBack.setStyle("-fx-background-color: white;-fx-border-color: black; -fx-text-fill: black;");
    }

    @FXML
    void backBtnMouseExitOnAction(MouseEvent event) {
        btnBack.setStyle("-fx-background-color: #1e90ff; -fx-border-color: white; -fx-text-fill: white;");
    }

}