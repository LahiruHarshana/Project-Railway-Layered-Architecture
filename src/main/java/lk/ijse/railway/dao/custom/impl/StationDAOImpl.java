package lk.ijse.railway.dao.custom.impl;

import lk.ijse.railway.dao.custom.SalaryDAO;
import lk.ijse.railway.dao.custom.StationDAO;
import lk.ijse.railway.db.DBConnection;
import lk.ijse.railway.dto.Station;
import lk.ijse.railway.dto.Ticket;
import lk.ijse.railway.util.CrudUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StationDAOImpl implements StationDAO {
    @Override
    public Station search(String text) throws SQLException {
                    String sql = "SELECT * FROM Station WHERE StationID = ?";



            ResultSet resultSet = CrudUtil.execute(sql,text);
            if (resultSet.next()) {
                return new Station(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getDouble(3)
                );
            }
            return null;
    }

    @Override
    public boolean save(Station entity) throws SQLException {
                String sql = "INSERT INTO Station(StationID, StationName, Distance) " +
                "VALUES(?, ?, ?)";
        return CrudUtil.execute(
                sql,

                entity.getId(),
                entity.getName(),
                entity.getDistance());
    }

    @Override
    public boolean update(Station entity) throws SQLException {
                String sql = "UPDATE Station SET StationName=?,Distance=? WHERE StationID = ?";
        return CrudUtil.execute(
                sql,
            entity.getName(),
            entity.getDistance(),
            entity.getId());
    }

    @Override
    public boolean delete(String code) throws SQLException {
                Connection con = DBConnection.getInstance().getConnection();
        String sql = "DELETE FROM Station WHERE StationID = ?";
        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.setString(1, code);

        return pstm.executeUpdate() > 0;
    }

    @Override
    public List<Station> getAll() throws SQLException {
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

    @Override
    public List<String> loadIds() throws SQLException {
                Connection con = DBConnection.getInstance().getConnection();
        ResultSet resultSet = con.createStatement().executeQuery("SELECT StationName FROM Station");

        List<String> data = new ArrayList<>();

        while (resultSet.next()) {
            data.add(resultSet.getString(1));
        }
        return data;
    }

    @Override
    public Station searchById(String name) throws SQLException {

        String sql = "SELECT Distance FROM Station WHERE StationName = ?";



        ResultSet resultSet = CrudUtil.execute(sql,name);
        if (resultSet.next()) {
            return new Station(
                    resultSet.getDouble(1)
            );
        }
        return null;
    }
//    public static boolean save(Station station) throws SQLException {
//
//        String sql = "INSERT INTO Station(StationID, StationName, Distance) " +
//                "VALUES(?, ?, ?)";
//        return CrudUtil.execute(
//                sql,
//
//                station.getId(),
//                station.getName(),
//                station.getDistance());
//
//    }
//
//
//
//    public static boolean update(Station station) throws SQLException {
//        String sql = "UPDATE Station SET StationName=?,Distance=? WHERE StationID = ?";
//        return CrudUtil.execute(
//                sql,
//            station.getName(),
//            station.getDistance(),
//            station.getId());
//
//
//    }
//
//
//    public static Station search(String id) throws SQLException {
//            String sql = "SELECT * FROM Station WHERE StationID = ?";
//
//
//
//            ResultSet resultSet = CrudUtil.execute(sql,id);
//            if (resultSet.next()) {
//                return new Station(
//                        resultSet.getString(1),
//                        resultSet.getString(2),
//                        resultSet.getDouble(3)
//                );
//            }
//            return null;
//
//    }
//
//    public static List<String> loadIds() throws SQLException {
//        Connection con = DBConnection.getInstance().getConnection();
//        ResultSet resultSet = con.createStatement().executeQuery("SELECT StationName FROM Station");
//
//        List<String> data = new ArrayList<>();
//
//        while (resultSet.next()) {
//            data.add(resultSet.getString(1));
//        }
//        return data;
//    }
//
//
//
//    public static boolean delete(String code) throws SQLException {
//
//
//        Connection con = DBConnection.getInstance().getConnection();
//        String sql = "DELETE FROM Station WHERE StationID = ?";
//        PreparedStatement pstm = con.prepareStatement(sql);
//        pstm.setString(1, code);
//
//        return pstm.executeUpdate() > 0;
//    }
//
//    public static List<Station> getAll() throws SQLException {
//
//        List<Station> data = new ArrayList<>();
//
//        String sql = "SELECT * FROM Station";
//        ResultSet resultSet = CrudUtil.execute(sql);
//
//        while (resultSet.next()) {
//            data.add(new Station(
//                    resultSet.getString(1),
//                    resultSet.getString(2),
//                    resultSet.getDouble(3)
//            ));
//        }
//        return data;
//
//    }
//
//    public static Station searchById(String name) throws SQLException {
//
//        String sql = "SELECT Distance FROM Station WHERE StationName = ?";
//
//
//
//        ResultSet resultSet = CrudUtil.execute(sql,name);
//        if (resultSet.next()) {
//            return new Station(
//                    resultSet.getDouble(1)
//            );
//        }
//        return null;
//    }
}









