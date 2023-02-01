package examm.config;

import examm.model.Instagram_account;
import examm.model.Post;
import examm.model.User;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.HibernateException;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

/**
 * The golden boy
 */
public class HibernateConfig {
    public static EntityManagerFactory createEntityManagerFactory() {
        try {
            Properties prop = new Properties();
            prop.setProperty(Environment.DRIVER, "org.postgresql.Driver");
            prop.setProperty(Environment.URL, "jdbc:postgresql://localhost:5432/exam");
            prop.setProperty(Environment.USER, "postgres");
            prop.setProperty(Environment.PASS, "altynbek695");
            prop.setProperty(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
            prop.setProperty(Environment.HBM2DDL_AUTO, "update");
            prop.setProperty(Environment.FORMAT_SQL, "true");
            Configuration configuration = new Configuration();
            configuration.addProperties(prop);
            configuration.addAnnotatedClass(Instagram_account.class);
            configuration.addAnnotatedClass(Post.class);
            configuration.addAnnotatedClass(User.class);
            return configuration.buildSessionFactory();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }

    }
}
