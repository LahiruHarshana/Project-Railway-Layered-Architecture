package lk.ijse.railway.dao.custom;

import lk.ijse.railway.dao.CrudDAO;
import lk.ijse.railway.entity.Passenger;

import java.sql.SQLException;

public interface PassengerDAO extends CrudDAO<Passenger,String> {
    public  int searchId() throws SQLException;

    }
