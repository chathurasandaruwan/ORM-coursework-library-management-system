package lk.ijse.Library_management_system.bo.custom.impl;

import lk.ijse.Library_management_system.bo.custom.BranchBO;
import lk.ijse.Library_management_system.dao.custom.BranchDAO;
import lk.ijse.Library_management_system.dao.custom.impl.BranchDAOImpl;
import lk.ijse.Library_management_system.dto.BranchDTO;
import lk.ijse.Library_management_system.entity.Branch;

public class BranchBOImpl implements BranchBO {
    BranchDAO branchDAO = new BranchDAOImpl();
    @Override
    public boolean saveBranch(BranchDTO dto){
        return branchDAO.save(new Branch(dto.getAddress(),dto.getOpenedDate()));
    }
}
