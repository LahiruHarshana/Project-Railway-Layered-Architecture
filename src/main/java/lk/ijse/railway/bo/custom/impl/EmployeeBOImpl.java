package lk.ijse.railway.bo.custom.impl;

import lk.ijse.railway.dao.custom.EmployeeDAO;
import lk.ijse.railway.dao.custom.impl.EmployeeDAOImpl;
import lk.ijse.railway.dto.Employee;
import lk.ijse.railway.model.EmployeeDTO;
import lk.ijse.railway.util.CrudUtil;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeBOImpl {

    EmployeeDAO employeeDAO = new EmployeeDAOImpl();
    public boolean save(Employee entity) throws SQLException {
        return employeeDAO.save(entity);
    }

    public boolean delete(String code) throws SQLException {
        return employeeDAO.delete(code);
    }

    public EmployeeDTO search(String text) throws SQLException {
        return new EmployeeDTO(employeeDAO.search(text));
    }
    public boolean update(Employee entity) throws SQLException {
        return employeeDAO.update(entity);
    }
    public List<EmployeeDTO> getAll() throws SQLException {
        List<Employee> allEntityData = employeeDAO.getAll();
        ArrayList<EmployeeDTO> allDTOData= new ArrayList<>();
        for (Employee i : allEntityData) {
            allDTOData.add(new EmployeeDTO(i.getId(),i.getName(),i.getDob(),i.getContact(),i.getAddress()));
        }
        return allDTOData;
    }
}
