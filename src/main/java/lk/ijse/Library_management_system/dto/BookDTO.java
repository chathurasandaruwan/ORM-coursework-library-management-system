package lk.ijse.Library_management_system.dto;


import lk.ijse.Library_management_system.entity.Branch;

public class BookDTO {
    private long id;
    private String title;
    private String author;
    private int availabilityStatus;
    private String generation;
    private BranchDTO branchDTO;

    public BookDTO() {
    }

    public BookDTO(long id, String title, String author, int availabilityStatus, String generation, BranchDTO branchDTO) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.availabilityStatus = availabilityStatus;
        this.generation = generation;
        this.branchDTO = branchDTO;
    }

    public BookDTO(String title, String author, int availabilityStatus, String generation, BranchDTO branchDTO) {
        this.title = title;
        this.author = author;
        this.availabilityStatus = availabilityStatus;
        this.generation = generation;
        this.branchDTO = branchDTO;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public BranchDTO getBranch() {
        return branchDTO;
    }

    public void setBranch(Branch branch) {
        this.branchDTO = branchDTO;
    }

    public String getGeneration() {
        return generation;
    }

    public void setGeneration(String generation) {
        this.generation = generation;
    }
}
