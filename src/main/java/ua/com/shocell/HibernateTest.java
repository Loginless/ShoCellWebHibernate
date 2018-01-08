package ua.com.shocell;

import ua.com.shocell.DAO.GenericDAOImpl;
import ua.com.shocell.DAO.WebPortalUsedDAOImpl;
import ua.com.shocell.configuration.HibernateUtil;
import ua.com.shocell.models.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HibernateTest {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = HibernateUtil.getInstance().getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();



        //Admin user
        WebPortalUser admin = new WebPortalUser();
        admin.setLogin("admin");
        admin.setEmail("admin@yanex.ru");
        admin.setPassword("admin");
        admin.setEnabled(true);

        //User user
        WebPortalUser user1 = new WebPortalUser();
        user1.setLogin("test1");
        user1.setEmail("test1@yanex.ru");
        user1.setPassword("user1");
        user1.setEnabled(true);

        WebPortalUser user2 = new WebPortalUser();
        user2.setLogin("test2");
        user2.setEmail("test2@yanex.ru");
        user2.setPassword("user");
        user2.setEnabled(true);

        WebPortalUserRole roleAdmin = new WebPortalUserRole();
        roleAdmin.setRole_name("ADMIN");

        WebPortalUserRole roleUser = new WebPortalUserRole();
        roleUser.setRole_name("USER");

        //Abonents

        PrepaidAbonents prepaidAbonent1 = new PrepaidAbonents();
        prepaidAbonent1.setMobileNumber("+38023321123");
        prepaidAbonent1.setMobileNumberActiveStatus(true);
        prepaidAbonent1.setAbonentFirstName("Andrey");
        prepaidAbonent1.setAbonentLastName("Shokotko");
        ContractAbonent contractAbonent1 = new ContractAbonent();
        contractAbonent1.setCompanyName("BICS");
        contractAbonent1.setContractID(1);
        contractAbonent1.setPassportNumber("ID867231");
        contractAbonent1.setMobileNumber("+38042323313");
        contractAbonent1.setMobileNumberActiveStatus(true);

        //Web users and roles connection
        roleAdmin.getWebPortalUsers().add(admin);
//        admin.setWebPortalUserRole(roleAdmin);

//        user.setWebPortalUserRole(roleUser);
//        roleUser.getWebPortalUsers().add(user);

        //Transactions
//        entityManager.getTransaction().begin();
//        entityManager.persist(roleAdmin);
//        entityManager.persist(roleUser);
//        entityManager.persist(admin);
//        entityManager.persist(user);
//        entityManager.persist(prepaidAbonent1);
//        entityManager.persist(contractAbonent1);
//        entityManager.createQuery("from abonents");
//        entityManager.getTransaction().commit();
//        entityManager.close();

//        WebPortalUser test1;
//        WebPortalUser test2;
//        entityManager.getTransaction().begin();
//        test1 = entityManager.find(WebPortalUser.class,10);
//        System.out.println(test1);
////        test1.setEnabled(true);
////        entityManager.merge(test1);
////        test2 = entityManager.find(WebPortalUser.class,10);
////        System.out.println(test2);
//        System.out.println(test1);
//        entityManager.getTransaction().commit();
//        entityManager.close();
//
//        EntityManager entityManager2 = entityManagerFactory.createEntityManager();
//
//        entityManager2.getTransaction().begin();
//        test2 = entityManager.find(WebPortalUser.class,10);
////        test1.setEnabled(true);
////        entityManager.merge(test1);
////        test2 = entityManager.find(WebPortalUser.class,10);
////        System.out.println(test2);
//
//        entityManager2.getTransaction().commit();
//        entityManager2.close();
//        System.out.println(test2);
//        HibernateUtil.getInstance().closeEntityManagerFactory();

//
//        WebPortalUser test = null;

//        entityManager.getTransaction().begin();
//        Query query = entityManager.createQuery("from WebPortalUser");
//
//        List<WebPortalUser> queryResult = query.getResultList();
//        System.out.println(queryResult.get(0));
//
//        entityManager.getTransaction().commit();
//        entityManager.close();

//        WebPortalUsedDAOImpl webPortalUsedDAO = new WebPortalUsedDAOImpl();
//        List<WebPortalUser> testUser1 = new ArrayList<WebPortalUser>();
//        List<WebPortalUser> testUser2 = new ArrayList<WebPortalUser>();
////
//        testUser1 = webPortalUsedDAO.findByLogin("admin");
//
//        testUser2 = webPortalUsedDAO.findByLogin("admin");
//
//        System.out.println(testUser1);
//        System.out.println(testUser2);

        List<WebPortalUser> test1;
        List<WebPortalUser> test2;

        WebPortalUsedDAOImpl webPortalUsedDAO = new WebPortalUsedDAOImpl();

        test1 = webPortalUsedDAO.findByLogin("admin");
        test2 = webPortalUsedDAO.findByLogin("admin");

        HibernateUtil.getInstance().closeEntityManagerFactory();

    }
}
