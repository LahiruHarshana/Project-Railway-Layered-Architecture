package lk.ijse.railway.bo.custom.impl;

import lk.ijse.railway.dao.custom.impl.PassengerDAOImpl;
import lk.ijse.railway.db.DBConnection;
import lk.ijse.railway.dto.Passenger;
import lk.ijse.railway.model.PassengerDTO;
import lk.ijse.railway.util.CrudUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PassengerBOImpl {
    PassengerDAOImpl passengerDAO = new PassengerDAOImpl();
    public PassengerDTO search(String text) throws SQLException {
        return new PassengerDTO(passengerDAO.search(text).getId());

    }
    public boolean update(Passenger entity) throws SQLException {
        return passengerDAO.update(entity);

    }
}
