package lk.ijse.Library_management_system.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.Library_management_system.bo.BOFactory;
import lk.ijse.Library_management_system.bo.custom.BorrowBO;
import lk.ijse.Library_management_system.bo.custom.impl.BorrowBOImpl;
import lk.ijse.Library_management_system.dto.BookDTO;
import lk.ijse.Library_management_system.dto.BranchDTO;
import lk.ijse.Library_management_system.tdm.BookTM;

import java.util.List;

public class UserBooksFromController {

    @FXML
    private TableView<?> tblBrrowed;

    @FXML
    private TableView<BookTM> tblBookList;
    @FXML
    private TableColumn<?, ?> columnId;

    @FXML
    private TableColumn<?, ?> columnTitle;

    @FXML
    private TableColumn<?, ?> columnAuthor;

    @FXML
    private TableColumn<?, ?> columnAStatus;

    @FXML
    private TableColumn<?, ?> columnGen;

    @FXML
    private TableColumn<?, ?> columnBranch;


    @FXML
    private TextField textSearch;

    @FXML
    private ComboBox<String> CombSearchValues;

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
    BorrowBO borrowBO = new BorrowBOImpl();
    public void initialize() {
        setCombSearchValues();
        loadAllBooks();
        setvaluesFactory();
    }
    public void setCombSearchValues(){
        CombSearchValues.setItems(FXCollections.observableArrayList("Name", "Branch"));
    }

    private void setvaluesFactory() {
        columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        columnAuthor.setCellValueFactory(new PropertyValueFactory<>("author"));
        columnAStatus.setCellValueFactory(new PropertyValueFactory<>("availabilityStatus"));
        columnGen.setCellValueFactory(new PropertyValueFactory<>("generation"));
        columnBranch.setCellValueFactory(new PropertyValueFactory<>("branch"));


    }
    @FXML
    void btnBorrowOnAction(ActionEvent event) {

    }

    @FXML
    void btnReturnOnAction(ActionEvent event) {

    }
    @FXML
    void btnSearchOnAction(ActionEvent event) {

    }
    public void loadAllBooks(){
        tblBookList.getItems().clear();
        List<BookDTO> bookDTOS = borrowBO.getAllBook();
        for (BookDTO dto : bookDTOS) {
            BranchDTO branchDTO = dto.getBranch();
            tblBookList.getItems().add(new BookTM(dto.getId(),dto.getTitle(),dto.getAuthor(),dto.getAvailabilityStatus(),dto.getGeneration(),branchDTO.getAddress()));
        }
    }

}