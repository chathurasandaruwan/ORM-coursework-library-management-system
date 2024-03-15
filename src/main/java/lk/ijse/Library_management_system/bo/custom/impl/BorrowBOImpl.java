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
import lk.ijse.Library_management_system.dto.UserDTO;
import lk.ijse.Library_management_system.entity.Book;
import lk.ijse.Library_management_system.entity.Borrow;
import lk.ijse.Library_management_system.entity.Branch;
import lk.ijse.Library_management_system.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class BorrowBOImpl implements BorrowBO {
    BorrowDAO borrowDAO = new BorrowDAOImpl();
    BranchDAO branchDAO = (BranchDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.BRANCH);
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
    public List<BranchDTO> getAllBranch(){
        List<BranchDTO>branchDTOS =new ArrayList<>();
        List<Branch> branches = branchDAO.getAll();
        for (Branch branch : branches) {
            branchDTOS.add(new BranchDTO(branch.getId(),branch.getAddress(),branch.getOpenedDate()));
        }
        return branchDTOS;
    }
    @Override
    public boolean saveBorrow(BorrowDTO dto){
   /*     Session session =null;
        Transaction transaction=null;
        session = FactoryConfiguration.getInstance().getSession();
        transaction = session.beginTransaction();*/
        UserDTO userDTO = dto.getUser();
        BookDTO bookDTO = dto.getBook();

        boolean isBorrowedSaved = borrowDAO.save(new Borrow(dto.getBorrowedDate(),dto.getReturningDate(),userDTO.toEntity(),bookDTO.toEntity()));
        System.out.println("borrow : "+isBorrowedSaved);
        if (isBorrowedSaved){
            int newBookCount= dto.getBook().getAvailabilityStatus()-1;
            Book newBooks=dto.getBook().toEntity();
            newBooks.setAvailabilityStatus(newBookCount);

            boolean isUpdateBookCount = bookDAO.update(newBooks);
            System.out.println("update book :"+isUpdateBookCount);
            if (isUpdateBookCount){
//                transaction.commit();
                System.out.println("Save and update success !!!");
                return true;
            }
        }
        return false;
    }
}
