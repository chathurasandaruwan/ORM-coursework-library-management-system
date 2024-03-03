package lk.ijse.Library_management_system.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class UserSignInFromController {
    @FXML
    private AnchorPane root;

    @FXML
    private TextField textUserName;

    @FXML
    private PasswordField textPassword;

    @FXML
    private ToggleButton btnToggle;

    @FXML
    private Label lableUserNameWarning;

    @FXML
    private Label lablePasswordWarning;
    @FXML
    private Button btnSignUp;

    @FXML
    void signInBtnOnAction(ActionEvent event) {
        System.out.println("Sign In");
    }

    @FXML
    void signUpBtnMouseEnterOnAction(MouseEvent event) {
        btnSignUp.setStyle("-fx-background-color: white;-fx-border-color: black; -fx-text-fill: black;");

    }

    @FXML
    void signUpBtnMouseExitOnAction(MouseEvent event) {
        btnSignUp.setStyle("-fx-background-color: #1e90ff; -fx-border-color: white; -fx-text-fill: white;");
    }

    @FXML
    void signUpBtnOnAction(ActionEvent event) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/user_sign_up.fxml"));
        Scene scene = new Scene(anchorPane);

        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("User Sign_up page");
        stage.centerOnScreen();
    }
    @FXML
    void btnToggleOnAction(ActionEvent event) {
        System.out.println("Show");
    }

}