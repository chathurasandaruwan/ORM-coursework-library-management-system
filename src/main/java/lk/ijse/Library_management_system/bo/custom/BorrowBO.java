package lk.ijse.Library_management_system.bo.custom;

import lk.ijse.Library_management_system.bo.SupperBO;
import lk.ijse.Library_management_system.dto.BookDTO;
import lk.ijse.Library_management_system.dto.BorrowDTO;

import java.util.List;

public interface BorrowBO extends SupperBO {
    List<BookDTO> getAllBook();

    boolean saveBorrow(BorrowDTO dto);
}
