package lk.ijse.Library_management_system.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "Book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "availanility_status")
    private int availabilityStatus;

    @Column(name = "genaration")
    private String generation;

    @ManyToOne
    @JoinColumn(name = "branch_id")
    private Branch branch;

    @OneToMany(mappedBy = "book")
    private List<Borrow> borrows = new ArrayList<>();
}
