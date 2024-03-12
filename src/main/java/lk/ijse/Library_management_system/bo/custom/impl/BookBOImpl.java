package lk.ijse.Library_management_system.bo.custom.impl;

import lk.ijse.Library_management_system.bo.custom.BookBO;
import lk.ijse.Library_management_system.dao.custom.BookDAO;
import lk.ijse.Library_management_system.dao.custom.BranchDAO;
import lk.ijse.Library_management_system.dao.custom.impl.BookDAOImpl;
import lk.ijse.Library_management_system.dao.custom.impl.BranchDAOImpl;
import lk.ijse.Library_management_system.dto.BookDTO;
import lk.ijse.Library_management_system.dto.BranchDTO;
import lk.ijse.Library_management_system.entity.Book;
import lk.ijse.Library_management_system.entity.Branch;

import java.util.ArrayList;
import java.util.List;

public class BookBOImpl implements BookBO {
    BranchDAO branchDAO = new BranchDAOImpl();
    BookDAO bookDAO = new BookDAOImpl();

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
    public  boolean saveBook(BookDTO dto){
        BranchDTO branchDTO = new BranchDTO();
        return bookDAO.save(new Book(dto.getTitle(), dto.getAuthor(), dto.getAvailabilityStatus(),dto.getGeneration(),branchDTO.toEntity(dto.getBranch())));
    }

}
