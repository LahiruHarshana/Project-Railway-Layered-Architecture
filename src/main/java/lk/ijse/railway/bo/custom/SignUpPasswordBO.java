package lk.ijse.railway.bo.custom;

import lk.ijse.railway.bo.SuperBO;
import lk.ijse.railway.entity.User;

import java.sql.SQLException;

public interface SignUpPasswordBO extends SuperBO {
    public int search() throws SQLException ;
    public boolean save(User entity) throws SQLException ;
}
