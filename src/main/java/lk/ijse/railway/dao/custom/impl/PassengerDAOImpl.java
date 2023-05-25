package lk.ijse.railway.dao.custom.impl;


import lk.ijse.railway.db.DBConnection;
import lk.ijse.railway.dto.Passenger;
import lk.ijse.railway.util.CrudUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PassengerDAOImpl {
    public static boolean save(String passengerId, String passengerName, String bookingId, String contactNum, String email, String address, String nic) throws SQLException, SQLException {


        String sql = "INSERT INTO Passenger(PassengerID,PassengerName,BookingID,ContactNum,Email,Address,NIC) " +
                "VALUES(?, ?, ?,?,?,?,?)";

        return CrudUtil.execute(
                sql,

        passengerId,
        passengerName,
        bookingId,
        contactNum,
        email,
        address,
        nic);
    }

    public static int search() throws SQLException {
        Connection con = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = con.prepareStatement("SELECT MAX(PassengerID) FROM Passenger");
        int id = 0;

        ResultSet resultSet = pstm.executeQuery();

        while (resultSet.next()) {
            id = resultSet.getInt(1);
        }
        return id;



    }

    public static Passenger searchPassenger(String text) throws SQLException {
        String sql = "SELECT * FROM Passenger WHERE PassengerID = ?";
//        ResultSet rst = CrudUtil.execute(sql, text);
       PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql);
      pstm.setString(1, text);
       ResultSet rst = pstm.executeQuery();

        if (rst.next()){
            return new Passenger(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getString(6),rst.getString(7));
        }
        return null;


    }

    public static boolean update(Passenger passenger) throws SQLException {

            String sql = "UPDATE Passenger SET PassengerName = ?, BookingID = ?,ContactNum = ?, Email = ?,Address = ?,NIC = ? WHERE PassengerID = ?";
        return CrudUtil.execute(
                sql,

            passenger.getName(),
            passenger.getBookinId(),
            passenger.getContact(),
            passenger.getEmail(),
            passenger.getAddress(),
            passenger.getNic(),
            passenger.getId());


    }
}
