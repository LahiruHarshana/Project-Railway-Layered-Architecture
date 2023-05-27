package lk.ijse.railway.dao;

import lk.ijse.railway.dto.Employee;

import java.sql.SQLException;
import java.util.List;

public interface CrudDAO<T,J> {
    public T search(J text) throws SQLException ;

    public boolean save(T entity) throws SQLException ;

    public boolean update(T entity) throws SQLException;

    public boolean delete(J code) throws SQLException ;

    public List<T> getAll() throws SQLException ;
}
