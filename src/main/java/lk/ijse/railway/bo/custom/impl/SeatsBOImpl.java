package lk.ijse.railway.bo.custom.impl;

import lk.ijse.railway.dao.custom.impl.BookingDAOImpl;
import lk.ijse.railway.db.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SeatsBOImpl {
    BookingDAOImpl bookingDAO = new BookingDAOImpl();

    public List<String> loadIds(String trainId, Date date) throws SQLException {
        return bookingDAO.loadIds(trainId, date);
    }
}
