/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eq.point.of.sale.system.Queries;

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
    private final String Url;
    private final String Host;
    private final String Database;
    private final String Username;
    private final String Password;
    public java.sql.Connection connection = null;

    public Login(String host, String database, String username, String password) {
        Host = host;
        Database = database;
        Username = username;
        Password = password;
        Url = "jdbc:mysql://" + Host + ":3306/";
    }

    public void Open() throws SQLException {
        connection = DriverManager.getConnection(Url + Database + "?autoReconnect=true&useSSL=false" + "", Username, Password);
    }

    // To Close Connection
    public void Close() throws SQLException {
        connection.close();
    }

    public boolean AdminExist(String Username, String Password) throws SQLException {
        String sql = "SELECT * FROM accounts WHERE Username='" + Username + "' AND Password = '" + Password + "'";
        Statement st = connection.createStatement();
        rs = st.executeQuery(sql);
        return false;
    }
}
