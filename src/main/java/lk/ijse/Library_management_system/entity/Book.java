package lk.ijse.Library_management_system.entity;

import jakarta.persistence.*;

import java.time.Year;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String author;
    private int AvailabilityStatus;
    private String branch;
    private Year generation;

    public Book(int id, String title, String author, int availabilityStatus, String branch, Year generation) {
        this.id = id;
        this.title = title;
        this.author = author;
        AvailabilityStatus = availabilityStatus;
        this.branch = branch;
        this.generation = generation;
    }

    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getAvailabilityStatus() {
        return AvailabilityStatus;
    }

    public void setAvailabilityStatus(int availabilityStatus) {
        AvailabilityStatus = availabilityStatus;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public Year getGeneration() {
        return generation;
    }

    public void setGeneration(Year generation) {
        this.generation = generation;
    }
}
