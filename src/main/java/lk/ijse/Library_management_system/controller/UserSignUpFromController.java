package lk.ijse.Library_management_system.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class UserSignUpFromController {
    @FXML
    private AnchorPane root;

    @FXML
    private TextField textName;

    @FXML
    private PasswordField textPassword;

    @FXML
    private Button btnSignIn;

    @FXML
    private TextField textEmail;

    @FXML
    void btnSignInOnAction(ActionEvent event) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/user_sign_in.fxml"));
        Scene scene = new Scene(anchorPane);

        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("User Sign_in page");
        stage.centerOnScreen();
    }

    @FXML
    void btnSignUpOnAction(ActionEvent event) {

    }

    @FXML
    void mouseEnterOnAction(MouseEvent event) {
         btnSignIn.setStyle("-fx-background-color: white;-fx-border-color: black; -fx-text-fill: black;");
    }

    @FXML
    void mouseExitOnAction(MouseEvent event) {
        btnSignIn.setStyle("-fx-background-color: #1e90ff; -fx-border-color: white; -fx-text-fill: white;");
    }

}