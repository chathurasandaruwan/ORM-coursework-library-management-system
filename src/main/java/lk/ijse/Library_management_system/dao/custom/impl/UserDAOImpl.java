package lk.ijse.Library_management_system.dao.custom.impl;

import lk.ijse.Library_management_system.config.FactoryConfiguration;
import lk.ijse.Library_management_system.dao.custom.UserDAO;
import lk.ijse.Library_management_system.dto.UserDTO;
import lk.ijse.Library_management_system.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

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

   public static void main(String[] args) {
       Session session = FactoryConfiguration.getInstance().getSession();
       Transaction transaction = session.beginTransaction();

       User user =new User();
       user.setId(01);
       user.setName("chathura");
       user.setEmail("chathura@1234");
       user.setPassword("1234");
       session.save(user);
       transaction.commit();
       session.close();
   }
}
