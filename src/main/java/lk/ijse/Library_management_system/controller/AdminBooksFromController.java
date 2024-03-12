package lk.ijse.Library_management_system.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.Library_management_system.bo.custom.BookBO;
import lk.ijse.Library_management_system.bo.custom.impl.BookBOImpl;
import lk.ijse.Library_management_system.dto.BookDTO;
import lk.ijse.Library_management_system.dto.BranchDTO;
import lk.ijse.Library_management_system.tdm.BookTM;

import java.time.LocalDate;
import java.util.List;

public class AdminBooksFromController {

    @FXML
    private TableView<BookTM> tblViwe;

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

    @FXML
    private TableColumn<?, ?> columnId;

    @FXML
    private TableColumn<?, ?> columnTitle;

    @FXML
    private TableColumn<?, ?> columnAuthor;

    @FXML
    private TableColumn<?, ?> columnIdAStatus;

    @FXML
    private TableColumn<?, ?> columnGen;

    @FXML
    private TableColumn<?, ?> columnBranch;

    BookBO bookBO = new BookBOImpl();

    public void initialize() {
        setCombBranch();
        resetAll();
        loadAllBooks();
        setvaluesFactory();

        tblViwe.getSelectionModel().selectedItemProperty().addListener((observable,oldValue,newValue) ->{
            if (newValue != null){
                btnSave.setText("Update");
                btnSave.setDisable(false);
                btnDelete.setDisable(false);
                textTitle.setDisable(false);
                textGen.setDisable(false);
                textStatus.setDisable(false);
                textAuthor.setDisable(false);
                yearPiker.setDisable(false);
                combBranch.setDisable(false);

                textTitle.setText(newValue.getTitle());
                textAuthor.setText(newValue.getAuthor());
                textGen.setText(newValue.getGeneration());
                combBranch.setValue(newValue.getBranch());
                textStatus.setText(String.valueOf(newValue.getAvailabilityStatus()));
            }else {
                btnSave.setText("Save");
            }
        });
    }
    private void setvaluesFactory() {
        columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        columnAuthor.setCellValueFactory(new PropertyValueFactory<>("author"));
        columnIdAStatus.setCellValueFactory(new PropertyValueFactory<>("availabilityStatus"));
        columnGen.setCellValueFactory(new PropertyValueFactory<>("generation"));
        columnBranch.setCellValueFactory(new PropertyValueFactory<>("branch"));


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
        combBranch.setValue(null);
        yearPiker.setValue(null);


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
           new Alert(Alert.AlertType.INFORMATION,"SAVE SUCCESS !!!").show();
           resetAll();
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
    public void loadAllBooks(){
        List<BookDTO> bookDTOS = bookBO.getAllBook();
        for (BookDTO dto : bookDTOS) {
            BranchDTO branchDTO = dto.getBranch();
            tblViwe.getItems().add(new BookTM(dto.getId(),dto.getTitle(),dto.getAuthor(),dto.getAvailabilityStatus(),dto.getGeneration(),branchDTO.getAddress()));
        }
    }

}
