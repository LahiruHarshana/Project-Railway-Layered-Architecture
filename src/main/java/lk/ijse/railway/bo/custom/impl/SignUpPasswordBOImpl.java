package lk.ijse.railway.bo.custom.impl;

import lk.ijse.railway.dao.custom.impl.UserDAOImpl;
import lk.ijse.railway.dto.User;
import lk.ijse.railway.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SignUpPasswordBOImpl {

    UserDAOImpl userDAO = new UserDAOImpl();

    public int search() throws SQLException {
        return userDAO.search();
    }
    public boolean save(User entity) throws SQLException {
        return userDAO.save(entity);
    }
}
