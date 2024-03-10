package lk.ijse.Library_management_system.config;
import lk.ijse.Library_management_system.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

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
        Configuration configuration = new Configuration()
                .addProperties(properties)
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Branch.class)
                .addAnnotatedClass(Book.class)
                .addAnnotatedClass(Borrow.class);
        sessionFactory = configuration.buildSessionFactory();
    }
    public static FactoryConfiguration getInstance() {
        return factoryConfiguration == null ? factoryConfiguration =new FactoryConfiguration() : factoryConfiguration;
    }
    public Session getSession(){
        return sessionFactory.openSession();
    }
}