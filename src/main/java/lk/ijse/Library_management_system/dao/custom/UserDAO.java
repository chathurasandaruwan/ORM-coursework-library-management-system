package lk.ijse.Library_management_system.dao.custom;

import lk.ijse.Library_management_system.dao.CrudDAO;
import lk.ijse.Library_management_system.dao.SupperDAO;
import lk.ijse.Library_management_system.entity.User;

import java.util.List;

public interface UserDAO extends CrudDAO<User> {
    boolean save(User entity);

    List<User> getAll();

    boolean update(User entity);


    boolean delete(long id);
}
