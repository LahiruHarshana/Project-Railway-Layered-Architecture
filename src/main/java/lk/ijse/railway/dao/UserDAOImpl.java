package lk.ijse.railway.dao;

import lk.ijse.railway.dto.User;
import lk.ijse.railway.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl {
    public static int search() throws SQLException {

        String sql = "SELECT MAX(UserID) FROM User";


        ResultSet resultSet = CrudUtil.execute(sql);
        int id = 0;


        while (resultSet.next()) {
            id = resultSet.getInt(1);
        }
        return id;
    }

    public static boolean save(User user) throws SQLException {

        String sql = "INSERT INTO User(UserID, UserName, PassWord,ContactNum,Address,Email) " +
                "VALUES(?,?,?,?,?,?)";

        return CrudUtil.execute(
                sql,
                user.getUId(),
                user.getName(),
                user.getPswd(),
                user.getNum(),
                user.getAddress(),
                user.getEmail());
    }

    public static User search1(String text) throws SQLException {

        String sql = "SELECT * FROM User WHERE UserName = ?";
        ResultSet rst = CrudUtil.execute(sql, text);


        if (rst.next()){
            return new User(rst.getInt(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5), rst.getString(6));
        }
        return null;
    }

    public static User searchAll(int uId) throws SQLException {

        String sql = "SELECT * FROM User WHERE UserID = ?";
        ResultSet rst = CrudUtil.execute(sql, uId);


        if (rst.next()){
            return new User(rst.getInt(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5), rst.getString(6));
        }
        return null;


    }

    public static boolean update(User user) throws SQLException {
        String sql = "UPDATE User SET  UserName = ?, ContactNum =?, Address = ?,Email =?  WHERE UserID = ?";
        return CrudUtil.execute(
                sql,
                user.getName(),
                user.getNum(),
                user.getAddress(),
                user.getEmail(),
                user.getUId());
    }

    public static boolean update1(User user) throws SQLException {
        String sql = "UPDATE User SET  PassWord = ?  WHERE UserID = ?";
        return CrudUtil.execute(
                sql,
                user.getPswd(),
                user.getUId());


    }
}
