package lk.ijse.railway.bo.custom.impl;

import lk.ijse.railway.dao.custom.BookingDAO;
import lk.ijse.railway.dao.custom.impl.BookingDAOImpl;
import lk.ijse.railway.dao.custom.impl.TicketDAOImpl;
import lk.ijse.railway.dao.custom.impl.TrainDAOImpl;
import lk.ijse.railway.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TicketBOImpl {
    TicketDAOImpl ticketDAO = new TicketDAOImpl();
    BookingDAO bookingDAO = new BookingDAOImpl();
    TrainDAOImpl trainDAO = new TrainDAOImpl();
    public int search1class(String idl) throws SQLException {
        return ticketDAO.search1class(idl);
    }
    public int search2class(String idl) throws SQLException {
        return ticketDAO.search2class(idl);
    }
    public int search3class(String idl) throws SQLException {
        return bookingDAO.search3class(idl);
    }
    public List<String> loadtrainIds() throws SQLException {
        return trainDAO.loadtrainIds();
    }
}
