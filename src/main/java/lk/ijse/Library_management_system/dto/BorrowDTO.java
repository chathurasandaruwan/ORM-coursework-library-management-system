package lk.ijse.Library_management_system.dto;

import java.time.LocalDate;

public class BorrowDTO {
    private int id;
    private int bookId;
    private int userId;
    private int branchId;
    private LocalDate borrowedDate;
    private LocalDate returningDate;

    public BorrowDTO() {
    }

    public BorrowDTO(int id, int bookId, int userId, int branchId, LocalDate borrowedDate, LocalDate returningDate) {
        this.id = id;
        this.bookId = bookId;
        this.userId = userId;
        this.branchId = branchId;
        this.borrowedDate = borrowedDate;
        this.returningDate = returningDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public LocalDate getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(LocalDate borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public LocalDate getReturningDate() {
        return returningDate;
    }

    public void setReturningDate(LocalDate returningDate) {
        this.returningDate = returningDate;
    }
}
