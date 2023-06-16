package lk.ijse.railway.bo.custom;

import lk.ijse.railway.bo.SuperBO;
import lk.ijse.railway.dto.LoginHistory;
import lk.ijse.railway.model.UserDTO;

import java.sql.SQLException;

public interface LoginBO extends SuperBO {
    public UserDTO search(String text) throws SQLException ;
    public boolean save(LoginHistory entity) throws SQLException ;

    public UserDTO searchid(String text) throws SQLException ;
}
