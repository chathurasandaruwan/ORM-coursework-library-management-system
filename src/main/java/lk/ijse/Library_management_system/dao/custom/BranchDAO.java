package lk.ijse.Library_management_system.dao.custom;

import lk.ijse.Library_management_system.dao.SupperDAO;
import lk.ijse.Library_management_system.entity.Branch;

public interface BranchDAO extends SupperDAO {
    boolean save(Branch entity);
}
