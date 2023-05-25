package lk.ijse.railway.dao;


import lk.ijse.railway.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TicketAddDAOImpl {

    public static boolean save(String ticketID, String trainID,String stationName,String classType,int howMany,Double price) throws SQLException {
        Connection con = DBConnection.getInstance().getConnection();

        String sql = "INSERT INTO Ticket(TicketID,TrainID,StationName,ClassType,HowMany,price) VALUES(?,?,?,?,?,?)";

        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.setString(1, ticketID);
        pstm.setString(2, trainID);
        pstm.setString(3, stationName);
        pstm.setString(4, classType);
        pstm.setInt(5, howMany);
        pstm.setDouble(6, price);

        return pstm.executeUpdate() > 0;

    }
}
