package ua.com.shocell.DAO;

import ua.com.shocell.configuration.HibernateUtil;
import ua.com.shocell.models.WebPortalUser;
import ua.com.shocell.models.WebPortalUser_;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class WebPortalUsedDAOImpl implements WebPortalUserDAO{

    private EntityManager entityManager;

    public WebPortalUsedDAOImpl() {
    }

    public List<WebPortalUser> findByLogin(String login) {
        List<WebPortalUser> result;
        entityManager = HibernateUtil.getInstance().getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<WebPortalUser> webUserLoginCriteria = criteriaBuilder.createQuery(WebPortalUser.class);
        Root<WebPortalUser> webPortalUserRoot = webUserLoginCriteria.from(WebPortalUser.class);
        webUserLoginCriteria.select(webPortalUserRoot);
        webUserLoginCriteria.where(criteriaBuilder.equal(webPortalUserRoot.get(WebPortalUser_.login),login));
        result = entityManager.createQuery(webUserLoginCriteria).setFirstResult(0).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return result;
    }

    public List<WebPortalUser> findByEmail(String email) {
        List<WebPortalUser> result;
        entityManager = HibernateUtil.getInstance().getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<WebPortalUser> webUserEmailCriteria = criteriaBuilder.createQuery(WebPortalUser.class);
        Root<WebPortalUser> webPortalUserRoot = webUserEmailCriteria.from(WebPortalUser.class);
        webUserEmailCriteria.select(webPortalUserRoot);
        webUserEmailCriteria.where(criteriaBuilder.equal(webPortalUserRoot.get(WebPortalUser_.email),email));
        result = entityManager.createQuery(webUserEmailCriteria).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return result;
    }

    public List<WebPortalUser> findByEnabled(Boolean enabledStatus) {
        List<WebPortalUser> result;
        entityManager = HibernateUtil.getInstance().getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<WebPortalUser> webUserEnabledCriteria = criteriaBuilder.createQuery(WebPortalUser.class);
        Root<WebPortalUser> webPortalUserRoot = webUserEnabledCriteria.from(WebPortalUser.class);
        webUserEnabledCriteria.select(webPortalUserRoot);
        webUserEnabledCriteria.where(criteriaBuilder.equal(webPortalUserRoot.get(WebPortalUser_.enabled),enabledStatus));
        result = entityManager.createQuery(webUserEnabledCriteria).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return result;
    }
}
