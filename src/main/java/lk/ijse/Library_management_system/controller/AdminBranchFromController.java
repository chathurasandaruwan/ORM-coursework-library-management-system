package lk.ijse.Library_management_system.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.time.LocalDate;

public class AdminBranchFromController {

    @FXML
    private TextField textId;

    @FXML
    private TextField textAddress;

    @FXML
    private DatePicker OpenedDayPiker;

    @FXML
    private TableView<?> tblView;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnSave;
    @FXML
    private Button btnAddNew;
    public void initialize() {
        resetAll();
    }
    public void resetAll(){
        textId.setOpacity(0);
        textAddress.setDisable(true);
        OpenedDayPiker.setDisable(true);
        btnSave.setDisable(true);
        btnDelete.setDisable(true);

    }
    @FXML
    void btnAddNewOnAction(ActionEvent event) {
        textAddress.setDisable(false);
        OpenedDayPiker.setDisable(false);
        btnSave.setDisable(false);
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        LocalDate opDate = OpenedDayPiker.getValue();
        String address = textAddress.getText();
    }

}
