package lk.ijse.railway.bo.custom.impl;

import lk.ijse.railway.bo.custom.SettingBO;
import lk.ijse.railway.dao.DAOFactory;
import lk.ijse.railway.dao.custom.impl.LoginHistoryDAOImpl;
import lk.ijse.railway.dao.custom.impl.UserDAOImpl;
import lk.ijse.railway.dto.LoginHistory;
import lk.ijse.railway.dto.User;
import lk.ijse.railway.model.LoginHistoryDTO;
import lk.ijse.railway.model.UserDTO;
import lk.ijse.railway.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SettingBOImpl implements SettingBO {
    UserDAOImpl userDAO = (UserDAOImpl) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.USER);
    LoginHistoryDAOImpl loginHistoryDAO = (LoginHistoryDAOImpl) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.LOGINHISTORY);
    @Override
    public boolean update(User entity) throws SQLException {
        return userDAO.update(entity);

    }
    @Override
    public UserDTO searchAll(int uId) throws SQLException {
        String s = null;
        return new UserDTO(userDAO.searchAll(uId),s);

    }
    @Override
    public boolean saveLogOut(LoginHistory loginHistory) throws SQLException {
    return loginHistoryDAO.saveLogOut(loginHistory);
    }
    @Override

    public LoginHistoryDTO searchLastID() throws SQLException {
        return new LoginHistoryDTO(loginHistoryDAO.searchLastID());

    }
}
