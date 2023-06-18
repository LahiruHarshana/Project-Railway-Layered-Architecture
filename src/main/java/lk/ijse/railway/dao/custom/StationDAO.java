package lk.ijse.railway.dao.custom;

import lk.ijse.railway.dao.CrudDAO;
import lk.ijse.railway.entity.Station;

import java.sql.SQLException;
import java.util.List;

public interface StationDAO extends CrudDAO<Station,String> {
        public List<String> loadIds() throws SQLException;
       public Station searchById(String name) throws SQLException;
}
