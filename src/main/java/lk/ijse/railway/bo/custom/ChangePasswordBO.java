package lk.ijse.railway.bo.custom;

import lk.ijse.railway.bo.SuperBO;
import lk.ijse.railway.entity.User;
import lk.ijse.railway.model.LoginHistoryDTO;
import lk.ijse.railway.model.UserDTO;

import java.sql.SQLException;

public interface ChangePasswordBO extends SuperBO {
    public boolean updatePassword(User user) throws SQLException ;

    public LoginHistoryDTO searchLastID() throws SQLException ;

    public UserDTO searchAll(int uId) throws SQLException ;
}
