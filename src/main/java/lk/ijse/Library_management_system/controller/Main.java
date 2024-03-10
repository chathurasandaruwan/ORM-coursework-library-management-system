package lk.ijse.Library_management_system.controller;


import lk.ijse.Library_management_system.config.FactoryConfiguration;
import lk.ijse.Library_management_system.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class Main {
    public static void main(String[] args) {


                Session session = FactoryConfiguration.getInstance().getSession();
                Transaction transaction = session.beginTransaction();
                User user = new User();
                user.setName("chathura");
                user.setEmail("Chathura@1234");
                user.setPassword("1234");
                session.save(user);
                transaction.commit();
                session.close();

    }
}
