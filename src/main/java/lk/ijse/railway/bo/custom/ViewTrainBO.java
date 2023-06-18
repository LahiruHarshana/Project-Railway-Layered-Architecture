package lk.ijse.railway.bo.custom;

import lk.ijse.railway.bo.SuperBO;
import lk.ijse.railway.model.TrainDTO;

import java.sql.SQLException;
import java.util.List;

public interface ViewTrainBO extends SuperBO {
    public List<TrainDTO> getAll() throws SQLException;
}
