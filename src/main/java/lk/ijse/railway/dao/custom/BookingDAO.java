package lk.ijse.railway.dao.custom;

import lk.ijse.railway.dao.CrudDAO;
import lk.ijse.railway.db.DBConnection;
import lk.ijse.railway.dto.Booking;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public interface BookingDAO extends CrudDAO<Booking,String> {
    public  List<String> loadIds(String trainId, Date date) throws SQLException ;



    public  int search3class(String idl) throws SQLException ;
        public  boolean paymentBooking(String bookingId, String date, Date toDate, String trainId, String stationName, String seatsId, String paymentId, double price, String passengerId, String passengerName, String contactNum, String email, String address, String nic) throws SQLException, SQLException ;
}
