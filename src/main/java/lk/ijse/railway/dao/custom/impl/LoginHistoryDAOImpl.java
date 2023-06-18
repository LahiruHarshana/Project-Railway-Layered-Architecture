package lk.ijse.railway.dao.custom.impl;

import lk.ijse.railway.dao.custom.LoginHistoryDAO;
import lk.ijse.railway.entity.LoginHistory;
import lk.ijse.railway.dao.custom.impl.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoginHistoryDAOImpl implements LoginHistoryDAO {
    @Override
    public LoginHistory search(String text) throws SQLException {
        return null;
    }

    @Override
    public boolean save(LoginHistory entity) throws SQLException {

        {
            String sql = "INSERT INTO LogHistory(UserID, LogInDate, LogInTime) " +
                    "VALUES(?,?,?)";

            return CrudUtil.execute(
                    sql,
                    entity.getUId(),entity.getLogInDate(),entity.getLogInTime());

        }
    }

    @Override
    public boolean update(LoginHistory entity) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(String code) throws SQLException {
        return false;
    }

    @Override
    public List<LoginHistory> getAll() throws SQLException {
                List<LoginHistory> data = new ArrayList<>();

        String sql = "SELECT * FROM LogHistory";
        ResultSet resultSet = CrudUtil.execute(sql);

        while (resultSet.next()) {
            data.add(new LoginHistory(
                    resultSet.getInt(1),
                    resultSet.getDate(2),
                    resultSet.getTime(3),
                    resultSet.getDate(4),
                    resultSet.getTime(5)
            ));
        }
        return data;
    }

    @Override
    public boolean saveLogOut(LoginHistory loginHistory) throws SQLException {
                {
            String sql = "INSERT INTO LogHistory(UserID, LogOutDate, LogOutTime) " +
                    "VALUES(?,?,?)";

            return CrudUtil.execute(
                    sql,
                    loginHistory.getUId(),loginHistory.getLogInDate(),loginHistory.getLogInDate());

        }
    }

    @Override
    public LoginHistory searchLastID() throws SQLException {

        String sql = "select *from LogHistory ORDER BY LogInTime DESC LIMIT 1";
        ResultSet rst = CrudUtil.execute(sql);


        if (rst.next()){
            return new LoginHistory(rst.getInt(1),rst.getDate(2),rst.getTime(3),rst.getDate(4),rst.getTime(5));
        }
        return null;
    }

}
