package lk.ijse.Library_management_system.dao.custom.impl;

import lk.ijse.Library_management_system.config.FactoryConfiguration;
import lk.ijse.Library_management_system.dao.custom.BookDAO;
import lk.ijse.Library_management_system.entity.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

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
    @Override
    public List<Book> getAll(){
        Session session = FactoryConfiguration.getInstance().getSession();
        Query query = session.createQuery("SELECT a FROM Book a", Book.class);
        List<Book> books = query.list();
        session.close();
        return books;
    }
    @Override
    public boolean update(Book entity){
        Session session =FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        session.close();
        return  true;
    }
}
