package lk.ijse.railway.bo.custom;

import lk.ijse.railway.bo.SuperBO;
import lk.ijse.railway.dto.StationDetails;
import lk.ijse.railway.dto.Train;
import lk.ijse.railway.model.TrainDTO;

import java.sql.SQLException;
import java.util.List;

public interface TrainBO extends SuperBO {
    public List<String> loadtrainIds() throws SQLException ;
    public boolean save(Train entity) throws SQLException ;
    public boolean delete(String code) throws SQLException ;
    public TrainDTO search(String text) throws SQLException ;
    public boolean update(Train entity) throws SQLException ;
    public List<String> loadIds() throws SQLException ;

    public boolean save(StationDetails entity) throws SQLException ;
}
