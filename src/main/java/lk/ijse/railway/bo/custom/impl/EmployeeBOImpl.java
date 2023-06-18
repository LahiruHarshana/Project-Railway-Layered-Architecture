package lk.ijse.railway.bo.custom.impl;

import lk.ijse.railway.bo.custom.EmployeeBO;
import lk.ijse.railway.dao.DAOFactory;
import lk.ijse.railway.dao.custom.EmployeeDAO;
import lk.ijse.railway.entity.Employee;
import lk.ijse.railway.model.EmployeeDTO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeBOImpl implements EmployeeBO {

    EmployeeDAO employeeDAO = (EmployeeDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.EMPLOYEE);
    @Override
    public boolean save(Employee entity) throws SQLException {
        return employeeDAO.save(entity);
    }
    @Override

    public boolean delete(String code) throws SQLException {
        return employeeDAO.delete(code);
    }
    @Override

    public EmployeeDTO search(String text) throws SQLException {
        return new EmployeeDTO(employeeDAO.search(text));
    }
    @Override
    public boolean update(Employee entity) throws SQLException {
        return employeeDAO.update(entity);
    }
    @Override
    public List<EmployeeDTO> getAll() throws SQLException {
        List<Employee> allEntityData = employeeDAO.getAll();
        ArrayList<EmployeeDTO> allDTOData= new ArrayList<>();
        for (Employee i : allEntityData) {
            allDTOData.add(new EmployeeDTO(i.getId(),i.getName(),i.getDob(),i.getContact(),i.getAddress()));
        }
        return allDTOData;
    }
}
