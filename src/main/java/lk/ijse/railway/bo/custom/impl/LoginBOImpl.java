package lk.ijse.railway.bo.custom.impl;

import lk.ijse.railway.dao.custom.LoginHistoryDAO;
import lk.ijse.railway.dao.custom.UserDAO;
import lk.ijse.railway.dao.custom.impl.LoginHistoryDAOImpl;
import lk.ijse.railway.dao.custom.impl.UserDAOImpl;
import lk.ijse.railway.dto.LoginHistory;
import lk.ijse.railway.dto.User;
import lk.ijse.railway.model.UserDTO;
import lk.ijse.railway.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginBOImpl {
    UserDAO userDAO = new UserDAOImpl();

    LoginHistoryDAO loginHistoryDAO = new LoginHistoryDAOImpl();
    public UserDTO search(String text) throws SQLException {
        return new UserDTO(userDAO.search(text));
    }
    public boolean save(LoginHistory entity) throws SQLException {
        return loginHistoryDAO.save(entity);
    }

    public UserDTO searchid(String text) throws SQLException {
        String s = null;
        String t = null;
        return new UserDTO(userDAO.search(text).getUId(),s,t);

    }
}
