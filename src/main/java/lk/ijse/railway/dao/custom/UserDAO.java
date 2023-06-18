package lk.ijse.railway.dao.custom;

import lk.ijse.railway.dao.CrudDAO;
import lk.ijse.railway.entity.User;

import java.sql.SQLException;

public interface UserDAO extends CrudDAO<User,String> {
      public int search() throws SQLException;
      public User searchAll(int uId) throws SQLException;
      public boolean update1(User user) throws SQLException;
}
