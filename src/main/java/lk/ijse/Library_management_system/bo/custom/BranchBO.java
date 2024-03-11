package lk.ijse.Library_management_system.bo.custom;

import lk.ijse.Library_management_system.bo.SupperBO;
import lk.ijse.Library_management_system.dto.BranchDTO;

import java.util.List;

public interface BranchBO extends SupperBO {
    boolean saveBranch(BranchDTO dto);

    List<BranchDTO> getAllBranch();
}
