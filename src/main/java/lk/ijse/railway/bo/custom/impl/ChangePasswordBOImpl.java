package lk.ijse.railway.bo.custom.impl;

import lk.ijse.railway.bo.custom.ChangePasswordBO;
import lk.ijse.railway.dao.DAOFactory;
import lk.ijse.railway.dao.custom.LoginHistoryDAO;
import lk.ijse.railway.dao.custom.UserDAO;
import lk.ijse.railway.entity.User;
import lk.ijse.railway.model.LoginHistoryDTO;
import lk.ijse.railway.model.UserDTO;

import java.sql.SQLException;

public class ChangePasswordBOImpl implements ChangePasswordBO{

    UserDAO userDAO = (UserDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.USER);
    LoginHistoryDAO loginHistoryDAO = (LoginHistoryDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.LOGINHISTORY);
    @Override
    public boolean updatePassword(User user) throws SQLException {
        return  userDAO.update1(user);
    }
    @Override
    public LoginHistoryDTO searchLastID() throws SQLException {
        return new LoginHistoryDTO(loginHistoryDAO.searchLastID().getUId());

    }

    @Override
    public UserDTO searchAll(int uId) throws SQLException {
        return new UserDTO(userDAO.searchAll(uId));
    }
}
