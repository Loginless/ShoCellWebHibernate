package ua.com.shocell.DAO;

import ua.com.shocell.configuration.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GenericDAOImpl<T, K> implements GenericDAO {
    private EntityManager entityManager;

    public GenericDAOImpl() {
    }

    public void create(Object object) {
        entityManager = HibernateUtil.getInstance().getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(object);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void createBatch(Object... objects) throws SQLException {
        entityManager = HibernateUtil.getInstance().getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        for (Object tempObjects : objects) {
            entityManager.persist(tempObjects);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public Object getByPK(Class objectClass, int key) throws SQLException {
        T temp;
        entityManager = HibernateUtil.getInstance().getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        temp = (T) entityManager.find(objectClass, key);
        entityManager.getTransaction().commit();
        entityManager.close();
        return temp;
    }

    public void update(Object object) throws SQLException {
        entityManager = HibernateUtil.getInstance().getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(object);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void delete(Object object) throws SQLException {
        entityManager = HibernateUtil.getInstance().getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(object);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<T> getAll(Class objectClass) throws SQLException {
        List<T> listResult = new ArrayList<T>();
        entityManager = HibernateUtil.getInstance().getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(objectClass);
        Root<T> rootClass = criteriaQuery.from(objectClass);
        criteriaQuery.select(rootClass);
        listResult = entityManager.createQuery(criteriaQuery)
                .getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return listResult;
    }

}

