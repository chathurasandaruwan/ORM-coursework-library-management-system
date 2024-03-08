package lk.ijse.Library_management_system.entity;

import jakarta.persistence.*;

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String author;
    private int availabilityStatus;
    private String generation;

    @ManyToOne
    @JoinColumn(name = "branch_id")
    private Branch branch;



}
