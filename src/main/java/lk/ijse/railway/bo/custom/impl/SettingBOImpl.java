package lk.ijse.railway.bo.custom.impl;

import lk.ijse.railway.dao.custom.impl.LoginHistoryDAOImpl;
import lk.ijse.railway.dao.custom.impl.UserDAOImpl;
import lk.ijse.railway.dto.User;
import lk.ijse.railway.model.UserDTO;
import lk.ijse.railway.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SettingBOImpl {
    UserDAOImpl userDAO = new UserDAOImpl();
    LoginHistoryDAOImpl loginHistoryDAO = new LoginHistoryDAOImpl();
    public boolean update(User entity) throws SQLException {
        return userDAO.update(entity);

    }
    public UserDTO searchAll(int uId) throws SQLException {
        String s = null;
        return new UserDTO(userDAO.searchAll(uId),s);

    }
}
