package lk.ijse.railway.dao;

import lk.ijse.railway.dto.Ticket;
import lk.ijse.railway.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TicketingDAOImpl {
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
