package lk.ijse.railway.dao.custom;

import lk.ijse.railway.dao.CrudDAO;
import lk.ijse.railway.entity.StationDetails;

import java.sql.SQLException;
import java.util.List;

public interface StationDetailsDAO extends CrudDAO<StationDetails,String> {
        public List<String> searchById(String idl) throws SQLException;
}
