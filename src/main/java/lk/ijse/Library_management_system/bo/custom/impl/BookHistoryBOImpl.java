package lk.ijse.Library_management_system.bo.custom.impl;

import lk.ijse.Library_management_system.bo.custom.BookHistoryBO;
import lk.ijse.Library_management_system.dao.DAOFactory;
import lk.ijse.Library_management_system.dao.custom.BorrowDAO;
import lk.ijse.Library_management_system.dao.custom.impl.BorrowDAOImpl;
import lk.ijse.Library_management_system.dto.BorrowDTO;
import lk.ijse.Library_management_system.entity.Borrow;

import java.util.ArrayList;
import java.util.List;

public class BookHistoryBOImpl implements BookHistoryBO {
    BorrowDAO borrowDAO = (BorrowDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.BORROW);
    @Override
    public List<BorrowDTO> getAllBorrow(){
        List<BorrowDTO>borrowDTOS =new ArrayList<>();
        List<Borrow> borrows = borrowDAO.getAll();
        for (Borrow borrow : borrows) {
            borrowDTOS.add(new BorrowDTO(borrow.getId(),borrow.getBook().toDTO(),borrow.getUser().toDTO(),borrow.getBorrowedDate(),borrow.getReturningDate()));
        }
        return borrowDTOS;
    }
}
