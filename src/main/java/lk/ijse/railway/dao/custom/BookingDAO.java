package lk.ijse.railway.dao.custom;

import lk.ijse.railway.dao.CrudDAO;
import lk.ijse.railway.entity.Booking;

import java.sql.*;
import java.util.List;

public interface BookingDAO extends CrudDAO<Booking,String> {
    public  List<String> loadIds(String trainId, Date date) throws SQLException ;



    public  int search3class(String idl) throws SQLException ;
}
