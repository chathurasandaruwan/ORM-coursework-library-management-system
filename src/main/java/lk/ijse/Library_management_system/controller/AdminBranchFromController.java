package lk.ijse.Library_management_system.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import lk.ijse.Library_management_system.bo.custom.BranchBO;
import lk.ijse.Library_management_system.bo.custom.impl.BranchBOImpl;
import lk.ijse.Library_management_system.dto.BranchDTO;
import lk.ijse.Library_management_system.entity.Branch;

import java.time.LocalDate;
import java.util.List;

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
    BranchBO branchBO = new BranchBOImpl();
    public void initialize() {
        loadAllBranch();
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
        boolean isSaved = branchBO.saveBranch(new BranchDTO(address,opDate));
        if (isSaved){
            new Alert(Alert.AlertType.INFORMATION,"SAVE SUCCESS !!!").show();
            textAddress.clear();
            OpenedDayPiker.setValue(null);
        }
    }
    public void loadAllBranch(){
        List<BranchDTO> branches =branchBO.getAllBranch();
        for (BranchDTO branch : branches) {
            System.out.println(branch.getAddress());
        }
    }

}
