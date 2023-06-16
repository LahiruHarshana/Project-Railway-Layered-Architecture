package lk.ijse.railway.bo.custom.impl;

import lk.ijse.railway.bo.custom.SignUpPasswordBO;
import lk.ijse.railway.dao.DAOFactory;
import lk.ijse.railway.dao.custom.impl.UserDAOImpl;
import lk.ijse.railway.dto.User;
import lk.ijse.railway.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SignUpPasswordBOImpl implements SignUpPasswordBO {

    UserDAOImpl userDAO = (UserDAOImpl) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.USER);
    @Override

    public int search() throws SQLException {
        return userDAO.search();
    }
    @Override
    public boolean save(User entity) throws SQLException {
        return userDAO.save(entity);
    }
}
