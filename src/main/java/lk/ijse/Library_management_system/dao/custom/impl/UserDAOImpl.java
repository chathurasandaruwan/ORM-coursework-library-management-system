package lk.ijse.Library_management_system.dao.custom.impl;

import lk.ijse.Library_management_system.config.FactoryConfiguration;
import lk.ijse.Library_management_system.dao.custom.UserDAO;
import lk.ijse.Library_management_system.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class UserDAOImpl implements UserDAO {
@Override
public boolean save(User entity){
    Session session = FactoryConfiguration.getInstance().getSession();
    Transaction transaction = session.beginTransaction();
    session.save(entity);
    transaction.commit();
    session.close();
    return true;
}
@Override
public List<User> getAll(){
    Session session = FactoryConfiguration.getInstance().getSession();
    Query query = session.createQuery("SELECT a FROM User a", User.class);
    List<User> users= query.list();
    session.close();
    return users;
}
@Override
public boolean update(User entity){
    Session session = FactoryConfiguration.getInstance().getSession();
    Transaction transaction = session.beginTransaction();
    session.update(entity);
    transaction.commit();
    session.close();
    return true;
}

}
