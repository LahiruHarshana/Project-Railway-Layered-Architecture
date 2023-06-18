package lk.ijse.railway.bo.custom.impl;

import lk.ijse.railway.bo.custom.LoginBO;
import lk.ijse.railway.dao.DAOFactory;
import lk.ijse.railway.dao.custom.LoginHistoryDAO;
import lk.ijse.railway.dao.custom.UserDAO;
import lk.ijse.railway.dao.custom.impl.UserDAOImpl;
import lk.ijse.railway.entity.LoginHistory;
import lk.ijse.railway.model.UserDTO;

import java.sql.SQLException;

public class LoginBOImpl implements LoginBO {
    UserDAO userDAO = new UserDAOImpl();

    LoginHistoryDAO loginHistoryDAO = (LoginHistoryDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.LOGINHISTORY);
    @Override
    public UserDTO search(String text) throws SQLException {
        return new UserDTO(userDAO.search(text));
    }
    @Override
    public boolean save(LoginHistory entity) throws SQLException {
        return loginHistoryDAO.save(entity);
    }
    @Override

    public UserDTO searchid(String text) throws SQLException {
        String s = null;
        String t = null;
        return new UserDTO(userDAO.search(text).getUId(),s,t);

    }
}
