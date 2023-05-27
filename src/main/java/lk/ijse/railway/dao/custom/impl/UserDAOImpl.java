package lk.ijse.railway.dao.custom.impl;

import lk.ijse.railway.dao.custom.UserDAO;
import lk.ijse.railway.dto.User;
import lk.ijse.railway.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    @Override
    public User search(String text) throws SQLException {

        String sql = "SELECT * FROM User WHERE UserName = ?";
        ResultSet rst = CrudUtil.execute(sql, text);


        if (rst.next()){
            return new User(rst.getInt(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5), rst.getString(6));
        }
        return null;
    }

    @Override
    public boolean save(User entity) throws SQLException {
                String sql = "INSERT INTO User(UserID, UserName, PassWord,ContactNum,Address,Email) " +
                "VALUES(?,?,?,?,?,?)";

        return CrudUtil.execute(
                sql,
                entity.getUId(),
                entity.getName(),
                entity.getPswd(),
                entity.getNum(),
                entity.getAddress(),
                entity.getEmail());
    }

    @Override
    public boolean update(User entity) throws SQLException {
        String sql = "UPDATE User SET  UserName = ?, ContactNum =?, Address = ?,Email =?  WHERE UserID = ?";
        return CrudUtil.execute(
                sql,
                entity.getName(),
                entity.getNum(),
                entity.getAddress(),
                entity.getEmail(),
                entity.getUId());
                }

    @Override
    public boolean delete(String code) throws SQLException {
        return false;
    }


    @Override
    public List<User> getAll() throws SQLException {
        return null;
    }

    @Override
    public int search() throws SQLException {

        String sql = "SELECT MAX(UserID) FROM User";


        ResultSet resultSet = CrudUtil.execute(sql);
        int id = 0;


        while (resultSet.next()) {
            id = resultSet.getInt(1);
        }
        return id;
    }

    @Override
    public User searchAll(int uId) throws SQLException {
                String sql = "SELECT * FROM User WHERE UserID = ?";
        ResultSet rst = CrudUtil.execute(sql, uId);


        if (rst.next()){
            return new User(rst.getInt(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5), rst.getString(6));
        }
        return null;
    }

    @Override
    public boolean update1(User user) throws SQLException {
                String sql = "UPDATE User SET  PassWord = ?  WHERE UserID = ?";
        return CrudUtil.execute(
                sql,
                user.getPswd(),
                user.getUId());
    }

}
