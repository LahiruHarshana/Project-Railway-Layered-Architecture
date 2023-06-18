package lk.ijse.railway.bo.custom.impl;

import lk.ijse.railway.bo.custom.StationBO;
import lk.ijse.railway.dao.DAOFactory;
import lk.ijse.railway.dao.custom.impl.StationDAOImpl;
import lk.ijse.railway.entity.Station;
import lk.ijse.railway.model.StationDTO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StationBOImpl implements StationBO {

    StationDAOImpl stationDAO = (StationDAOImpl) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.STATION);
    @Override
    public boolean delete(String code) throws SQLException {
        return stationDAO.delete(code);
    }
    @Override
    public boolean save(Station entity) throws SQLException {
        return stationDAO.save(entity);
    }
    @Override
    public StationDTO search(String text) throws SQLException {
        return new StationDTO(stationDAO.search(text));
    }
    @Override
    public boolean update(Station entity) throws SQLException {
        return stationDAO.update(entity);
    }
    @Override
    public List<StationDTO> getAll() throws SQLException {
        List<Station> allEntityData = stationDAO.getAll();
        ArrayList<StationDTO> allDTOData= new ArrayList<>();
        for (Station i : allEntityData) {
            allDTOData.add(new StationDTO(i.getId(),i.getName(),i.getDistance()));
        }
        return allDTOData;
    }

}
