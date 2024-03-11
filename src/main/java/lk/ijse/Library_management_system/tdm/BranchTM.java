package lk.ijse.Library_management_system.tdm;
import java.time.LocalDate;

public class BranchTM {
    private int id;
    private String address;
    private LocalDate openedDate;

    public BranchTM() {
    }

    public BranchTM(int id, String address, LocalDate openedDate) {
        this.id = id;
        this.address = address;
        this.openedDate = openedDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getOpenedDate() {
        return openedDate;
    }

    public void setOpenedDate(LocalDate openedDate) {
        this.openedDate = openedDate;
    }
}
