package lk.ijse.Library_management_system.dao.custom;

import lk.ijse.Library_management_system.dao.CrudDAO;
import lk.ijse.Library_management_system.dao.SupperDAO;
import lk.ijse.Library_management_system.entity.Branch;

import java.util.List;

public interface BranchDAO extends CrudDAO<Branch> {
    boolean save(Branch entity);

    List<Branch> getAll();

    boolean update(Branch entity);

    boolean delete(long id);
}
