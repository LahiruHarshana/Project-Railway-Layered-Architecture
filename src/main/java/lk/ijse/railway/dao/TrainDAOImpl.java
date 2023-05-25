package lk.ijse.railway.dao;

import lk.ijse.railway.db.DBConnection;
import lk.ijse.railway.dto.Train;
import lk.ijse.railway.util.CrudUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TrainDAOImpl {
    public static Train search(String text) throws SQLException {
        /*try (Connection con = DBConnection.getInstance().getConnection()) {
            String sql = "SELECT * FROM Train WHERE TrainID = ?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, text);

            ResultSet resultSet = pstm.executeQuery();
            if(resultSet.next()) {
                return new Train(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getTime(3)
                );

            }

            return null;
        }*/
        String sql = "SELECT * FROM Train WHERE TrainID = ?";
//        ResultSet rst = CrudUtil.execute(sql, text);
          PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql);
          pstm.setString(1, text);
          ResultSet rst = pstm.executeQuery();

        if (rst.next()){
            return new Train(rst.getString(1),rst.getString(2),rst.getTime(3),rst.getString(4));
        }
        return null;

    }

    public static boolean update(Train train) throws SQLException {


        String sql = "UPDATE Train SET TrainName = ?, Time = ? , EndStation = ? WHERE TrainID = ?";
        PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql);
        pstm.setString(1, train.getName());
        pstm.setTime(2, train.getTime());
        pstm.setString(3, train.getEndStation());
        pstm.setString(4, train.getId());


        return pstm.executeUpdate() > 0;

    }






//        try (Connection con = DBConnection.getInstance().getConnection()) {
//            String sql = "UPDATE Train SET TrainName = ?, Time = ? WHERE TrainID = ?";
//            PreparedStatement pstm = con.prepareStatement(sql);
//            pstm.setString(1, train.getName());
//            pstm.setTime(2, train.getTime());
//            pstm.setString(3, train.getId());
//
//
//            return pstm.executeUpdate() > 0;
//        }catch (Exception e){
//            System.out.println(e);
//        }
//        return false;


//        String sql = "UPDATE Train SET TrainName = ?, Time = ? , EndStation = ? WHERE TrainID = ?";
//
//        PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql);
//
//        pstm.setString(1, train.getName());
//        pstm.setString(2, String.valueOf(train.getTime()));
//        pstm.setString(3, train.getEndStation());
//        pstm.setString(4, train.getId());
//
////        return pstm.executeUpdate() > 0;
//
//        return  CrudUtil.execute(sql,train.getId(),train.getName(),train.getTime(),train.getEndStation());

   // }

    public static boolean save(Train train) throws SQLException {

            String sql = "INSERT INTO Train(TrainID, TrainName, Time,EndStation) " +
                    "VALUES(?, ?, ?,?)";
            return CrudUtil.execute(
                    sql,
            train.getId(),
            train.getName(),
            train.getTime(),
            train.getEndStation());

    }


    public static List<String> loadIds() throws SQLException {

        Connection con = DBConnection.getInstance().getConnection();
        ResultSet resultSet = con.createStatement().executeQuery("SELECT TrainID FROM Train");

        List<String> data = new ArrayList<>();

        while (resultSet.next()) {
            data.add(resultSet.getString(1));
        }
        return data;
    }

    public static List<Train> getAll() throws SQLException {

        List<Train> data = new ArrayList<>();

        String sql = "SELECT * FROM Train";
        ResultSet resultSet = CrudUtil.execute(sql);

        while (resultSet.next()) {
            data.add(new Train(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getTime(3),
                    resultSet.getString(4)
            ));
        }
        return data;
    }

    public static boolean delete(String code) throws SQLException {
        String sql = "DELETE FROM Train WHERE TrainID = ?";

        return CrudUtil.execute(sql,code);

    }

    public static Train searchTime(Time formattedTime) throws SQLException {
        String sql = "SELECT * FROM Train WHERE Time = ?";
        ResultSet rst = CrudUtil.execute(sql, formattedTime);

        if (rst.next()){
            return new Train(rst.getString(1),rst.getString(2),rst.getTime(3),rst.getString(4));
        }
        return null;


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
    public static List<String> loadTrainIds() throws SQLException {
        Connection con = DBConnection.getInstance().getConnection();
        ResultSet resultSet = con.createStatement().executeQuery("SELECT TrainID FROM train");

        List<String> data = new ArrayList<>();

        while (resultSet.next()) {
            data.add(resultSet.getString(1));
        }
        return data;

    }
}
