package lk.ijse.Library_management_system.dao.custom.impl;

import lk.ijse.Library_management_system.config.FactoryConfiguration;
import lk.ijse.Library_management_system.dao.custom.UserDAO;
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

   /* public static void main(String[] args) {
//        Session session= FactoryConfiguration.getInstance().getSession();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        User user =new User();
        user.setName("chathura");
        user.setEmail("chathura@1234");
        user.setPassword("1234");
        session.save(user);
        transaction.commit();
        session.close();
    }*/
   public static void main(String[] args) {
       // Obtain a Hibernate session
       Session session = FactoryConfiguration.getInstance().getSession();

       // Begin a transaction
       Transaction transaction = null;

       try {
           transaction = session.beginTransaction();

           // Create a new Book entity and save it to the database
           User user =new User();
           user.setName("chathura");
           user.setEmail("chathura@1234");
           user.setPassword("1234");
           session.save(user);

           // Commit the transaction
           transaction.commit();
       } catch (Exception e) {
           // Rollback the transaction in case of an exception
           if (transaction != null) {
               transaction.rollback();
           }
           e.printStackTrace();
       } finally {
           // Close the Hibernate session
           session.close();
       }
   }
}
