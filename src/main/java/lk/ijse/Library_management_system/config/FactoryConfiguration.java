package lk.ijse.Library_management_system.config;
import lk.ijse.Library_management_system.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/*
public class FactoryConfiguration {

    private static FactoryConfiguration factoryConfiguration;
    private final SessionFactory sessionFactory;

    private FactoryConfiguration() throws IOException {
        */
/*Properties properties = new Properties();
            InputStream inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream("hibernate.properties");
            if (inputStream.equals(null)){
                System.out.println("property not added");
            }else {
                System.out.println("property added");
                properties.load(inputStream);
            }
        Configuration configuration = new Configuration()
                .addProperties(properties)
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Book.class)
                .addAnnotatedClass(Borrow.class)
                .addAnnotatedClass(Branch.class);
        sessionFactory = configuration.buildSessionFactory();
        if (sessionFactory == null){
            System.out.println("sectionFactory null");
        }else {
            System.out.println("sectionFactory notnull");
        }*//*

        Properties properties = new Properties();
        InputStream inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream("hibernate.properties");
        properties.load(inputStream);
        Configuration configuration = new Configuration().addProperties(properties).addAnnotatedClass(Author.class).addAnnotatedClass(Book.class).addAnnotatedClass(User.class)
                .addAnnotatedClass(Borrow.class).addAnnotatedClass(Branch.class);
        sessionFactory = configuration.buildSessionFactory();
    }
    public static FactoryConfiguration getInstance() throws IOException {
        return (factoryConfiguration == null) ? factoryConfiguration = new FactoryConfiguration() : factoryConfiguration;
    }

    public Session getSession(){
        return sessionFactory.openSession();
    }
}*/
public class FactoryConfiguration {
    private static FactoryConfiguration factoryConfiguration;
    private SessionFactory sessionFactory;

    private FactoryConfiguration() {
        Properties properties = new Properties();
        InputStream inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream("hibernate.properties");
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Configuration configuration = new Configuration().addProperties(properties).addAnnotatedClass(User.class).addAnnotatedClass(Branch.class).addAnnotatedClass(Book.class).addAnnotatedClass(Borrow.class);
        sessionFactory = configuration.buildSessionFactory();
    }
    public static FactoryConfiguration getInstance() {
        return factoryConfiguration == null ? factoryConfiguration =new FactoryConfiguration() : factoryConfiguration;
    }
    public Session getSession(){
        return sessionFactory.openSession();
    }
}