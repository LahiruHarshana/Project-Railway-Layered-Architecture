package lk.ijse.railway.dao.custom.impl;

import lk.ijse.railway.dao.custom.PaymentDAO;
import lk.ijse.railway.dao.custom.TicketDAO;
import lk.ijse.railway.db.DBConnection;
import lk.ijse.railway.dto.Payment;
import lk.ijse.railway.dto.Ticket;
import lk.ijse.railway.util.CrudUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class PaymentDAOImpl implements PaymentDAO {
    TicketDAO ticketDAO =new TicketDAOImpl();
    @Override
    public Payment search(String text) throws SQLException {
        return null;
    }

    @Override
    public boolean save(Payment entity) throws SQLException {

        String sql = "INSERT INTO Payment(PaymentID,TicketID,Date,price) VALUES(?,?,?,?)";
        return CrudUtil.execute(
                sql,

        entity.getPId(),
        entity.getTId(),
        entity.getDate(),
        entity.getPrice());
    }

    @Override
    public boolean update(Payment entity) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(String code) throws SQLException {
        return false;
    }

    @Override
    public List<Payment> getAll() throws SQLException {
        return null;
    }

    @Override
    public boolean saveB(Payment payment) throws SQLException {
                String sql = "INSERT INTO Payment(PaymentID,BookingID,Date,price) VALUES(?,?,?,?)";

        return CrudUtil.execute(
                sql,
        payment.getPId(),
        payment.getTId(),
        payment.getDate(),
        payment.getPrice());
    }

    @Override
    public boolean payemntTicket(String ticketID, String trainID, String paymentID, String date, double price, String classType, String stationName, int howMany) throws SQLException {
                Connection con = null;
        try {
            con = DBConnection.getInstance().getConnection();
            con.setAutoCommit(false);

            boolean isTicketSaved = ticketDAO.save(new Ticket(ticketID, trainID,stationName,classType,howMany,price));
            if(isTicketSaved) {
                boolean isPaymentSaved =save(new Payment(paymentID,ticketID,date,price));
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

}
