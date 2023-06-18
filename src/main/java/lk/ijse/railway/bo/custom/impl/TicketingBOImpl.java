package lk.ijse.railway.bo.custom.impl;

import lk.ijse.railway.bo.custom.TicketingBO;
import lk.ijse.railway.dao.DAOFactory;
import lk.ijse.railway.dao.custom.impl.*;
import lk.ijse.railway.db.DBConnection;
import lk.ijse.railway.entity.Payment;
import lk.ijse.railway.entity.Ticket;
import lk.ijse.railway.model.StationDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TicketingBOImpl implements TicketingBO {

    TrainDAOImpl trainDAO = (TrainDAOImpl) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.TRAIN);

    TicketDAOImpl ticketDAO = (TicketDAOImpl) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.TICKET);
    PaymentDAOImpl paymentDAO  = (PaymentDAOImpl) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.PAYMENT);

    StationDetailsDAOImpl stationDetailsDAO = (StationDetailsDAOImpl) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.SATATIONDETAILS);

    StationDAOImpl stationDAO = (StationDAOImpl) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.STATION);
    @Override

    public List<String> loadtrainIds() throws SQLException {
        return trainDAO.loadtrainIds();
    }
    @Override
    public int search() throws SQLException {
        return ticketDAO.search();
    }
    @Override
    public boolean payemntTicket(String ticketID, String trainID, String paymentID, String date, double price, String classType, String stationName, int howMany) throws SQLException {
        Connection con = null;
        try {
            con = DBConnection.getInstance().getConnection();
            con.setAutoCommit(false);

            boolean isTicketSaved = ticketDAO.save(new Ticket(ticketID, trainID,stationName,classType,howMany,price));
            if(isTicketSaved) {
                boolean isPaymentSaved =paymentDAO.save(new Payment(paymentID,ticketID,date,price));
                System.out.println(isPaymentSaved);
                if(isPaymentSaved) {
                    con.commit();
                    return true;

                }
            }
            return false;
        } catch (SQLException er) {
            con.rollback();
            return false;
        } finally {
            System.out.println("finally");
            con.setAutoCommit(true);
        }
    }
    @Override
    public List<String> searchById(String idl) throws SQLException {
        return stationDetailsDAO.searchById(idl);
    }
    @Override
    public StationDTO searchByStationId(String name) throws SQLException {
        return new StationDTO(stationDAO.searchById(name));
    }
}
