package ua.com.shocell.configuration;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {

    public  static HibernateUtil instance;

    private static EntityManagerFactory entityManagerFactory;

    public HibernateUtil() {
        System.out.println("Hello HibUtil");
        entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
    }

    public static HibernateUtil getInstance(){
        if (instance == null){
            instance = new HibernateUtil();
        }
        return instance;
    }

    public EntityManagerFactory getEntityManagerFactory(){
        return entityManagerFactory;
    }

}

