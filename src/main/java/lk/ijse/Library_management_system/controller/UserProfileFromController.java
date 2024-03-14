package lk.ijse.Library_management_system.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.ijse.Library_management_system.bo.BOFactory;
import lk.ijse.Library_management_system.bo.custom.UserBO;
import lk.ijse.Library_management_system.bo.custom.impl.UserBOImpl;
import lk.ijse.Library_management_system.dto.UserDTO;

import java.io.IOException;
import java.util.List;

public class UserProfileFromController {
    @FXML
    private AnchorPane root;

    @FXML
    private TextField textConfirmPassword;

    @FXML
    private TextField textNewPassword;

    @FXML
    private TextField textEmail;

    @FXML
    private TextField textUserName;

    @FXML
    private Label lblReturnBookCount;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnUpdate;
    @FXML
    private Label lblUserId;
    @FXML
    private Label lblWarningPassword1;

    @FXML
    private Label lblWarningPassword2;
    UserBO userBO = (UserBO) BOFactory.getBoFactory().getBO(BOFactory.BOType.USER);
    public void initialize() {
        textNewPassword.setDisable(true);
        textConfirmPassword.setDisable(true);
        btnUpdate.setDisable(true);
        btnDelete.setDisable(true);
    }
    public void resetAll(){
        textNewPassword.setDisable(true);
        textConfirmPassword.setDisable(true);
        btnUpdate.setDisable(true);
        btnDelete.setDisable(true);
        lblUserId.setText("");
        textUserName.clear();
        textEmail.clear();
        textNewPassword.clear();
        textConfirmPassword.clear();
        lblWarningPassword1.setText("");
        lblWarningPassword2.setText("");
        textConfirmPassword.setStyle("");
        textNewPassword.setStyle("");
    }
    @FXML
    void textEmailOnAction(ActionEvent event) {
        String name = textUserName.getText();
        String email = textEmail.getText();
        List<UserDTO> users = userBO.getAllUser();
        for (UserDTO user : users) {
            if (name.equals(user.getName())){
                if (email.equals(user.getEmail())){
                    textNewPassword.setDisable(false);
                    textConfirmPassword.setDisable(false);
                    btnUpdate.setDisable(false);
                    btnDelete.setDisable(false);
                    lblUserId.setText(String.valueOf(user.getId()));
                    return;
                }
            }
        }
        new Alert(Alert.AlertType.ERROR, "User name and Email NOT MATCHED").show();

    }
    @FXML
    void btnDeletOnAction(ActionEvent event) {
        long userId = Long.parseLong(lblUserId.getText());
        boolean isDelete = userBO.deleteUser(userId);
        if (isDelete){
            new Alert(Alert.AlertType.INFORMATION, "DELETE SUCCESSFUL !!!").show();
            resetAll();
        }
    }

    @FXML
    void btnReturnOnAction(ActionEvent event) throws IOException {
        Parent rootNode = FXMLLoader.load(getClass().getResource("/view/user_books_form.fxml"));
        root.getChildren().clear();
        root.getChildren().add(rootNode);
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        long id = Long.parseLong(lblUserId.getText());
        String name = textUserName.getText();
        String email = textEmail.getText();
        String newPassword = textNewPassword.getText();
        String confirmPassword = textConfirmPassword.getText();
        if (newPassword.equals(confirmPassword)){
           boolean isUpdate= userBO.updateUser(new UserDTO(id,name,email,newPassword));
           if (isUpdate){
               new Alert(Alert.AlertType.INFORMATION, "UPDATE SUCCESSFUL !!!").show();
               resetAll();
           }
        }else {
            lblWarningPassword1.setText("Password not matched !!! , Please try again !!!");
            lblWarningPassword2.setText("Password not matched !!! , Please try again !!!");
            textConfirmPassword.setStyle("-fx-border-color: red");
            textNewPassword.setStyle("-fx-border-color: red");
        }
    }

}