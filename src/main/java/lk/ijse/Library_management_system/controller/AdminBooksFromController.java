package lk.ijse.Library_management_system.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import lk.ijse.Library_management_system.bo.custom.BookBO;
import lk.ijse.Library_management_system.bo.custom.impl.BookBOImpl;
import lk.ijse.Library_management_system.dto.BookDTO;
import lk.ijse.Library_management_system.dto.BranchDTO;

import java.time.LocalDate;
import java.util.List;

public class AdminBooksFromController {

    @FXML
    private TableView<?> tblViwe;

    @FXML
    private Label lblBookId;

    @FXML
    private TextField textTitle;

    @FXML
    private TextField textAuthor;

    @FXML
    private TextField textStatus;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnSave;
    @FXML
    private TextField textGen;

    @FXML
    private DatePicker yearPiker;

    @FXML
    private JFXComboBox<String> combBranch;

    @FXML
    private Button btnAddNew;

    BookBO bookBO = new BookBOImpl();

    public void initialize() {
        setCombBranch();
        resetAll();
    }
    public void resetAll(){
        btnSave.setDisable(true);
        btnDelete.setDisable(true);
        textTitle.setDisable(true);
        textGen.setDisable(true);
        textStatus.setDisable(true);
        textAuthor.setDisable(true);
        yearPiker.setDisable(true);
        combBranch.setDisable(true);

        textAuthor.clear();
        textStatus.clear();
        textGen.clear();
        textTitle.clear();


    }
    @FXML
    void btnAddNewOnAction(ActionEvent event) {
        btnSave.setDisable(false);
        textTitle.setDisable(false);
        textGen.setDisable(false);
        textStatus.setDisable(false);
        textAuthor.setDisable(false);
        yearPiker.setDisable(false);
        combBranch.setDisable(false);
    }
    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
       String address = combBranch.getValue();
       BranchDTO branchDTO = getBranchByAddress(address);
       String author = textAuthor.getText();
       int availabilityS = Integer.parseInt(textStatus.getText());
       String gen = textGen.getText();
       String title = textTitle.getText();
       boolean isSaved = bookBO.saveBook(new BookDTO(title,author,availabilityS,gen,branchDTO));
       if (isSaved){
           System.out.println("Save success !!");
       }




    }
    public BranchDTO getBranchByAddress(String address){
        List<BranchDTO> branches = bookBO.getAllBranch();
        BranchDTO branchDTO = new BranchDTO();
        for (BranchDTO branch : branches) {
            if (address.equals(branch.getAddress())){
                 branchDTO.setId(branch.getId());
                 branchDTO.setAddress(branch.getAddress());
                 branchDTO.setOpenedDate(branch.getOpenedDate());
            }
        }return branchDTO;
    }

    @FXML
    void handleDatePickerAction(ActionEvent event) {
        LocalDate selectedDate = yearPiker.getValue();

        if (selectedDate != null) {
            int selectedYear = selectedDate.getYear();
            System.out.println("Selected Year: " + selectedYear);
            textGen.setText(String.valueOf(selectedYear));
        } else {
            System.out.println("No date selected");
        }
    }
    public void setCombBranch(){
        List<BranchDTO> branches = bookBO.getAllBranch();
        for (BranchDTO branch : branches) {
            combBranch.getItems().add(branch.getAddress());
        }
    }

}
