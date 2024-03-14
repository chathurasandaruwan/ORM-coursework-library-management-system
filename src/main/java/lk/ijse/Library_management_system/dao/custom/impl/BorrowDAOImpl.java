package lk.ijse.Library_management_system.dao.custom.impl;

import lk.ijse.Library_management_system.config.FactoryConfiguration;
import lk.ijse.Library_management_system.dao.custom.BorrowDAO;
import lk.ijse.Library_management_system.entity.Borrow;
import org.hibernate.Session;

import java.sql.SQLException;

public class BorrowDAOImpl implements BorrowDAO {
    public boolean save(Borrow entity)throws SQLException {
        Session session = FactoryConfiguration.getInstance().getSession();
        session.save(entity);
        session.close();
        return true;
    }
}
