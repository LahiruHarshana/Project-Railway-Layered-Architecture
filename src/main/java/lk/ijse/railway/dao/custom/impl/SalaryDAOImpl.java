package lk.ijse.railway.dao.custom.impl;

import lk.ijse.railway.dao.custom.SalaryDAO;
import lk.ijse.railway.entity.Salary;
import lk.ijse.railway.dao.custom.impl.util.CrudUtil;

import java.sql.SQLException;
import java.util.List;

public class SalaryDAOImpl implements SalaryDAO {
    @Override
    public Salary search(String text) throws SQLException {
        return null;
    }

    @Override
    public boolean save(Salary entity) throws SQLException {
                String sql = "INSERT INTO Salary(SalaryID, EmployeeID, Date,Amount) " +
                "VALUES(?,?,?,?)";

        return CrudUtil.execute(
                sql,
                entity.getId(),
                entity.getEmpId(),
                entity.getDate(),
                entity.getAmount());
    }

    @Override
    public boolean update(Salary entity) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(String code) throws SQLException {
        return false;
    }

    @Override
    public List<Salary> getAll() throws SQLException {
        return null;
    }
}
