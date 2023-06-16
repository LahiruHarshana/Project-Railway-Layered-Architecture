package lk.ijse.railway.bo.custom;

import lk.ijse.railway.bo.SuperBO;
import lk.ijse.railway.dto.LoginHistory;
import lk.ijse.railway.model.LoginHistoryDTO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface LoginHistoryBO extends SuperBO {
    public List<LoginHistoryDTO> getAll() throws SQLException ;
}
