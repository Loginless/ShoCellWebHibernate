package ua.com.shocell.DAO;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

public interface GenericDAO<T, K extends Serializable> {

    public void create(T object);

    public void createBatch(Object[] objects) throws SQLException;

    public T getByPK(Class objectClass, int key) throws SQLException;

    public void update(T object) throws SQLException;

    public void delete(T object) throws SQLException;

    public List<T> getAll(Class objectClass) throws SQLException;
}

