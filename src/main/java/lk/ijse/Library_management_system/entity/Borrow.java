package lk.ijse.Library_management_system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Borrowed_info")
public class Borrow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "borrowed_date")
    private LocalDate borrowedDate;

    @Column(name = "returning_date")
    private LocalDate returningDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    public Borrow(LocalDate borrowedDate, LocalDate returningDate, User user, Book book) {
        this.borrowedDate = borrowedDate;
        this.returningDate = returningDate;
        this.user = user;
        this.book = book;
    }
}
