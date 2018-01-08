package ua.com.shocell.DAO;

import ua.com.shocell.models.Abonent;

import java.util.List;

public interface AbonentDAO {
    public List<Abonent> findByMobNumber(String mobNumber);

    public List<Abonent> findByMobNumberActStatus(Boolean status);

    public List<Abonent> findByContractID(int contractID);

    public List<Abonent> findByPassportNumber(int passportNumber);

    public List<Abonent> findByCompanyName(String companyName);

    public List<Abonent> findByFirstName (String firstName);

    public List<Abonent> findByLastName (String lastName);

}
