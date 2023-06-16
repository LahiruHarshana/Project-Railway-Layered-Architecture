package lk.ijse.railway.bo.custom;

import lk.ijse.railway.bo.SuperBO;
import lk.ijse.railway.dto.LoginHistory;
import lk.ijse.railway.dto.User;
import lk.ijse.railway.model.LoginHistoryDTO;
import lk.ijse.railway.model.UserDTO;

import java.sql.SQLException;

public interface SettingBO extends SuperBO {
    public boolean update(User entity) throws SQLException ;
    public UserDTO searchAll(int uId) throws SQLException ;
    public boolean saveLogOut(LoginHistory loginHistory) throws SQLException ;

    public LoginHistoryDTO searchLastID() throws SQLException ;
}
