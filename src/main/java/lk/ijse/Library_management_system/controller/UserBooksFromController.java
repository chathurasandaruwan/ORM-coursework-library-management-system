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
    private Label lblBranch;

    @FXML
    private Button btnReturn;

    @FXML
    private Label lblSearchError;
    @FXML
    private Button btnBorrow;
    @FXML
    private Button btnSearch;

    @FXML
    private Label lblDate;
    BorrowBO borrowBO = new BorrowBOImpl();
    public void initialize() {
        setCombSearchValues();
        loadAllBooks();
        setvaluesFactory();
        textSearch.setOnAction((ActionEvent event) -> {
            btnSearch.fire();
        });

        tblBookList.getSelectionModel().selectedItemProperty().addListener((observable,oldValue,newValue) ->{
            if (newValue != null){
                lblBranch.setText(newValue.getBranch());
                lblBookTitle.setText(newValue.getTitle());
                lblAthorName.setText(newValue.getAuthor());
                lblGen.setText(newValue.getGeneration());
                lblBookId.setText(String.valueOf(newValue.getId()));
                lblStatus.setText(String.valueOf(newValue.getAvailabilityStatus()));
            }
        });
    }
    public void setCombSearchValues(){
        CombSearchValues.setItems(FXCollections.observableArrayList("Name", "Branch","All"));
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
        String type = CombSearchValues.getValue();
        List<BookDTO> bookDTOS = borrowBO.getAllBook();
        if (type!=null) {
            if (type.equals("Name")) {
                String name = textSearch.getText();
                for (BookDTO dto : bookDTOS) {
                    if (name.equals(dto.getTitle())) {
                        tblBookList.getItems().clear();
                        BranchDTO branchDTO = dto.getBranch();
                        tblBookList.getItems().add(new BookTM(dto.getId(), dto.getTitle(), dto.getAuthor(), dto.getAvailabilityStatus(), dto.getGeneration(), branchDTO.getAddress()));
                        lblBranch.setText(branchDTO.getAddress());
                        lblBookTitle.setText(dto.getTitle());
                        lblAthorName.setText(dto.getAuthor());
                        lblGen.setText(dto.getGeneration());
                        lblBookId.setText(String.valueOf(dto.getId()));
                        lblStatus.setText(String.valueOf(dto.getAvailabilityStatus()));
                        lblSearchError.setText("");

                    }else {
//                        new Alert(Alert.AlertType.ERROR,"Can't Find , Please try again !!").show();
                        if (lblBookId.getText() == null || lblBookId.getText().isEmpty()) {
                            lblSearchError.setText("Can't Find, Please try again!!!");
                        }
                    }
                }
            } else if (type.equals("Branch")) {
                tblBookList.getItems().clear();
                lblSearchError.setOpacity(100);
                String address = textSearch.getText();
                for (BookDTO dto : bookDTOS) {
                    BranchDTO branchDTO = dto.getBranch();
                    if (address.equals(branchDTO.getAddress())) {
                        tblBookList.getItems().add(new BookTM(dto.getId(), dto.getTitle(), dto.getAuthor(), dto.getAvailabilityStatus(), dto.getGeneration(), branchDTO.getAddress()));
                        lblSearchError.setOpacity(0);
                    }else {

//                        new Alert(Alert.AlertType.ERROR,"Can't Find , Please try again !!").show();
                        lblSearchError.setText("Can't Find , Please try again !!!");
                    }
                }
            } else if (type.equals("All")) {
                loadAllBooks();
            }
        }else {   new Alert(Alert.AlertType.ERROR,"Please select search type").show();}

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