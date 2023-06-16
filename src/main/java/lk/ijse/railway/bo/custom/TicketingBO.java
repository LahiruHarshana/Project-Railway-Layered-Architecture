package lk.ijse.railway.bo.custom;

import lk.ijse.railway.bo.SuperBO;
import lk.ijse.railway.db.DBConnection;
import lk.ijse.railway.dto.Payment;
import lk.ijse.railway.dto.Ticket;
import lk.ijse.railway.model.StationDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface TicketingBO extends SuperBO {

    public List<String> loadtrainIds() throws SQLException ;
    public int search() throws SQLException ;
    public boolean payemntTicket(String ticketID, String trainID, String paymentID, String date, double price, String classType, String stationName, int howMany) throws SQLException ;
    public List<String> searchById(String idl) throws SQLException ;
    public StationDTO searchByStationId(String name) throws SQLException ;
}
