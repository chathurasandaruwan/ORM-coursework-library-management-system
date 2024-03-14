package lk.ijse.Library_management_system.dao.custom;

import lk.ijse.Library_management_system.dao.SupperDAO;
import lk.ijse.Library_management_system.entity.Borrow;
import org.hibernate.Session;

public interface BorrowDAO extends SupperDAO {
    boolean save(Borrow entity);
}
