package lk.ijse.railway.bo.custom;

import lk.ijse.railway.bo.SuperBO;
import lk.ijse.railway.dto.LoginHistory;
import lk.ijse.railway.model.LoginHistoryDTO;

import java.sql.SQLException;

public interface HomeBO extends SuperBO {
    public boolean saveLogOut(LoginHistory loginHistory) throws SQLException ;
    public LoginHistoryDTO searchLastID() throws SQLException ;
}
