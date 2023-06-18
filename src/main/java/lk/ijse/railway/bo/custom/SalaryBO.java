package lk.ijse.railway.bo.custom;

import lk.ijse.railway.bo.SuperBO;
import lk.ijse.railway.entity.Salary;
import lk.ijse.railway.model.EmployeeDTO;

import java.sql.SQLException;

public interface SalaryBO extends SuperBO {
    public EmployeeDTO search(String text) throws SQLException ;
    public boolean save(Salary entity) throws SQLException ;
}
