package lk.ijse.Library_management_system.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.Library_management_system.bo.custom.BorrowBO;
import lk.ijse.Library_management_system.bo.custom.impl.BorrowBOImpl;
import lk.ijse.Library_management_system.dto.BookDTO;
import lk.ijse.Library_management_system.dto.BorrowDTO;
import lk.ijse.Library_management_system.dto.BranchDTO;
import lk.ijse.Library_management_system.dto.UserDTO;
import lk.ijse.Library_management_system.entity.Borrow;
import lk.ijse.Library_management_system.tdm.BookHisTM;
import lk.ijse.Library_management_system.tdm.BookTM;
import lk.ijse.Library_management_system.tdm.BorrowedTM;

import java.util.List;

public class BooksHistoryFromController {

    @FXML
    private TableView<BookHisTM> tblView;

    @FXML
    private Label lblDate;
    @FXML
    private TableColumn<?, ?> columnBookId;

    @FXML
    private TableColumn<?, ?> columnTitle;

    @FXML
    private TableColumn<?, ?> columnAuthor;

    @FXML
    private TableColumn<?, ?> columnBorroweDate;

    @FXML
    private TableColumn<?, ?> columnExpDate;

    private UserDTO user= UserSignInFromController.userDTO;
    BorrowBO borrowBO = new BorrowBOImpl();
    public void initialize() {
        loadAllBooks();
        setvaluesFactory();
    }

    private void setvaluesFactory() {
        columnBookId.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        columnBorroweDate.setCellValueFactory(new PropertyValueFactory<>("borrowedDate"));
        columnExpDate.setCellValueFactory(new PropertyValueFactory<>("expDate"));

    }
    public void loadAllBooks(){
        tblView.getItems().clear();
        List<BorrowDTO> allBorrow = borrowBO.getAllBorrow();
        for (BorrowDTO borrowDTO : allBorrow) {
            if (user.getId()==borrowDTO.getUser().getId()){
                BookDTO dto = borrowDTO.getBook();
                tblView.getItems().add(new BookHisTM(dto.getId(),dto.getTitle(),dto.getAuthor(),borrowDTO.getBorrowedDate(),borrowDTO.getReturningDate()));
            }

        }
    }
}
