package lk.ijse.Library_management_system.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

public class Borrow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate borrowedDate;
    private LocalDate returningDate;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;


}
