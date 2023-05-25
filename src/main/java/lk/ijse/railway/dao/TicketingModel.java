package lk.ijse.railway.dao;

import lk.ijse.railway.db.DBConnection;
import lk.ijse.railway.dto.Station;
import lk.ijse.railway.dto.Ticket;
import lk.ijse.railway.util.CrudUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TicketingModel {
    public static Ticket searchById(String name) throws SQLException {

        String sql = "SELECT Distance FROM Station WHERE StationName = ?";



        ResultSet resultSet = CrudUtil.execute(sql,name);
        if (resultSet.next()) {
            return new Ticket(
                    resultSet.getDouble(1)
            );
        }
        return null;
    }
}
