package lk.ijse.Library_management_system.config;
import lk.ijse.Library_management_system.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FactoryConfiguration {

    private static FactoryConfiguration factoryConfiguration;
    private final SessionFactory sessionFactory;

    private FactoryConfiguration(){
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("hibernate.properties"));
        }catch (IOException e) {
            e.printStackTrace();
        }
        Configuration configuration = new Configuration()
                .addProperties(properties)
                .addAnnotatedClass(User.class);
        sessionFactory = configuration.buildSessionFactory();
    }
    public static FactoryConfiguration getInstance(){
        return (factoryConfiguration == null) ? factoryConfiguration = new FactoryConfiguration() : factoryConfiguration;
    }

    public Session getSession(){
        return sessionFactory.openSession();
    }
}