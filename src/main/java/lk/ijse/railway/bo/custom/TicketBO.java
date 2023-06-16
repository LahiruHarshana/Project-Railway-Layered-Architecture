package lk.ijse.railway.bo.custom;

import lk.ijse.railway.bo.SuperBO;

import java.sql.SQLException;
import java.util.List;

public interface TicketBO extends SuperBO {
    public int search1class(String idl) throws SQLException ;
    public int search2class(String idl) throws SQLException ;
    public int search3class(String idl) throws SQLException ;
    public List<String> loadtrainIds() throws SQLException ;
}
