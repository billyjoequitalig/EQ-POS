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
public class Report {

    public static ResultSet rs;
    private final String Url;
    private final String Host;
    private final String Database;
    private final String Username;
    private final String Password;
    public java.sql.Connection connection = null;

    public Report(String host, String database, String username, String password) {
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

    public boolean getReport() throws SQLException {
        String sql = "SELECT * FROM report";
        Statement st = connection.createStatement();
        rs = st.executeQuery(sql);
        return false;
    }

    public boolean readReport() throws SQLException {
        String sql = "Select date,daily_amount from report";
        Statement st = connection.createStatement();
        rs = st.executeQuery(sql);
        return false;
    }

    public boolean RangeSearch(String fromDate, String toDate) throws SQLException {
        String sql = "SELECT date,daily_amount FROM report where Date Between '" + fromDate + "' and '" + toDate + "' order by date asc ";
        Statement st = connection.createStatement();
        rs = st.executeQuery(sql);
        return false;

    }

    public boolean monthlyReport(String fromDate, String toDate, String fromMonth, String toMonth) throws SQLException {
        String sql = "SELECT  DISTINCT MONTH,YEAR,MONTHLY_AMOUNT FROM report WHERE DATE BETWEEN '" + fromDate + "' AND '" + toDate + "' AND  MONTH BETWEEN '" + fromMonth + "' AND '" + toMonth + "' ";
        Statement st = connection.createStatement();
        rs = st.executeQuery(sql);
        return false;

    }
}
