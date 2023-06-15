package lk.ijse.railway.bo.custom;

import lk.ijse.railway.dto.User;
import lk.ijse.railway.model.LoginHistoryDTO;
import lk.ijse.railway.model.UserDTO;

import java.sql.SQLException;

public interface ChangePasswordBO {
    boolean updatePassword(User user) throws SQLException;

    LoginHistoryDTO searchLastID();

    UserDTO searchAll(int uId);
}
