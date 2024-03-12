package lk.ijse.Library_management_system.dao.custom.impl;

import lk.ijse.Library_management_system.config.FactoryConfiguration;
import lk.ijse.Library_management_system.dao.custom.BookDAO;
import lk.ijse.Library_management_system.entity.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BookDAOImpl implements BookDAO {
    @Override
    public boolean save(Book entity){
    Session session = FactoryConfiguration.getInstance().getSession();
    Transaction transaction = session.beginTransaction();
    session.save(entity);
    transaction.commit();
    session.close();
    return true;
}
}
