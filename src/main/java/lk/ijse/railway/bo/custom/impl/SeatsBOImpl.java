package lk.ijse.railway.bo.custom.impl;

import lk.ijse.railway.bo.custom.SeatsBO;
import lk.ijse.railway.dao.DAOFactory;
import lk.ijse.railway.dao.custom.impl.BookingDAOImpl;
import lk.ijse.railway.db.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SeatsBOImpl implements SeatsBO {
    BookingDAOImpl bookingDAO = (BookingDAOImpl) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.BOOKING);
    @Override

    public List<String> loadIds(String trainId, Date date) throws SQLException {
        return bookingDAO.loadIds(trainId, date);
    }
}
