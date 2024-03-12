package lk.ijse.Library_management_system.dao.custom;

import lk.ijse.Library_management_system.dao.SupperDAO;
import lk.ijse.Library_management_system.entity.Book;

import java.util.List;

public interface BookDAO extends SupperDAO {
    boolean save(Book entity);

    List<Book> getAll();
}
