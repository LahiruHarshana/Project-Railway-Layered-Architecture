package lk.ijse.railway.bo.custom;

import lk.ijse.railway.bo.SuperBO;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public interface SeatsBO extends SuperBO {
    public List<String> loadIds(String trainId, Date date) throws SQLException ;
}
