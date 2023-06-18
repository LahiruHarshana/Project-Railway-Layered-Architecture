package lk.ijse.railway.bo.custom;

import lk.ijse.railway.bo.SuperBO;
import lk.ijse.railway.entity.Employee;
import lk.ijse.railway.model.EmployeeDTO;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeBO extends SuperBO {
    public boolean save(Employee entity) throws SQLException ;

    public boolean delete(String code) throws SQLException ;

    public EmployeeDTO search(String text) throws SQLException ;
    public boolean update(Employee entity) throws SQLException ;
    public List<EmployeeDTO> getAll() throws SQLException ;
}
