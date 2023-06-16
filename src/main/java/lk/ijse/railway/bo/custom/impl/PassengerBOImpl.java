package lk.ijse.railway.bo.custom.impl;

import lk.ijse.railway.bo.custom.PassengerBO;
import lk.ijse.railway.dao.DAOFactory;
import lk.ijse.railway.dao.custom.impl.PassengerDAOImpl;
import lk.ijse.railway.db.DBConnection;
import lk.ijse.railway.dto.Passenger;
import lk.ijse.railway.model.PassengerDTO;
import lk.ijse.railway.util.CrudUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PassengerBOImpl implements PassengerBO {
    PassengerDAOImpl passengerDAO = (PassengerDAOImpl) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.PASSENGER);
    @Override
    public PassengerDTO search(String text) throws SQLException {
        return new PassengerDTO(passengerDAO.search(text).getId());

    }
    @Override
    public boolean update(Passenger entity) throws SQLException {
        return passengerDAO.update(entity);

    }
}
