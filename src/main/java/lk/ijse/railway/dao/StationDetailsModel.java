package lk.ijse.railway.dao;

import lk.ijse.railway.db.DBConnection;
import lk.ijse.railway.dto.StationDetails;
import lk.ijse.railway.dto.Train;
import lk.ijse.railway.util.CrudUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StationDetailsModel {
    public static boolean saveTrainStation(StationDetails stationDetails) throws SQLException {

            String sql = "INSERT INTO StationDetails(TrainID, StationName, Time) " +
                    "VALUES(?, ?, ?)";
        return CrudUtil.execute(
                sql,
            stationDetails.getTrainId(),
            stationDetails.getStationId(),
            stationDetails.getTime());

        //=


    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public static List<String> searchById(String idl) throws SQLException {
        String sql = "SELECT StationName FROM StationDetails WHERE TrainID = ?";

        //=


        ResultSet resultSet = CrudUtil.execute(sql,idl);

        List<String> data = new ArrayList<>();

        while (resultSet.next()) {
            data.add(resultSet.getString(1));
        }
        return data;    }

    public static List<String> searchBySeats(String idl) throws SQLException {

        String sql = "SELECT SeatsID FROM Booking WHERE TrainID = ?";

        ResultSet resultSet = CrudUtil.execute(sql,idl);

        List<String> data = new ArrayList<>();

        while (resultSet.next()) {
            data.add(resultSet.getString(1));
        }
        return data;
    }
}
