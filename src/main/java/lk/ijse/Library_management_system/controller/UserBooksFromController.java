package lk.ijse.Library_management_system.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.Library_management_system.bo.BOFactory;
import lk.ijse.Library_management_system.bo.custom.BookBO;
import lk.ijse.Library_management_system.bo.custom.BorrowBO;
import lk.ijse.Library_management_system.bo.custom.impl.BorrowBOImpl;
import lk.ijse.Library_management_system.dto.BookDTO;
import lk.ijse.Library_management_system.dto.BorrowDTO;
import lk.ijse.Library_management_system.dto.BranchDTO;
import lk.ijse.Library_management_system.dto.UserDTO;
import lk.ijse.Library_management_system.tdm.BookTM;

import java.time.LocalDate;
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

        resetAll();
        setCombSearchValues();
        loadAllBooks();
        setvaluesFactory();
        setDate();
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
            }else {
                resetAll();
            }
        });
    }
    public void resetAll(){
        lblBranch.setText("");
        lblBookTitle.setText("");
        lblAthorName.setText("");
        lblGen.setText("");
        lblBookId.setText("");
        lblStatus.setText("");
        tblBookList.getSelectionModel().clearSelection();
    }
    public void setCombSearchValues(){
        CombSearchValues.setItems(FXCollections.observableArrayList("Name", "Branch","All"));
    }
    private void setDate() {
        lblDate.setText(String.valueOf(LocalDate.now()));
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
        UserDTO user= UserSignInFromController.userDTO;
        long bookId = Long.parseLong(lblBookId.getText());
        BookDTO book=getBooksById(bookId);
        BranchDTO branchDTO =getBranchByAddress(lblBranch.getText());
        book.setBranchDTO(branchDTO);
        LocalDate borrowedDate = LocalDate.parse(lblDate.getText());
        LocalDate returnedDate = borrowedDate.plusDays(7);
        boolean isSaved= borrowBO.saveBorrow(new BorrowDTO(book,user,borrowedDate,returnedDate));
        if (isSaved){
            new Alert(Alert.AlertType.INFORMATION,"SAVE SUCCESS").show();
            loadAllBooks();
        }
    }
    public BranchDTO getBranchByAddress(String address){
        List<BranchDTO> branches = borrowBO.getAllBranch();
        BranchDTO branchDTO = new BranchDTO();
        for (BranchDTO branch : branches) {
            if (address.equals(branch.getAddress())){
                branchDTO.setId(branch.getId());
                branchDTO.setAddress(branch.getAddress());
                branchDTO.setOpenedDate(branch.getOpenedDate());
            }
        }return branchDTO;
    }

    public BookDTO getBooksById(long id){
        List<BookDTO> bookDTOS = borrowBO.getAllBook();
        BookDTO bookDTO = new BookDTO();
        for (BookDTO dto : bookDTOS) {
            if (id==dto.getId()){
                bookDTO.setId(dto.getId());
                bookDTO.setTitle(dto.getTitle());
                bookDTO.setAuthor(dto.getAuthor());
//                bookDTO.setBranch(new BranchDTO().toEntity(dto.getBranch()));

                bookDTO.setGeneration(dto.getGeneration());
                bookDTO.setAvailabilityStatus(dto.getAvailabilityStatus());
            }
        }return bookDTO;
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
                tblBookList.getItems().clear();
                for (BookDTO dto : bookDTOS) {
                    if (name.equals(dto.getTitle())) {
                        BranchDTO branchDTO = dto.getBranchDTO();
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
                }textSearch.setText("");
            } else if (type.equals("Branch")) {
                tblBookList.getItems().clear();
                lblSearchError.setOpacity(100);
                String address = textSearch.getText();
                for (BookDTO dto : bookDTOS) {
                    BranchDTO branchDTO = dto.getBranchDTO();
                    if (address.equals(branchDTO.getAddress())) {
                        tblBookList.getItems().add(new BookTM(dto.getId(), dto.getTitle(), dto.getAuthor(), dto.getAvailabilityStatus(), dto.getGeneration(), branchDTO.getAddress()));
                        lblSearchError.setOpacity(0);
                    }else {

//                        new Alert(Alert.AlertType.ERROR,"Can't Find , Please try again !!").show();
                        lblSearchError.setText("Can't Find , Please try again !!!");
                    }
                }
                resetAll();
            } else if (type.equals("All")) {
                lblSearchError.setText("");
                loadAllBooks();
                resetAll();
            }
        }else {   new Alert(Alert.AlertType.ERROR,"Please select search type").show();}

    }
    public void loadAllBooks(){
        tblBookList.getItems().clear();
        List<BookDTO> bookDTOS = borrowBO.getAllBook();
        for (BookDTO dto : bookDTOS) {
            BranchDTO branchDTO = dto.getBranchDTO();
            tblBookList.getItems().add(new BookTM(dto.getId(),dto.getTitle(),dto.getAuthor(),dto.getAvailabilityStatus(),dto.getGeneration(),branchDTO.getAddress()));
        }
    }

}




