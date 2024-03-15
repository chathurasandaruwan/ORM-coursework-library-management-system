package lk.ijse.Library_management_system.dao.custom.impl;

import lk.ijse.Library_management_system.config.FactoryConfiguration;
import lk.ijse.Library_management_system.dao.custom.BorrowDAO;
import lk.ijse.Library_management_system.entity.Borrow;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class BorrowDAOImpl implements BorrowDAO {
    @Override
    public boolean save(Borrow entity) {
        Session session =null;
        session = FactoryConfiguration.getInstance().getSession();
        session.save(entity);
        session.close();
        return true;
    }
    @Override
    public List<Borrow> getAll(){
        Session session = FactoryConfiguration.getInstance().getSession();
        Query query = session.createQuery("SELECT a FROM Borrow a", Borrow.class);
        List<Borrow>  borrows= query.list();
        session.close();
        return borrows;
    }
}
