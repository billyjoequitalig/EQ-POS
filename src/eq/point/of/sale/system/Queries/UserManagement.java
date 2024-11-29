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
public class UserManagement {

    public static ResultSet rs;
    private String Url = "jdbc:mysql://localhost:3306/";
    private final String Host;
    private final String Database;
    private final String Username;
    private final String Password;
    public java.sql.Connection connection = null;

    public UserManagement(String host, String database, String username, String password) {
        Host = host;
        Database = database;
        Username = username;
        Password = password;
        Url = "jdbc:mysql://" + Host + ":3306/";
    }

    // To Open Connection
    public void Open() throws SQLException {
        connection = DriverManager.getConnection(Url + Database + "?autoReconnect=true&useSSL=false" + "", Username, Password);
    }

    // To Close Connection
    public void Close() throws SQLException {
        connection.close();
    }

    public boolean CreateAccount(String FName, String LName, String Username, String Password, String AccessType, String Status) throws SQLException {
        String sql = "INSERT INTO Accounts (FName,LName,Username,Password,AccessType,Status) Values ('" + FName + "','" + LName + "','" + Username + "','" + Password + "','" + AccessType + "','" + Status + "')";
        Statement st = connection.createStatement();
        st.executeUpdate(sql);
        return false;
    }

    public boolean ReadAccounts() throws SQLException {
        String sql = "SELECT * FROM accounts ORDER BY FName ASC";
        Statement st = connection.createStatement();
        rs = st.executeQuery(sql);
        return false;
    }
    
    public boolean ReadAccountsUser() throws SQLException {
        String sql = "SELECT Account_ID, FName, LName, Username, AccessType, Status, Insentives FROM accounts ORDER BY FName ASC";
        Statement st = connection.createStatement();
        rs = st.executeQuery(sql);
        return false;
    }

    public boolean CheckAccountExist(String Username, String AccountID) throws SQLException {
        String sql = "SELECT * FROM accounts WHERE Username = '" + Username + "' AND Account_ID != '" + AccountID + "'";
        Statement st = connection.createStatement();
        rs = st.executeQuery(sql);
        return false;
    }

    public boolean DeleteAccount(String Account_ID) throws SQLException {
        String sql = "DELETE FROM accounts WHERE Account_ID = '" + Account_ID + "'";
        Statement st = connection.createStatement();
        st.executeUpdate(sql);
        return false;
    }

    public boolean UpdateAccount(String FName, String LName, String Username, String Password, String AccessType, String Account_ID) throws SQLException {
        String sql = "UPDATE accounts SET FName = '" + FName + "',LName ='" + LName + "',Username = '" + Username + "',Password='" + Password + "',AccessType = '" + AccessType + "' WHERE accounts.Account_ID = '" + Account_ID + "'";
        Statement st = connection.createStatement();
        st.executeUpdate(sql);
        return false;
    }

    public boolean UpdateStatus(String Account_ID, String Status) throws SQLException {
        String sql = "UPDATE accounts SET Status = '" + Status + "' WHERE Account_ID = '" + Account_ID + "'";
        Statement st = connection.createStatement();
        st.executeUpdate(sql);
        return false;
    }
}
