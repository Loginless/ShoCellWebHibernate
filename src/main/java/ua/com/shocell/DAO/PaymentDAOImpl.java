package ua.com.shocell.DAO;

import ua.com.shocell.configuration.HibernateUtil;
import ua.com.shocell.models.Payment;
import ua.com.shocell.models.Payment_;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Date;
import java.util.List;

public class PaymentDAOImpl implements PaymentDAO{

    private EntityManager entityManager;

    public PaymentDAOImpl() {
    }

    public List<Payment> findByPaymentDate(Date paymentDate) {
        List<Payment> result;
        entityManager = HibernateUtil.getInstance().getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Payment> paymentCriteriaQuery = criteriaBuilder.createQuery(Payment.class);
        Root<Payment> paymentRoot = paymentCriteriaQuery.from(Payment.class);
        paymentCriteriaQuery.select(paymentRoot);
        paymentCriteriaQuery.where(criteriaBuilder.equal(paymentRoot.get(Payment_.paymentDate), paymentDate));
        result = entityManager.createQuery(paymentCriteriaQuery).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return result;    }

    public List<Payment> findByPaymentDateRange(Date fromDate, Date toDate) {
        List<Payment> result;
        entityManager = HibernateUtil.getInstance().getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Payment> paymentCriteriaQuery = criteriaBuilder.createQuery(Payment.class);
        Root<Payment> paymentRoot = paymentCriteriaQuery.from(Payment.class);
        paymentCriteriaQuery.select(paymentRoot);
        paymentCriteriaQuery.where(criteriaBuilder.between(paymentRoot.get(Payment_.paymentDate), fromDate, toDate));
        result = entityManager.createQuery(paymentCriteriaQuery).getResultList();
        entityManager.getTransaction().commit();
        return result;
    }

    public List<Payment> findByPaymentAmount(int fromAmount, int toAmount) {
        List<Payment> result;
        entityManager = HibernateUtil.getInstance().getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Payment> paymentCriteriaQuery = criteriaBuilder.createQuery(Payment.class);
        Root<Payment> paymentRoot = paymentCriteriaQuery.from(Payment.class);
        paymentCriteriaQuery.select(paymentRoot);
        paymentCriteriaQuery.where(criteriaBuilder.between(paymentRoot.get(Payment_.paymentAmount), fromAmount, toAmount));
        result = entityManager.createQuery(paymentCriteriaQuery).getResultList();
        entityManager.getTransaction().commit();
        return result;    }

    public List<Payment> findByPaymentChannel(String paymentChannel) {
        List<Payment> result;
        entityManager = HibernateUtil.getInstance().getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Payment> paymentCriteriaQuery = criteriaBuilder.createQuery(Payment.class);
        Root<Payment> paymentRoot = paymentCriteriaQuery.from(Payment.class);
        paymentCriteriaQuery.select(paymentRoot);
        paymentCriteriaQuery.where(criteriaBuilder.equal(paymentRoot.get(Payment_.paymentChannel), paymentChannel));
        result = entityManager.createQuery(paymentCriteriaQuery).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return result;     }
}
