package ua.com.shocell;

import ua.com.shocell.configuration.HibernateUtil;
import ua.com.shocell.models.WebPortalUser;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class HibernateTest {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = HibernateUtil.getInstance().getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        WebPortalUser admin = new WebPortalUser();
        admin.setUserID(1);
        admin.setLogin("admin");
        admin.setEmail("postbox78@yanex.ru");
        admin.setPassword("admin");

        entityManager.getTransaction().begin();
        entityManager.persist(admin);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
