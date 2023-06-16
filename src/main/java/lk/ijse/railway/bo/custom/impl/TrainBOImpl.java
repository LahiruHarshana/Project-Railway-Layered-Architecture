package lk.ijse.railway.bo.custom.impl;

import lk.ijse.railway.bo.custom.TrainBO;
import lk.ijse.railway.dao.DAOFactory;
import lk.ijse.railway.dao.custom.impl.StationDAOImpl;
import lk.ijse.railway.dao.custom.impl.StationDetailsDAOImpl;
import lk.ijse.railway.dao.custom.impl.TrainDAOImpl;
import lk.ijse.railway.db.DBConnection;
import lk.ijse.railway.dto.StationDetails;
import lk.ijse.railway.dto.Train;
import lk.ijse.railway.model.TrainDTO;
import lk.ijse.railway.util.CrudUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TrainBOImpl implements TrainBO {
    TrainDAOImpl trainDAO = (TrainDAOImpl) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.TRAIN);
    StationDAOImpl stationDAO = (StationDAOImpl) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.STATION);

    StationDetailsDAOImpl stationDetailsDAO = new StationDetailsDAOImpl();
    @Override
    public List<String> loadtrainIds() throws SQLException {
        return trainDAO.loadtrainIds();
    }
    @Override
    public boolean save(Train entity) throws SQLException {
        return trainDAO.save(entity);
    }
    @Override
    public boolean delete(String code) throws SQLException {
        return trainDAO.delete(code);
    }
    @Override
    public TrainDTO search(String text) throws SQLException {
        return new TrainDTO(trainDAO.search(text));
    }
    @Override
    public boolean update(Train entity) throws SQLException {
        return trainDAO.update(entity);
    }
    @Override
    public List<String> loadIds() throws SQLException {
        return stationDAO.loadIds();
    }
    @Override
    public boolean save(StationDetails entity) throws SQLException {
        return stationDetailsDAO.save(entity);
    }


}
