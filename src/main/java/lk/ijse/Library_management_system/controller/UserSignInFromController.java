package lk.ijse.Library_management_system.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.Library_management_system.bo.BOFactory;
import lk.ijse.Library_management_system.bo.custom.UserBO;
import lk.ijse.Library_management_system.dao.custom.UserDAO;
import lk.ijse.Library_management_system.dto.UserDTO;

import javax.swing.text.html.ImageView;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserSignInFromController {
    public static UserDTO userDTO = new UserDTO();
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
    UserBO userBO = (UserBO) BOFactory.getBoFactory().getBO(BOFactory.BOType.USER);
    public void initialize(){
        String imagePath = "/assest/image/Hide_Password.png";
        btnToggle.setStyle("-fx-background-image: url('" + imagePath + "'); -fx-background-size: 50% 50%; -fx-background-position: center; -fx-background-repeat: no-repeat;");
    }

    @FXML
    void signInBtnOnAction(ActionEvent event) throws IOException {
        String name = textUserName.getText();
        String password = textPassword.getText();
        List<UserDTO> users = userBO.getAllUser();
        for (UserDTO user : users) {
            if (name.equals(user.getName())){
                if (password.equals(user.getPassword())){
                    userDTO=user;
                    AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/user_buttonBoard_form.fxml"));
                    Scene scene = new Scene(anchorPane);
                    Stage stage = (Stage) root.getScene().getWindow();
                    stage.setScene(scene);
                    stage.setTitle("User page");
                    stage.centerOnScreen();
                }
            }
        }
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