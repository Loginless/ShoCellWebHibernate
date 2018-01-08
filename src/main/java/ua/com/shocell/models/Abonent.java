package ua.com.shocell.models;

import org.apache.logging.log4j.*;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Table(name = "ABONENTS")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name = "ABONENT_TYPE",
                    discriminatorType = DiscriminatorType.STRING)
public abstract class Abonent {

    private static final Logger LOGGER = LogManager.getLogger("ua.com.shoCell.models");

    @Id
    @GeneratedValue
    @Column(name = "ABONENT_ID")
    private int abonentID;

    @Column(name = "MOBILE_NUMBER", nullable = false, unique = true)
    private String mobileNumber;

    @Temporal(TemporalType.DATE)
    private Date joinDate;

    @Column(name = "MOBILE_NUMBER_ACTIVE_STATUS", nullable = false)
    private boolean mobileNumberActiveStatus;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "WEBPORTAL_USER_ID")
    private WebPortalUser webPortalUserID;

    @ManyToMany
    private Collection<Payment> paymentsList = new ArrayList<Payment>();

    public Abonent() {
        LOGGER.info("Abonent is created");
    }

    public int getAbonentID() {
        return abonentID;
    }

    public void setAbonentID(int abonentID) {
        this.abonentID = abonentID;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public boolean isMobileNumberActiveStatus() {
        return mobileNumberActiveStatus;
    }

    public void setMobileNumberActiveStatus(boolean mobileNumberActiveStatus) {
        this.mobileNumberActiveStatus = mobileNumberActiveStatus;
    }

    public WebPortalUser getWebPortalUserID() {
        return webPortalUserID;
    }

    public void setWebPortalUserID(WebPortalUser webPortalUserID) {
        this.webPortalUserID = webPortalUserID;
    }

    public Collection<Payment> getPaymentsList() {
        return paymentsList;
    }

    public void setPaymentsList(Collection<Payment> paymentsList) {
        this.paymentsList = paymentsList;
    }

    @Override
    public String toString() {
        return "Abonent{" +
                "abonentID=" + abonentID +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", joinDate=" + joinDate +
                ", mobileNumberActiveStatus=" + mobileNumberActiveStatus +
                ", webPortalUserID=" + webPortalUserID +
                ", paymentsList=" + paymentsList +
                '}';
    }
}
