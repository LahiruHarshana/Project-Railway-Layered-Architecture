package lk.ijse.railway.bo.custom.impl;

import lk.ijse.railway.bo.custom.TicketBO;
import lk.ijse.railway.dao.DAOFactory;
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

public class TicketBOImpl implements TicketBO {
    TicketDAOImpl ticketDAO = (TicketDAOImpl) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.TICKET);
    BookingDAO bookingDAO = (BookingDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.BOOKING);
    TrainDAOImpl trainDAO = (TrainDAOImpl) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.TRAIN);
    @Override
    public int search1class(String idl) throws SQLException {
        return ticketDAO.search1class(idl);
    }
    @Override
    public int search2class(String idl) throws SQLException {
        return ticketDAO.search2class(idl);
    }
    @Override
    public int search3class(String idl) throws SQLException {
        return bookingDAO.search3class(idl);
    }
    @Override
    public List<String> loadtrainIds() throws SQLException {
        return trainDAO.loadtrainIds();
    }
}
