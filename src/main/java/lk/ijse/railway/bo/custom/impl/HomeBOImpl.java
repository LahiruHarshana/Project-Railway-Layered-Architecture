package lk.ijse.railway.bo.custom.impl;

import lk.ijse.railway.bo.custom.HomeBO;
import lk.ijse.railway.dao.DAOFactory;
import lk.ijse.railway.dao.custom.LoginHistoryDAO;
import lk.ijse.railway.dao.custom.impl.LoginHistoryDAOImpl;
import lk.ijse.railway.dto.LoginHistory;
import lk.ijse.railway.model.LoginHistoryDTO;
import lk.ijse.railway.util.CrudUtil;

import java.sql.SQLException;

public class HomeBOImpl implements HomeBO {
    LoginHistoryDAO loginHistoryDAO = (LoginHistoryDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.LOGINHISTORY);
    @Override

    public boolean saveLogOut(LoginHistory loginHistory) throws SQLException{
        return loginHistoryDAO.saveLogOut(loginHistory);
    }
    @Override
    public LoginHistoryDTO searchLastID() throws SQLException {
        return new LoginHistoryDTO(loginHistoryDAO.searchLastID().getUId());
    }

}
