package lk.ijse.railway.dao.custom.impl;

import lk.ijse.railway.dao.custom.TrainDAO;
import lk.ijse.railway.db.DBConnection;
import lk.ijse.railway.dto.Train;
import lk.ijse.railway.util.CrudUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TrainDAOImpl implements TrainDAO {
    @Override
    public Train search(String text) throws SQLException {
                String sql = "SELECT * FROM Train WHERE TrainID = ?";
          PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql);
          pstm.setString(1, text);
          ResultSet rst = pstm.executeQuery();

        if (rst.next()){
            return new Train(rst.getString(1),rst.getString(2),rst.getTime(3),rst.getString(4));
        }
        return null;
    }

    @Override
    public boolean save(Train entity) throws SQLException {
                    String sql = "INSERT INTO Train(TrainID, TrainName, Time,EndStation) " +
                    "VALUES(?, ?, ?,?)";
            return CrudUtil.execute(
                    sql,
            entity.getId(),
            entity.getName(),
            entity.getTime(),
            entity.getEndStation());
    }

    @Override
    public boolean update(Train entity) throws SQLException {
                String sql = "UPDATE Train SET TrainName = ?, Time = ? , EndStation = ? WHERE TrainID = ?";
        PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql);
        pstm.setString(1, entity.getName());
        pstm.setTime(2, entity.getTime());
        pstm.setString(3, entity.getEndStation());
        pstm.setString(4, entity.getId());


        return pstm.executeUpdate() > 0;
    }

    @Override
    public boolean delete(String code) throws SQLException {
                String sql = "DELETE FROM Train WHERE TrainID = ?";

        return CrudUtil.execute(sql,code);
    }

    @Override
    public List<Train> getAll() throws SQLException {
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

    @Override
    public Train searchTime(Time formattedTime) throws SQLException {
        String sql = "SELECT * FROM Train WHERE Time = ?";
        ResultSet rst = CrudUtil.execute(sql, formattedTime);

        if (rst.next()){
            return new Train(rst.getString(1),rst.getString(2),rst.getTime(3),rst.getString(4));
        }
        return null;


    }

    @Override
    public List<String> loadtrainIds() throws SQLException {
        Connection con = DBConnection.getInstance().getConnection();
        ResultSet resultSet = con.createStatement().executeQuery("SELECT TrainID FROM Train");

        List<String> data = new ArrayList<>();

        while (resultSet.next()) {
            data.add(resultSet.getString(1));
        }
        return data;
    }

}
