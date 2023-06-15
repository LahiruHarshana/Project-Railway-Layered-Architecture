package lk.ijse.railway.dao.custom;

import lk.ijse.railway.dao.CrudDAO;
import lk.ijse.railway.dto.LoginHistory;
import lk.ijse.railway.dto.User;

import java.sql.SQLException;

public interface LoginHistoryDAO extends CrudDAO<LoginHistory,String> {
        public boolean saveLogOut(LoginHistory loginHistory) throws SQLException;


        public  LoginHistory searchLastID() throws SQLException;


}
