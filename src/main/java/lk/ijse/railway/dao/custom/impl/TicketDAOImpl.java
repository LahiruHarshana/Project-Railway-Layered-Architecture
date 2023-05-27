package lk.ijse.railway.dao.custom.impl;

import lk.ijse.railway.db.DBConnection;
import lk.ijse.railway.dto.Ticket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TicketDAOImpl {

    public static int search() throws SQLException {
        Connection con = DBConnection.getInstance().getConnection();
        ResultSet resultSet = con.createStatement().executeQuery("SELECT MAX(TicketID) FROM Ticket");
        int id = 0;


        while (resultSet.next()) {
            id = resultSet.getInt(1);
        }
        return id;

    }


    public static int search1class(String idl) throws SQLException {
        Connection con = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = con.prepareStatement("SELECT SUM(HowMany) FROM Ticket WHERE ClassType =? AND TrainID = ?");
        pstm.setString(1, "3rdClass");
        pstm.setString(2, idl);

        ResultSet resultSet = pstm.executeQuery();
        if (resultSet.next()) {
            return resultSet.getInt(1);
        }
        return 0;
    }

    public static int search2class(String idl) throws SQLException {
        Connection con = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = con.prepareStatement("SELECT SUM(HowMany) FROM Ticket WHERE TrainID = ? AND ClassType =?");
        pstm.setString(1, idl);
        pstm.setString(2, "2ndClass");

        ResultSet resultSet = pstm.executeQuery();
        if (resultSet.next()) {
            return resultSet.getInt(1);
        }
        return 0;
    }

    public static boolean save(Ticket ticket) throws SQLException {
        Connection con = DBConnection.getInstance().getConnection();

        String sql = "INSERT INTO Ticket(TicketID,TrainID,StationName,ClassType,HowMany,price) VALUES(?,?,?,?,?,?)";

        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.setString(1, ticket.getTId());
        pstm.setString(2, ticket.getTrainId());
        pstm.setString(3, ticket.getSName());
        pstm.setString(4, ticket.getCType());
        pstm.setInt(5, ticket.getHowMany());
        pstm.setDouble(6, ticket.getPrice());

        return pstm.executeUpdate() > 0;

    }
}
