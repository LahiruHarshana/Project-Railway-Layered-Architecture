package lk.ijse.railway.dao.custom;

import lk.ijse.railway.dao.CrudDAO;
import lk.ijse.railway.dto.Train;

import java.sql.SQLException;
import java.sql.Time;
import java.util.List;

public interface TrainDAO extends CrudDAO<Train,String> {
    public List<String> loadtrainIds() throws SQLException;
    public Train searchTime(Time formattedTime) throws SQLException;

    }
