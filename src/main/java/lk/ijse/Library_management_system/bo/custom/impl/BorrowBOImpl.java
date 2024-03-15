package lk.ijse.Library_management_system.bo.custom.impl;

import lk.ijse.Library_management_system.bo.custom.BorrowBO;
import lk.ijse.Library_management_system.config.FactoryConfiguration;
import lk.ijse.Library_management_system.dao.DAOFactory;
import lk.ijse.Library_management_system.dao.custom.BookDAO;
import lk.ijse.Library_management_system.dao.custom.BorrowDAO;
import lk.ijse.Library_management_system.dao.custom.BranchDAO;
import lk.ijse.Library_management_system.dao.custom.impl.BorrowDAOImpl;
import lk.ijse.Library_management_system.dto.BookDTO;
import lk.ijse.Library_management_system.dto.BorrowDTO;
import lk.ijse.Library_management_system.dto.BranchDTO;
import lk.ijse.Library_management_system.entity.Book;
import lk.ijse.Library_management_system.entity.Borrow;
import lk.ijse.Library_management_system.entity.Branch;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class BorrowBOImpl implements BorrowBO {
    BorrowDAO borrowDAO = (BorrowDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.BORROW);
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
    @Override
    public boolean saveBorrow(BorrowDTO dto){
        Session session =null;
        Transaction transaction=null;
        session = FactoryConfiguration.getInstance().getSession();
        transaction = session.beginTransaction();
        /*UserDTO userDTO = dto.getUser();
        BookDTO bookDTO = dto.getBook();*/

        boolean isBorrowedSaved = borrowDAO.save(new Borrow(dto.getBorrowedDate(),dto.getReturningDate(),dto.getUser().toEntity(),dto.getBook().toEntity()));
        System.out.println("borrow : "+isBorrowedSaved);
        if (isBorrowedSaved){
            int newBookCount= dto.getBook().getAvailabilityStatus()-1;
            Book newBooks=dto.getBook().toEntity();
            newBooks.setAvailabilityStatus(newBookCount);

            boolean isUpdateBookCount = bookDAO.update(newBooks);
            System.out.println("update book :"+isUpdateBookCount);
            if (isUpdateBookCount){
                transaction.commit();
                return true;
            }
        }
        return false;
    }
    @Override
    public List<BorrowDTO> getAllBorrow(){
        List<BorrowDTO>borrowDTOS =new ArrayList<>();
        List<Borrow> borrows = borrowDAO.getAll();
        for (Borrow borrow : borrows) {
            borrowDTOS.add(new BorrowDTO(borrow.getId(),borrow.getBook().toDTO(),borrow.getUser().toDTO(),borrow.getBorrowedDate(),borrow.getReturningDate()));
        }
        return borrowDTOS;
    }
    @Override
    public boolean returnBook(long id, BookDTO dto){
        Session session =null;
        Transaction transaction=null;
        session = FactoryConfiguration.getInstance().getSession();
        transaction = session.beginTransaction();
        boolean isReturned = borrowDAO.delete(id);
        if (isReturned) {
            int newBookCount = dto.getAvailabilityStatus() + 1;
            Book newBooks = dto.toEntity();
            newBooks.setAvailabilityStatus(newBookCount);

            boolean isUpdateBookCount = bookDAO.update(newBooks);
            System.out.println("update book :" + isUpdateBookCount);
            if (isUpdateBookCount) {
                transaction.commit();
                return true;
            } else {
                return false;
            }
        }return true;
    }
}
