package lk.ijse.Library_management_system.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.time.LocalDate;

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
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {

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

}
