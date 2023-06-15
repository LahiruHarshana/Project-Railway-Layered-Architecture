package lk.ijse.railway.bo.custom.impl;

import lk.ijse.railway.dao.custom.impl.StationDAOImpl;
import lk.ijse.railway.db.DBConnection;
import lk.ijse.railway.dto.LoginHistory;
import lk.ijse.railway.dto.Station;
import lk.ijse.railway.model.LoginHistoryDTO;
import lk.ijse.railway.model.StationDTO;
import lk.ijse.railway.util.CrudUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StationBOImpl {

    StationDAOImpl stationDAO = new StationDAOImpl();
    public boolean delete(String code) throws SQLException {
        return stationDAO.delete(code);
    }
    public boolean save(Station entity) throws SQLException {
        return stationDAO.save(entity);
    }
    public StationDTO search(String text) throws SQLException {
        return new StationDTO(stationDAO.search(text));
    }
    public boolean update(Station entity) throws SQLException {
        return stationDAO.update(entity);
    }
    public List<StationDTO> getAll() throws SQLException {
        List<Station> allEntityData = stationDAO.getAll();
        ArrayList<StationDTO> allDTOData= new ArrayList<>();
        for (Station i : allEntityData) {
            allDTOData.add(new StationDTO(i.getId(),i.getName(),i.getDistance()));
        }
        return allDTOData;
    }

}
