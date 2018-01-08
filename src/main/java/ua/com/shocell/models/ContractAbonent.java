package ua.com.shocell.models;

import org.apache.logging.log4j.*;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "CONTRACT_ABONENTS")
public class ContractAbonent extends Abonent{

    private static final Logger LOGGER = LogManager.getLogger("ua.com.shoCell.models");

    @Column(name = "CONTRACT_ID", nullable = false, unique = true)
    private int contractID;

    @Column(name = "PASSPORT_NUMBER", nullable = false, unique = true)
    private String passportNumber;

    @Column(name = "COMPANY_NAME")
    private String companyName;

    public ContractAbonent() {
        LOGGER.info("ContractAbonent constructor is initiated");

    }

    public int getContractID() {
        return contractID;
    }

    public void setContractID(int contractID) {
        this.contractID = contractID;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
