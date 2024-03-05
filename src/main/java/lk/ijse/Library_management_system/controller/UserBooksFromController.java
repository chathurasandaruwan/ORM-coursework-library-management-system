package lk.ijse.Library_management_system.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class UserBooksFromController {

    @FXML
    private TableView<?> tblBrrowed;

    @FXML
    private TableView<?> tblBookList;

    @FXML
    private TextField textSearch;

    @FXML
    private ComboBox<?> CombSearchValues;

    @FXML
    private Label lblBookTitle;

    @FXML
    private Label lblAthorName;

    @FXML
    private Label lblGen;

    @FXML
    private Label lblBookId;

    @FXML
    private Label lblStatus;

    @FXML
    private Button btnReturn;

    @FXML
    private Button btnBorrow;

    @FXML
    private Label lblDate;

    @FXML
    void btnBorrowOnAction(ActionEvent event) {

    }

    @FXML
    void btnReturnOnAction(ActionEvent event) {

    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {

    }

}