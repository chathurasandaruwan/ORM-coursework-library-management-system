package lk.ijse.Library_management_system.bo.custom.impl;

import lk.ijse.Library_management_system.bo.custom.BorrowBO;
import lk.ijse.Library_management_system.dao.DAOFactory;
import lk.ijse.Library_management_system.dao.custom.BookDAO;
import lk.ijse.Library_management_system.dto.BookDTO;
import lk.ijse.Library_management_system.dto.BranchDTO;
import lk.ijse.Library_management_system.entity.Book;
import lk.ijse.Library_management_system.entity.Branch;

import java.util.ArrayList;
import java.util.List;

public class BorrowBOImpl implements BorrowBO {
    BookDAO bookDAO = (BookDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.BOOK);
    @Override
    public List<BookDTO> getAllBook(){
        List<BookDTO> bookDTOS = new ArrayList<>();
        List<Book> books = bookDAO.getAll();
        for (Book book : books) {
            Branch branch = book.getBranch();
            bookDTOS.add(new BookDTO(book.getId(),book.getTitle(),book.getAuthor(),book.getAvailabilityStatus(),book.getGeneration(),(new BranchDTO(branch.getId(),branch.getAddress(),branch.getOpenedDate()))));
        }
        return bookDTOS;
    }
}
