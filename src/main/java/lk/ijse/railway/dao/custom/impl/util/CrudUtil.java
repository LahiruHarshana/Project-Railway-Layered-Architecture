package lk.ijse.railway.dao.custom.impl.util;

/*
    @author DanujaV
    @created 3/30/23 - 11:19 AM   
*/

import lk.ijse.railway.db.DBConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CrudUtil {
    public static <T>T execute(String sql, Object... args) throws SQLException {
        PreparedStatement pstm = DBConnection.getInstance().getConnection()
                .prepareStatement(sql);


        for (int i = 0; i < args.length; i++) {
            pstm.setObject((i+1), args[i]);
        }

        if(sql.startsWith("SELECT") || sql.startsWith("select")) {
            return (T) pstm.executeQuery(); //ResultSet
        }

        return (T) (Boolean)(pstm.executeUpdate() > 0);    //premitive -> boolean

    }
}
