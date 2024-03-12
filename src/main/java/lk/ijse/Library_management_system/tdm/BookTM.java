package lk.ijse.Library_management_system.tdm;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@Data
@ToString
@NoArgsConstructor
public class BookTM {
    private long id;
    private String title;
    private String author;
    private int availabilityStatus;
    private String generation;
    private String branch;

}
