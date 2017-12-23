package ua.com.shocell.DAO;

import ua.com.shocell.configuration.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.sql.SQLException;
import java.util.List;

public class GenericDAOImpl<T, K> implements GenericDAO {
    //    private Class<T> entityClass;
//    private Class<K> keyClass;
    private EntityManager entityManager;

    public GenericDAOImpl() {
        EntityManagerFactory entityManagerFactory = HibernateUtil.getInstance().getEntityManagerFactory();
        entityManager = entityManagerFactory.createEntityManager();
    }

    public void create(Object object) {
        entityManager.getTransaction().begin();
        entityManager.persist(object);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void createBatch(Object... objects) throws SQLException {
        entityManager.getTransaction().begin();
        for (Object tempObjects : objects) {
            entityManager.persist(tempObjects);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public Object getByPK(int key) throws SQLException {
        return null;
    }

    public void update(Object object) throws SQLException {

    }

    public void delete(Object object) throws SQLException {

    }

    public List getAll() throws SQLException {
        return null;
    }
}

