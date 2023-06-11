package lk.ijse.railway.bo.custom.impl;

import lk.ijse.railway.dto.LoginHistory;
import lk.ijse.railway.dto.User;
import lk.ijse.railway.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ChangePasswordBOImpl {
    public boolean updatePassword(User user) throws SQLException {
        String sql = "UPDATE User SET  PassWord = ?  WHERE UserID = ?";
        return CrudUtil.execute(
                sql,
                user.getPswd(),
                user.getUId());
    }

    public User searchAll(int uId) throws SQLException {
        String sql = "SELECT * FROM User WHERE UserID = ?";
        ResultSet rst = CrudUtil.execute(sql, uId);


        if (rst.next()){
            return new User(rst.getInt(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5), rst.getString(6));
        }
        return null;
    }

    public LoginHistory searchLastID() throws SQLException {

        String sql = "select *from LogHistory ORDER BY LogInTime DESC LIMIT 1";
        ResultSet rst = CrudUtil.execute(sql);


        if (rst.next()){
            return new LoginHistory(rst.getInt(1),rst.getDate(2),rst.getTime(3),rst.getDate(4),rst.getTime(5));
        }
        return null;
    }

}
