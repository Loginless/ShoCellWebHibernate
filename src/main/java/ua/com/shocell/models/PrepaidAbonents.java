package ua.com.shocell.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PREPAID")
public class PrepaidAbonents extends Abonent{

    @Column(name = "FIRST_NAME", nullable = false)
    private String abonentFirstName;

    @Column(name = "LAST_NAME", nullable = false)
    private String abonentLastName;

    public PrepaidAbonents() {
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
