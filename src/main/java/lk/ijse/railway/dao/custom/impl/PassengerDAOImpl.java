package lk.ijse.railway.dao.custom.impl;


import lk.ijse.railway.dao.custom.PassengerDAO;
import lk.ijse.railway.db.DBConnection;
import lk.ijse.railway.entity.Passenger;
import lk.ijse.railway.dao.custom.impl.util.CrudUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PassengerDAOImpl implements PassengerDAO {
    @Override
    public Passenger search(String text) throws SQLException {

        String sql = "SELECT * FROM Passenger WHERE PassengerID = ?";
        PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql);
        pstm.setString(1, text);
        ResultSet rst = pstm.executeQuery();

        if (rst.next()){
            return new Passenger(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getString(6),rst.getString(7));
        }
        return null;


    }

    @Override
    public boolean save(Passenger entity) throws SQLException {
                String sql = "INSERT INTO Passenger(PassengerID,PassengerName,BookingID,ContactNum,Email,Address,NIC) " +
                "VALUES(?, ?, ?,?,?,?,?)";

        return CrudUtil.execute(
                sql,

        entity.getId(),
        entity.getName(),
        entity.getBookinId(),
        entity.getContact(),
        entity.getEmail(),
        entity.getAddress(),
        entity.getNic());
    }

    @Override
    public boolean update(Passenger entity) throws SQLException {
                    String sql = "UPDATE Passenger SET PassengerName = ?, BookingID = ?,ContactNum = ?, Email = ?,Address = ?,NIC = ? WHERE PassengerID = ?";
        return CrudUtil.execute(
                sql,

            entity.getName(),
            entity.getBookinId(),
            entity.getContact(),
            entity.getEmail(),
            entity.getAddress(),
            entity.getNic(),
            entity.getId());
    }

    @Override
    public boolean delete(String code) throws SQLException {
        return false;
    }

    @Override
    public List<Passenger> getAll() throws SQLException {
        return null;
    }

    @Override
    public int searchId() throws SQLException {
                Connection con = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = con.prepareStatement("SELECT MAX(PassengerID) FROM Passenger");
        int id = 0;

        ResultSet resultSet = pstm.executeQuery();

        while (resultSet.next()) {
            id = resultSet.getInt(1);
        }
        return id;
    }
}
