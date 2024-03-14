package lk.ijse.Library_management_system.dto;

import lk.ijse.Library_management_system.entity.Book;
import lk.ijse.Library_management_system.entity.Branch;
import lk.ijse.Library_management_system.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BorrowDTO {
    private int id;
    private Book book;
    private User user;
    private LocalDate borrowedDate;
    private LocalDate returningDate;

}
