package lk.ijse.railway.bo.custom.impl;

import lk.ijse.railway.dao.custom.impl.EmployeeDAOImpl;
import lk.ijse.railway.dao.custom.impl.SalaryDAOImpl;
import lk.ijse.railway.dto.Employee;
import lk.ijse.railway.dto.Salary;
import lk.ijse.railway.model.EmployeeDTO;
import lk.ijse.railway.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SalaryBOImpl {
    EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
    SalaryDAOImpl salaryDAO = new SalaryDAOImpl();
    public EmployeeDTO search(String text) throws SQLException {
        return new EmployeeDTO(employeeDAO.search(text));

    }
    public boolean save(Salary entity) throws SQLException {
        return salaryDAO.save(entity);
    }
}
