package lk.ijse.Library_management_system.dao.custom.impl;

import lk.ijse.Library_management_system.config.FactoryConfiguration;
import lk.ijse.Library_management_system.dao.custom.BorrowDAO;
import lk.ijse.Library_management_system.entity.Borrow;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BorrowDAOImpl implements BorrowDAO {
    @Override
    public boolean save(Borrow entity) {
        Session session =null;
        Transaction transaction=null;
        session = FactoryConfiguration.getInstance().getSession();
        transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        boolean wasCommitted= transaction.getStatus().equals("ACTIVE")?true:false;
        session.close();
        return wasCommitted;
    }
}
