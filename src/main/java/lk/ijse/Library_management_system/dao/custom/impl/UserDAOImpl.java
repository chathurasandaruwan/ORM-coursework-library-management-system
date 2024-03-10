package lk.ijse.Library_management_system.dao.custom.impl;

import lk.ijse.Library_management_system.config.FactoryConfiguration;
import lk.ijse.Library_management_system.dao.custom.UserDAO;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;

public class UserDAOImpl implements UserDAO {
public void saveUser(){
    /*Session session= FactoryConfiguration.getInstance().getSession();
    Transaction transaction = session.beginTransaction();
    User user =new User();
    user.setName("chathura");
    user.setEmail("chathura@1234");
    user.setPassword("1234");
    session.save(user);
    transaction.commit();
    session.close();*/
}

}
