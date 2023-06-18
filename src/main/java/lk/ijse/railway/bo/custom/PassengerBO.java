package lk.ijse.railway.bo.custom;

import lk.ijse.railway.bo.SuperBO;
import lk.ijse.railway.entity.Passenger;
import lk.ijse.railway.model.PassengerDTO;

import java.sql.SQLException;

public interface PassengerBO extends SuperBO {
    public PassengerDTO search(String text) throws SQLException ;
    public boolean update(Passenger entity) throws SQLException ;
}
