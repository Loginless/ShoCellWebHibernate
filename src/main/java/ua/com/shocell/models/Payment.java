package ua.com.shocell.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "PAYMENTS")
public class Payment {

    @Id@GeneratedValue
    @Column(name = "PAYMENT_ID")
    private int paymentID;

    @Column(name = "PAYMENT_AMOUNT")
    private int paymentAmount;

    @Column(name = "PAYMENT_DATE")
    private Date paymentDate;

    @Column(name = "PAYMENT_CHANNEL")
    private String paymentChannel;

    @ManyToMany
    Collection<Abonent> abonentsList = new ArrayList<Abonent>();


    public Payment() {
    }

    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public int getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(int paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentChannel() {
        return paymentChannel;
    }

    public void setPaymentChannel(String paymentChannel) {
        this.paymentChannel = paymentChannel;
    }

    public Collection<Abonent> getAbonentsList() {
        return abonentsList;
    }

    public void setAbonentsList(Collection<Abonent> abonentsList) {
        this.abonentsList = abonentsList;
    }
}
