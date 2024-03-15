package lk.ijse.Library_management_system.tdm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
@AllArgsConstructor
@Data
@ToString
@NoArgsConstructor
public class BookHisTM {
    long id;
    String title;
    String author;
    LocalDate borrowedDate;
    LocalDate expDate;
}
