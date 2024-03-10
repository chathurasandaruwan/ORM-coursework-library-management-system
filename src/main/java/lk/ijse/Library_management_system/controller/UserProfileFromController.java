package lk.ijse.Library_management_system.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import lk.ijse.Library_management_system.bo.custom.UserBO;
import lk.ijse.Library_management_system.bo.custom.impl.UserBOImpl;
import lk.ijse.Library_management_system.dto.UserDTO;

import java.util.List;

public class UserProfileFromController {

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
    UserBO userBO = new UserBOImpl();
    public void initialize() {
        textNewPassword.setDisable(true);
        textConfirmPassword.setDisable(true);
        btnUpdate.setDisable(true);
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
                    lblUserId.setText(String.valueOf(user.getId()));
                    return;
                }
            }
        }
        System.out.println("Not Found");

    }
    @FXML
    void btnDeletOnAction(ActionEvent event) {

    }

    @FXML
    void btnReturnOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

}