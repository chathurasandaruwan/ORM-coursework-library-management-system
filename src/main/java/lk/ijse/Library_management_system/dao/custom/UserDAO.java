package lk.ijse.Library_management_system.dao.custom;

import lk.ijse.Library_management_system.dao.SupperDAO;
import lk.ijse.Library_management_system.entity.User;

import java.util.List;

public interface UserDAO extends SupperDAO {
    boolean save(User entity);

    List<User> getAll();

    boolean update(User entity);
}
