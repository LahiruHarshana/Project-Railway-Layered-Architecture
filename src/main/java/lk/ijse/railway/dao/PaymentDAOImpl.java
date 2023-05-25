package lk.ijse.railway.dao;

import lk.ijse.railway.db.DBConnection;
import lk.ijse.railway.util.CrudUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class PaymentDAOImpl {
    public static boolean payemntTicket(String ticketID, String trainID, String paymentID, String date, double price,String classType,String stationName,int howMany) throws SQLException {
        Connection con = null;
        try {
            con = DBConnection.getInstance().getConnection();
            con.setAutoCommit(false);

            boolean isTicketSaved = TicketAddDAOImpl.save(ticketID, trainID,stationName,classType,howMany,price);
            if(isTicketSaved) {
                boolean isPaymentSaved = PaymentDAOImpl.save(paymentID,ticketID,date,price);
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

    static boolean save(String paymentID, String ticketID, String date, double price) throws SQLException {


        String sql = "INSERT INTO Payment(PaymentID,TicketID,Date,price) VALUES(?,?,?,?)";
        return CrudUtil.execute(
                sql,

        paymentID,
        ticketID,
        date,
        price);


    }

    static boolean saveB(String paymentID, String ticketID, String date, double price) throws SQLException {


        String sql = "INSERT INTO Payment(PaymentID,BookingID,Date,price) VALUES(?,?,?,?)";

        return CrudUtil.execute(
                sql,
        paymentID,
        ticketID,
        date,
        price);


    }


}
