package lk.ijse.Library_management_system.dto;


import lk.ijse.Library_management_system.entity.Book;
import lk.ijse.Library_management_system.entity.Branch;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
    private long id;
    private String title;
    private String author;
    private int availabilityStatus;
    private String generation;
    private BranchDTO branchDTO;

    public BookDTO(String title, String author, int availabilityStatus, String generation, BranchDTO branchDTO) {
        this.title = title;
        this.author = author;
        this.availabilityStatus = availabilityStatus;
        this.generation = generation;
        this.branchDTO = branchDTO;
    }
    public Book toEntity(){
        return new Book(id,title,author,availabilityStatus,generation,branchDTO.ToEntity());
    }

}
