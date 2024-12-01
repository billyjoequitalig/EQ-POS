/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eq.point.of.sale.system.Queries;

import eq.point.of.sale.system.DBConnection.DBConnection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author billy
 */
public class Login {

    public static ResultSet rs;
    DBConnection DBcon = new DBConnection("localhost", "3306", "eqpos", "root", "001995234");
//    public java.sql.Connection connection = null;

    public boolean AdminExist(String Username, String Password) throws SQLException {

        String sql = "SELECT * FROM accounts WHERE Username='" + Username + "' AND Password = '" + Password + "'";
        Statement st = DBcon.gettter().createStatement();
        rs = st.executeQuery(sql);
        return false;
    }
}
