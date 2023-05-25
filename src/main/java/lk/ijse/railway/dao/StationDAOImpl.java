package lk.ijse.railway.dao;

import lk.ijse.railway.db.DBConnection;
import lk.ijse.railway.dto.Station;
import lk.ijse.railway.util.CrudUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StationDAOImpl {
    public static boolean save(Station station) throws SQLException {

        String sql = "INSERT INTO Station(StationID, StationName, Distance) " +
                "VALUES(?, ?, ?)";
        return CrudUtil.execute(
                sql,

                station.getId(),
                station.getName(),
                station.getDistance());

    }



    public static boolean update(Station station) throws SQLException {
        String sql = "UPDATE Station SET StationName=?,Distance=? WHERE StationID = ?";
        return CrudUtil.execute(
                sql,
            station.getName(),
            station.getDistance(),
            station.getId());


    }


    public static Station search(String id) throws SQLException {
            String sql = "SELECT * FROM Station WHERE StationID = ?";



            ResultSet resultSet = CrudUtil.execute(sql,id);
            if (resultSet.next()) {
                return new Station(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getDouble(3)
                );
            }
            return null;

    }

    public static List<String> loadIds() throws SQLException {
        Connection con = DBConnection.getInstance().getConnection();
        ResultSet resultSet = con.createStatement().executeQuery("SELECT StationName FROM Station");

        List<String> data = new ArrayList<>();

        while (resultSet.next()) {
            data.add(resultSet.getString(1));
        }
        return data;
    }

    public static List<String> loadtrainIds() throws SQLException {
        Connection con = DBConnection.getInstance().getConnection();
        ResultSet resultSet = con.createStatement().executeQuery("SELECT TrainID FROM Train");

        List<String> data = new ArrayList<>();

        while (resultSet.next()) {
            data.add(resultSet.getString(1));
        }
        return data;
    }


    public static boolean delete(String code) throws SQLException {


        Connection con = DBConnection.getInstance().getConnection();
        String sql = "DELETE FROM Station WHERE StationID = ?";
        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.setString(1, code);

        return pstm.executeUpdate() > 0;
    }

    public static List<Station> getAll() throws SQLException {

        List<Station> data = new ArrayList<>();

        String sql = "SELECT * FROM Station";
        ResultSet resultSet = CrudUtil.execute(sql);

        while (resultSet.next()) {
            data.add(new Station(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getDouble(3)
            ));
        }
        return data;

    }
}









