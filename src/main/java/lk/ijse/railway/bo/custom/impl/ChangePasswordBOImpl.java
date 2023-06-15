package lk.ijse.railway.bo.custom.impl;

import lk.ijse.railway.bo.custom.ChangePasswordBO;
import lk.ijse.railway.dao.custom.LoginHistoryDAO;
import lk.ijse.railway.dao.custom.UserDAO;
import lk.ijse.railway.dao.custom.impl.LoginHistoryDAOImpl;
import lk.ijse.railway.dao.custom.impl.UserDAOImpl;
import lk.ijse.railway.dto.User;
import lk.ijse.railway.model.LoginHistoryDTO;
import lk.ijse.railway.model.UserDTO;

import java.sql.SQLException;

public class ChangePasswordBOImpl {

    UserDAO userDAO = new UserDAOImpl();
    LoginHistoryDAO loginHistoryDAO = new LoginHistoryDAOImpl();

    public boolean updatePassword(User user) throws SQLException {
        return  userDAO.update1(user);
    }

    public LoginHistoryDTO searchLastID() throws SQLException {
        return new LoginHistoryDTO(loginHistoryDAO.searchLastID().getUId());

    }

    public UserDTO searchAll(int uId) throws SQLException {
        return new UserDTO(userDAO.searchAll(uId));
    }
}
