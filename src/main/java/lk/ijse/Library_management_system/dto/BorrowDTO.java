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
    private BookDTO book;
    private UserDTO user;
    private LocalDate borrowedDate;
    private LocalDate returningDate;

    public BorrowDTO(BookDTO book, UserDTO user, LocalDate borrowedDate, LocalDate returningDate) {
        this.book = book;
        this.user = user;
        this.borrowedDate = borrowedDate;
        this.returningDate = returningDate;
    }
}
