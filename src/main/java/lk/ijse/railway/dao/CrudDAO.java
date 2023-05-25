package lk.ijse.railway.dao;

import lk.ijse.railway.db.DBConnection;
import lk.ijse.railway.dto.Employee;
import lk.ijse.railway.util.CrudUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface CrudDAO {
    public Employee search(String text) throws SQLException ;

    public boolean save(Employee employee) throws SQLException ;

    public boolean update(Employee employee) throws SQLException;

    public boolean delete(String code) throws SQLException ;

    public List<Employee> getAll() throws SQLException ;
}
