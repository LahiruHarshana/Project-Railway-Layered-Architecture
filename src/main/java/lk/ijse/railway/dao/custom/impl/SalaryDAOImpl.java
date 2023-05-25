package lk.ijse.railway.dao.custom.impl;

import lk.ijse.railway.dto.Salary;
import lk.ijse.railway.util.CrudUtil;

import java.sql.SQLException;

public class SalaryDAOImpl {
    public static boolean save(Salary salary) throws SQLException {

        String sql = "INSERT INTO Salary(SalaryID, EmployeeID, Date,Amount) " +
                "VALUES(?,?,?,?)";

        return CrudUtil.execute(
                sql,
                salary.getId(),
                salary.getEmpId(),
                salary.getDate(),
                salary.getAmount());
    }
}