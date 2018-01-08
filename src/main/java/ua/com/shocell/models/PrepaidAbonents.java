package ua.com.shocell.models;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PREPAID")
public class PrepaidAbonents extends Abonent{

    private static final Logger LOGGER = LogManager.getLogger("ua.com.shoCell.models");


    @Column(name = "FIRST_NAME", nullable = false)
    private String abonentFirstName;

    @Column(name = "LAST_NAME", nullable = false)
    private String abonentLastName;

    public PrepaidAbonents() {
        LOGGER.info("PrePaid abonent is created");

    }

    public String getAbonentFirstName() {
        return abonentFirstName;
    }

    public void setAbonentFirstName(String abonentFirstName) {
        this.abonentFirstName = abonentFirstName;
    }

    public String getAbonentLastName() {
        return abonentLastName;
    }

    public void setAbonentLastName(String abonentLastName) {
        this.abonentLastName = abonentLastName;
    }
}
