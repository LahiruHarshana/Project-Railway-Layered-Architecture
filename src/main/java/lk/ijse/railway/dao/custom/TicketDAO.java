package lk.ijse.railway.dao.custom;

import lk.ijse.railway.dao.CrudDAO;
import lk.ijse.railway.entity.Ticket;

import java.sql.SQLException;

public interface TicketDAO extends CrudDAO<Ticket,String> {

    public int search() throws SQLException;


    public int search1class(String idl) throws SQLException;

    public int search2class(String idl) throws SQLException;
}
