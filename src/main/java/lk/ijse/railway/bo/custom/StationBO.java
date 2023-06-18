package lk.ijse.railway.bo.custom;

import lk.ijse.railway.bo.SuperBO;
import lk.ijse.railway.entity.Station;
import lk.ijse.railway.model.StationDTO;

import java.sql.SQLException;
import java.util.List;

public interface StationBO extends SuperBO {
    public boolean delete(String code) throws SQLException ;
    public boolean save(Station entity) throws SQLException ;
    public StationDTO search(String text) throws SQLException ;
    public boolean update(Station entity) throws SQLException ;
    public List<StationDTO> getAll() throws SQLException ;
}
