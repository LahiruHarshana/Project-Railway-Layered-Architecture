package lk.ijse.railway.dao.custom.impl;

import lk.ijse.railway.dao.custom.StationDetailsDAO;
import lk.ijse.railway.dto.StationDetails;
import lk.ijse.railway.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StationDetailsDAOImpl implements StationDetailsDAO {
    @Override
    public StationDetails search(String text) throws SQLException {
        return null;
    }

    @Override
    public boolean save(StationDetails entity) throws SQLException {
        String sql = "INSERT INTO StationDetails(TrainID, StationName, Time) " +
                "VALUES(?, ?, ?)";
        return CrudUtil.execute(
                sql,
                entity.getTrainId(),
                entity.getStationId(),
                entity.getTime());
    }

    @Override
    public boolean update(StationDetails entity) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(String code) throws SQLException {
        return false;
    }

    @Override
    public List<StationDetails> getAll() throws SQLException {
        return null;
    }


    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public List<String> searchById(String idl) throws SQLException {

        String sql = "SELECT StationName FROM StationDetails WHERE TrainID = ?";
        ResultSet resultSet = CrudUtil.execute(sql, idl);
        List<String> data = new ArrayList<>();
        while (resultSet.next()) {
            data.add(resultSet.getString(1));
        }
        return data;
    }
}
