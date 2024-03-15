package lk.ijse.Library_management_system.entity;


import lk.ijse.Library_management_system.dto.BranchDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.time.LocalDate;
import javax.persistence.*;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "Branch")
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "address")
    private String address;

    @Column(name = "openDate")
    private LocalDate openedDate;

    @OneToMany(mappedBy = "branch", cascade = CascadeType.ALL)
    private List<Book>books;

    public Branch(String address, LocalDate openedDate) {
        this.address = address;
        this.openedDate = openedDate;
    }

    public Branch(long id, String address, LocalDate openedDate) {
        this.id = id;
        this.address = address;
        this.openedDate = openedDate;
    }
    public BranchDTO toDTO(){
        return new BranchDTO(id,address,openedDate);
    }
}
