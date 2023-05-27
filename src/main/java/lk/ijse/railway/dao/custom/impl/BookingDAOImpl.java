package lk.ijse.railway.dao.custom.impl;


import lk.ijse.railway.dao.custom.BookingDAO;
import lk.ijse.railway.db.DBConnection;
import lk.ijse.railway.dto.Booking;
import lk.ijse.railway.dto.Passenger;
import lk.ijse.railway.dto.Payment;
import lk.ijse.railway.util.CrudUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookingDAOImpl implements BookingDAO {

    BookingDAO bookingDAO = new BookingDAOImpl();

    @Override
    public Booking search(String text) throws SQLException {
        return null;
    }

    @Override
    public  boolean save(Booking entity) throws SQLException {
        String sql = "INSERT INTO Booking(BookingID,Date,ToDate,TrainID,StationName,SeatsID,price) VALUES(?,?,?,?,?,?,?)";


        return CrudUtil.execute(
                sql,
                entity.getBId(),
                entity.getCDate(),
                entity.getTDate(),
                entity.getTid(),
                entity.getSName(),
                entity.getSeatId(),
                entity.getPrice());
    }

    @Override
    public boolean update(Booking entity) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(String code) throws SQLException {
        return false;
    }

    @Override
    public List<Booking> getAll() throws SQLException {
        return null;
    }

    @Override
    public List<String> loadIds(String trainId, Date date) throws SQLException {
                Connection con = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = con.prepareStatement("SELECT SeatsID FROM Booking WHERE TrainID = ? AND ToDate =?");
        pstm.setString(1, trainId);
        pstm.setDate(2, date);

        ResultSet resultSet = pstm.executeQuery();

        List<String> data = new ArrayList<>();

        while (resultSet.next()) {
            data.add(resultSet.getString(1));
        }
        return data;
    }

    @Override
    public int search3class(String idl) throws SQLException {
        Connection con = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = con.prepareStatement("SELECT COUNT(BookingID) FROM Booking WHERE TrainID = ?");
        pstm.setString(1, idl);

        ResultSet resultSet = pstm.executeQuery();
        if (resultSet.next()) {
            return resultSet.getInt(1);
        }
        return 0;
    }

    @Override
    public boolean paymentBooking(String bookingId, String date, Date toDate, String trainId, String stationName, String seatsId, String paymentId, double price, String passengerId, String passengerName, String contactNum, String email, String address, String nic) throws SQLException, SQLException {
                Connection con = null;
        try {
            con = DBConnection.getInstance().getConnection();
            con.setAutoCommit(false);

            boolean isBookingSaved = bookingDAO.save(new Booking(bookingId,date,toDate,trainId,stationName,seatsId,price));
            if(isBookingSaved) {
                boolean isPassengerSaved = PassengerDAOImpl.save(new Passenger(passengerId,passengerName,bookingId,contactNum,email,address,nic));

                if(isPassengerSaved) {
                    boolean isPaymentSaved = PaymentDAOImpl.saveB(new Payment(paymentId,bookingId,date,price));

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


}
