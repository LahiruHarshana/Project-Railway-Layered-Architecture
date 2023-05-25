package lk.ijse.railway.dao;

import lk.ijse.railway.db.DBConnection;
import lk.ijse.railway.dto.Employee;
import lk.ijse.railway.util.CrudUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl {
    public static Employee search(String text) throws SQLException {
        String sql = "SELECT * FROM Employee WHERE EmployeeID = ?";
        ResultSet rst = CrudUtil.execute(sql, text);


        if (rst.next()){
            return new Employee(rst.getString(1),rst.getString(2),rst.getDate(3),rst.getString(4),rst.getString(5));
        }
        return null;

    }

    public static boolean save(Employee employee) throws SQLException {
            String sql = "INSERT INTO Employee(EmployeeID, EmpName, EmpDob,EmpContact,EmpAddress) " +
                    "VALUES(?,?,?,?,?)";

        return CrudUtil.execute(
                sql,
                employee.getId(),
                employee.getName(),
                employee.getDob(),
                employee.getContact(),
                employee.getAddress());

    }

    public static boolean update(Employee employee) throws SQLException {

        String sql = "UPDATE Employee SET  EmpName = ?, EmpDob = ?, EmpContact =?, EmpAddress = ? WHERE EmployeeID = ?";
        return CrudUtil.execute(
                sql,
                employee.getName(),
                employee.getDob(),
                employee.getContact(),
                employee.getAddress(),
                employee.getId());
    }

    public static boolean delete(String code) throws SQLException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "DELETE FROM Employee WHERE EmployeeID = ?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, code);

            return pstm.executeUpdate() > 0;
    }

    public static List<Employee> getAll() throws SQLException {
        List<Employee> data = new ArrayList<>();

        String sql = "SELECT * FROM Employee";
        ResultSet resultSet = CrudUtil.execute(sql);

        while (resultSet.next()) {
            data.add(new Employee(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getDate(3),
                    resultSet.getString(4),
                    resultSet.getString(5)
            ));
        }
        return data;

    }
}
