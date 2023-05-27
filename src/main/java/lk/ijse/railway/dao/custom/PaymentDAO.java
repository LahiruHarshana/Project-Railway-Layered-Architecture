package lk.ijse.railway.dao.custom;

import lk.ijse.railway.dao.CrudDAO;
import lk.ijse.railway.dto.Payment;

import java.sql.SQLException;

public interface PaymentDAO extends CrudDAO<Payment,String> {

     boolean saveB(Payment payment) throws SQLException ;
    public boolean payemntTicket(String ticketID, String trainID, String paymentID, String date, double price,String classType,String stationName,int howMany) throws SQLException;

}
