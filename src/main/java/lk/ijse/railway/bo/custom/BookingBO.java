package lk.ijse.railway.bo.custom;

import lk.ijse.railway.bo.SuperBO;
import lk.ijse.railway.model.StationDTO;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public interface BookingBO extends SuperBO {
    public StationDTO searchByStationId(String name) throws SQLException ;
    public boolean paymentBooking(String bookingId, String date, Date toDate, String trainId, String stationName, String seatsId, String paymentId, double price, String passengerId, String passengerName, String contactNum, String email, String address, String nic) throws SQLException, SQLException ;
    public List<String> searchByStationName(String idl) throws SQLException ;
    public int searchPassengerId() throws SQLException ;
    public List<String> loadtrainIds() throws SQLException ;
}
