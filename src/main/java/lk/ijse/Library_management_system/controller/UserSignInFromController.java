package lk.ijse.Library_management_system.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.swing.text.html.ImageView;
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
    public void initialize(){
        String imagePath = "/assest/image/Hide_Password.png";
        btnToggle.setStyle("-fx-background-image: url('" + imagePath + "'); -fx-background-size: 50% 50%; -fx-background-position: center; -fx-background-repeat: no-repeat;");
    }

    @FXML
    void signInBtnOnAction(ActionEvent event) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/user_buttonBoard_form.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("User page");
        stage.centerOnScreen();
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
        if (btnToggle.isSelected()) {
            textPassword.setPromptText(textPassword.getText());
            textPassword.setText("");
            String imagePath = "/assest/image/Show_password.png";
            btnToggle.setStyle("-fx-background-image: url('" + imagePath + "'); -fx-background-size: 60% 60%; -fx-background-position: center; -fx-background-repeat: no-repeat;");
        } else {
            textPassword.setText(textPassword.getPromptText());
            textPassword.setPromptText("");
            String imagePath = "/assest/image/Hide_Password.png";
            btnToggle.setStyle("-fx-background-image: url('" + imagePath + "'); -fx-background-size: 60% 60%; -fx-background-position: center; -fx-background-repeat: no-repeat;");
        }
    }@FXML
    void imgHomeNavi(MouseEvent event) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/main_form.fxml"));
        Scene scene = new Scene(anchorPane);

        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("User Sign_in page");
        stage.centerOnScreen();
    }

}