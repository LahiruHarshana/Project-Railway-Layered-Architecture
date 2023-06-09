package lk.ijse.railway.bo.custom.impl;

import lk.ijse.railway.bo.custom.LoginHistoryBO;
import lk.ijse.railway.dao.DAOFactory;
import lk.ijse.railway.dao.custom.LoginHistoryDAO;
import lk.ijse.railway.entity.LoginHistory;
import lk.ijse.railway.model.LoginHistoryDTO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoginHistoryBOImpl implements LoginHistoryBO {
    LoginHistoryDAO loginHistoryDAO = (LoginHistoryDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.LOGINHISTORY);
    @Override
    public List<LoginHistoryDTO> getAll() throws SQLException {
        List<LoginHistory> allEntityData = loginHistoryDAO.getAll();
        ArrayList<LoginHistoryDTO> allDTOData= new ArrayList<>();
        for (LoginHistory i : allEntityData) {
            allDTOData.add(new LoginHistoryDTO(i.getUId(),i.getLogInDate(),i.getLogInTime(),i.getLogOutDate(),i.getLogOutTime()));
        }
        return allDTOData;
    }
}
