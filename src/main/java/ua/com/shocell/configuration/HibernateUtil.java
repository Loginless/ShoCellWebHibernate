package ua.com.shocell.configuration;

import org.apache.logging.log4j.*;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {

    private static final Logger LOGGER = LogManager.getLogger("ua.com.shoCell.configuration");

    public  static HibernateUtil instance;

    private static EntityManagerFactory entityManagerFactory;

    public HibernateUtil() {
        LOGGER.info("HibernateUtil constructor is initiated");
        System.out.println("Hello HibUtil");
        entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
    }

    public static HibernateUtil getInstance(){
        LOGGER.info("HibernateUtil instance is requested");
        if (instance == null){
            instance = new HibernateUtil();
        }
        return instance;
    }

    public EntityManagerFactory getEntityManagerFactory(){
        return entityManagerFactory;
    }

    public void closeEntityManagerFactory(){
        entityManagerFactory.close();
    }
}


