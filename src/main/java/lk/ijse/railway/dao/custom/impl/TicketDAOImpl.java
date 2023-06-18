package lk.ijse.railway.dao.custom.impl;

import lk.ijse.railway.dao.custom.TicketDAO;
import lk.ijse.railway.db.DBConnection;
import lk.ijse.railway.entity.Ticket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TicketDAOImpl implements TicketDAO {
    @Override
    public Ticket search(String text) throws SQLException {
        return null;
    }

    @Override
    public boolean save(Ticket entity) throws SQLException {
                Connection con = DBConnection.getInstance().getConnection();

        String sql = "INSERT INTO Ticket(TicketID,TrainID,StationName,ClassType,HowMany,price) VALUES(?,?,?,?,?,?)";

        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.setString(1, entity.getTId());
        pstm.setString(2, entity.getTrainId());
        pstm.setString(3, entity.getSName());
        pstm.setString(4, entity.getCType());
        pstm.setInt(5, entity.getHowMany());
        pstm.setDouble(6, entity.getPrice());

        return pstm.executeUpdate() > 0;
    }

    @Override
    public boolean update(Ticket entity) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(String code) throws SQLException {
        return false;
    }

    @Override
    public List<Ticket> getAll() throws SQLException {
        return null;
    }

    @Override
    public int search() throws SQLException {
                Connection con = DBConnection.getInstance().getConnection();
        ResultSet resultSet = con.createStatement().executeQuery("SELECT MAX(TicketID) FROM Ticket");
        int id = 0;


        while (resultSet.next()) {
            id = resultSet.getInt(1);
        }
        return id;
    }

    @Override
    public int search1class(String idl) throws SQLException {
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

    @Override
    public int search2class(String idl) throws SQLException {
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
}
