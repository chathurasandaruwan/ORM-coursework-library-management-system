package lk.ijse.Library_management_system.dao.custom;

import lk.ijse.Library_management_system.dao.CrudDAO;
import lk.ijse.Library_management_system.dao.SupperDAO;
import lk.ijse.Library_management_system.entity.Borrow;
import org.hibernate.Session;

import java.util.List;

public interface BorrowDAO extends CrudDAO<Borrow> {
    boolean save(Borrow entity);

    List<Borrow> getAll();

    boolean delete(long id);
}
