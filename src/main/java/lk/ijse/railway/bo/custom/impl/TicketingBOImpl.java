package lk.ijse.railway.bo.custom.impl;

import lk.ijse.railway.dao.custom.impl.*;
import lk.ijse.railway.db.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TicketingBOImpl {

    TrainDAOImpl trainDAO = new TrainDAOImpl();

    TicketDAOImpl ticketDAO = new TicketDAOImpl();
    PaymentDAOImpl paymentDAO  = new PaymentDAOImpl();

    StationDetailsDAOImpl stationDetailsDAO = new StationDetailsDAOImpl();

    StationDAOImpl stationDAO = new StationDAOImpl();
    public List<String> loadtrainIds() throws SQLException {
        return trainDAO.loadtrainIds();
    }
    public int search() throws SQLException {
        return ticketDAO.search();
    }
}
