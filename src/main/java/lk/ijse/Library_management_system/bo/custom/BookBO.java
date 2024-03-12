package lk.ijse.Library_management_system.bo.custom;

import lk.ijse.Library_management_system.bo.SupperBO;
import lk.ijse.Library_management_system.dto.BookDTO;
import lk.ijse.Library_management_system.dto.BranchDTO;

import java.util.List;

public interface BookBO extends SupperBO {

    List<BranchDTO> getAllBranch();

    boolean saveBook(BookDTO dto);

    List<BookDTO> getAllBook();

    boolean updateBook(BookDTO dto);

    boolean deleteBook(long id);
}
