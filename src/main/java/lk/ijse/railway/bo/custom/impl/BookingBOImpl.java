package lk.ijse.railway.bo.custom.impl;

import lk.ijse.railway.bo.custom.BookingBO;
import lk.ijse.railway.dao.DAOFactory;
import lk.ijse.railway.dao.custom.*;
import lk.ijse.railway.db.DBConnection;
import lk.ijse.railway.entity.Booking;
import lk.ijse.railway.entity.Passenger;
import lk.ijse.railway.entity.Payment;
import lk.ijse.railway.model.StationDTO;

import java.sql.*;
import java.util.List;



public class BookingBOImpl implements BookingBO {

    TrainDAO trainDAO = (TrainDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.TRAIN);
    BookingDAO bookingDAO = (BookingDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.BOOKING);
    StationDAO stationDAO = (StationDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.STATION);
    StationDetailsDAO stationDetailsDAO = (StationDetailsDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.SATATIONDETAILS);
    PaymentDAO paymentDAO = (PaymentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.PAYMENT);
    PassengerDAO passengerDAO = (PassengerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.PASSENGER);

    @Override
    public StationDTO searchByStationId(String name) throws SQLException {
         return new StationDTO(stationDAO.searchById(name).getDistance());
    }
    @Override
    public boolean paymentBooking(String bookingId, String date, Date toDate, String trainId, String stationName, String seatsId, String paymentId, double price, String passengerId, String passengerName, String contactNum, String email, String address, String nic) throws SQLException, SQLException {
        Connection con = null;
        try {
            con = DBConnection.getInstance().getConnection();
            con.setAutoCommit(false);

            boolean isBookingSaved =bookingDAO.save(new Booking(bookingId,date,toDate,trainId,stationName,seatsId,price));
            if(isBookingSaved) {
                boolean isPassengerSaved = passengerDAO.save(new Passenger(passengerId,passengerName,bookingId,contactNum,email,address,nic));

                if(isPassengerSaved) {
                    boolean isPaymentSaved = paymentDAO.saveB(new Payment(paymentId,bookingId,date,price));

                    if(isPaymentSaved){
                        con.commit();
                        return true;
                    }
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
    public List<String> searchByStationName(String idl) throws SQLException {
        return stationDetailsDAO.searchById(idl);
    }
    @Override
    public int searchPassengerId() throws SQLException {
        return passengerDAO.searchId();

    }
    @Override
    public List<String> loadtrainIds() throws SQLException {
        return trainDAO.loadtrainIds();
    }


}
