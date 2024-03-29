package lk.ijse.Library_management_system.bo.custom.impl;

import lk.ijse.Library_management_system.bo.custom.BranchBO;
import lk.ijse.Library_management_system.dao.DAOFactory;
import lk.ijse.Library_management_system.dao.custom.BranchDAO;
import lk.ijse.Library_management_system.dao.custom.impl.BranchDAOImpl;
import lk.ijse.Library_management_system.dto.BranchDTO;
import lk.ijse.Library_management_system.entity.Branch;

import java.util.ArrayList;
import java.util.List;

public class BranchBOImpl implements BranchBO {
    BranchDAO branchDAO = (BranchDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.BRANCH);
    @Override
    public boolean saveBranch(BranchDTO dto){
        return branchDAO.save(new Branch(dto.getAddress(),dto.getOpenedDate()));
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
    public boolean updateBranch(BranchDTO dto){
        return branchDAO.update(new Branch(dto.getId(),dto.getAddress(),dto.getOpenedDate()));
    }
    @Override
    public boolean deleteBranch(long id){
        return branchDAO.delete(id);
    }
}
