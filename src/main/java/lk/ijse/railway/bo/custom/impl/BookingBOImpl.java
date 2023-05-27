package lk.ijse.railway.bo.custom.impl;

import lk.ijse.railway.dao.custom.*;
import lk.ijse.railway.dao.custom.impl.*;
import lk.ijse.railway.db.DBConnection;
import lk.ijse.railway.dto.Booking;
import lk.ijse.railway.dto.Passenger;
import lk.ijse.railway.dto.Payment;
import lk.ijse.railway.dto.Station;
import lk.ijse.railway.model.StationDTO;
import lk.ijse.railway.util.CrudUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class BookingBOImpl {

    TrainDAO trainDAO = new TrainDAOImpl();
    BookingDAO bookingDAO = new BookingDAOImpl();
    StationDAO stationDAO = new StationDAOImpl();
    StationDetailsDAO stationDetailsDAO = new StationDetailsDAOImpl();
    PaymentDAO paymentDAO = new PaymentDAOImpl();
    PassengerDAO passengerDAO = new PassengerDAOImpl();
    public StationDTO searchByStationId(String name) throws SQLException {
         return new StationDTO(stationDAO.searchById(name).getDistance());
    }
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
    public List<String> searchByStationName(String idl) throws SQLException {
        return stationDetailsDAO.searchById(idl);
    }
    public int searchPassengerId() throws SQLException {
        return passengerDAO.searchId();

    }
    public List<String> loadtrainIds() throws SQLException {
        return trainDAO.loadtrainIds();
    }


}
