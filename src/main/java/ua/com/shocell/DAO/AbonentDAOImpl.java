package ua.com.shocell.DAO;

import ua.com.shocell.configuration.HibernateUtil;
import ua.com.shocell.models.*;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class AbonentDAOImpl implements AbonentDAO {

    private EntityManager entityManager;

    public AbonentDAOImpl() {
    }

    public List<Abonent> findByMobNumber(String mobNumber) {
        List<Abonent> result;
        entityManager = HibernateUtil.getInstance().getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Abonent> abonentCriteriaQuery = criteriaBuilder.createQuery(Abonent.class);
        Root<Abonent> abonentRoot = abonentCriteriaQuery.from(Abonent.class);
        abonentCriteriaQuery.select(abonentRoot);
        abonentCriteriaQuery.where(criteriaBuilder.equal(abonentRoot.get(Abonent_.mobileNumber), mobNumber));
        result = entityManager.createQuery(abonentCriteriaQuery).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return result;
    }

    public List<Abonent> findByMobNumberActStatus(Boolean status) {
        List<Abonent> result;
        entityManager = HibernateUtil.getInstance().getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Abonent> abonentCriteriaQuery = criteriaBuilder.createQuery(Abonent.class);
        Root<Abonent> abonentRoot = abonentCriteriaQuery.from(Abonent.class);
        abonentCriteriaQuery.select(abonentRoot);
        abonentCriteriaQuery.where(criteriaBuilder.equal(abonentRoot.get(Abonent_.mobileNumberActiveStatus), status));
        result = entityManager.createQuery(abonentCriteriaQuery).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return result;
    }

    public List<Abonent> findByContractID(int contractID) {
        List<Abonent> result;
        entityManager = HibernateUtil.getInstance().getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Abonent> abonentCriteriaQuery = criteriaBuilder.createQuery(Abonent.class);
        Root<ContractAbonent> abonentRoot = abonentCriteriaQuery.from(ContractAbonent.class);
        abonentCriteriaQuery.select(abonentRoot);
        abonentCriteriaQuery.where(criteriaBuilder.equal(abonentRoot.get(ContractAbonent_.contractID), contractID));
        result = entityManager.createQuery(abonentCriteriaQuery).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return result;
    }

    public List<Abonent> findByPassportNumber(int passportNumber) {
        List<Abonent> result;
        entityManager = HibernateUtil.getInstance().getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Abonent> abonentCriteriaQuery = criteriaBuilder.createQuery(Abonent.class);
        Root<ContractAbonent> abonentRoot = abonentCriteriaQuery.from(ContractAbonent.class);
        abonentCriteriaQuery.select(abonentRoot);
        abonentCriteriaQuery.where(criteriaBuilder.equal(abonentRoot.get(ContractAbonent_.passportNumber), passportNumber));
        result = entityManager.createQuery(abonentCriteriaQuery).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return result;
    }

    public List<Abonent> findByCompanyName(String companyName) {
        List<Abonent> result;
        entityManager = HibernateUtil.getInstance().getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Abonent> abonentCriteriaQuery = criteriaBuilder.createQuery(Abonent.class);
        Root<ContractAbonent> abonentRoot = abonentCriteriaQuery.from(ContractAbonent.class);
        abonentCriteriaQuery.select(abonentRoot);
        abonentCriteriaQuery.where(criteriaBuilder.equal(abonentRoot.get(ContractAbonent_.companyName), companyName));
        result = entityManager.createQuery(abonentCriteriaQuery).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return result;
    }

    public List<Abonent> findByFirstName(String firstName) {
        List<Abonent> result;
        entityManager = HibernateUtil.getInstance().getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Abonent> abonentCriteriaQuery = criteriaBuilder.createQuery(Abonent.class);
        Root<PrepaidAbonents> abonentRoot = abonentCriteriaQuery.from(PrepaidAbonents.class);
        abonentCriteriaQuery.select(abonentRoot);
        abonentCriteriaQuery.where(criteriaBuilder.equal(abonentRoot.get(PrepaidAbonents_.abonentFirstName), firstName));
        result = entityManager.createQuery(abonentCriteriaQuery).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return result;
    }

    public List<Abonent> findByLastName(String lastName) {
        List<Abonent> result;
        entityManager = HibernateUtil.getInstance().getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Abonent> abonentCriteriaQuery = criteriaBuilder.createQuery(Abonent.class);
        Root<PrepaidAbonents> abonentRoot = abonentCriteriaQuery.from(PrepaidAbonents.class);
        abonentCriteriaQuery.select(abonentRoot);
        abonentCriteriaQuery.where(criteriaBuilder.equal(abonentRoot.get(PrepaidAbonents_.abonentLastName), lastName));
        result = entityManager.createQuery(abonentCriteriaQuery).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return result;
    }
}
