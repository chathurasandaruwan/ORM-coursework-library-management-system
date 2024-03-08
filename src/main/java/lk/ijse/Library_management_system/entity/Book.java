package lk.ijse.Library_management_system.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
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

    public Book() {
    }

    public Book(int id, String title, String author, int availabilityStatus, String generation, Branch branch) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.availabilityStatus = availabilityStatus;
        this.generation = generation;
        this.branch = branch;
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
        return availabilityStatus;
    }

    public void setAvailabilityStatus(int availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }

    public String getGeneration() {
        return generation;
    }

    public void setGeneration(String generation) {
        this.generation = generation;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }
}
