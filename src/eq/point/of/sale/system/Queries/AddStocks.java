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
public class AddStocks {

    public static ResultSet rs;
    private final String Url;
    private final String Host;
    private final String Database;
    private final String Username;
    private final String Password;
    public java.sql.Connection connection = null;

    public AddStocks(String host, String database, String username, String password) {
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

    public boolean ReadProduct() throws SQLException {
        String sql = "SELECT * FROM products";
        Statement st = connection.createStatement();
        rs = st.executeQuery(sql);
        return false;
    }

    public boolean LoadLogs() throws SQLException {
        String sql = "SELECT * FROM stockslogs";
        Statement st = connection.createStatement();
        rs = st.executeQuery(sql);
        return false;
    }

    public boolean SearchProduct(String Search) throws SQLException {
        String sql = "SELECT * FROM products WHERE CONCAT(Product_ID,Name) LIKE '%" + Search + "%'";
        Statement st = connection.createStatement();
        rs = st.executeQuery(sql);
        return false;
    }

    public boolean AddStocks(String Quantity, String Product_ID) throws SQLException {
        String sql = "UPDATE products SET Quantity ='" + Quantity + "' WHERE Product_ID = '" + Product_ID + "'";
        Statement st = connection.createStatement();
        st.executeUpdate(sql);
        return false;
    }

    public boolean CurrentDate() throws SQLException {
        String sql = "SELECT Curdate()";
        Statement st = connection.createStatement();
        rs = st.executeQuery(sql);
        return false;
    }

    public boolean CurrentTime() throws SQLException {
        String sql = "SELECT Curtime()";
        Statement st = connection.createStatement();
        rs = st.executeQuery(sql);
        return false;
    }

    public boolean SelectAccounts() throws SQLException {
        String sql = "SELECT FName,LName FROM accounts ORDER BY FName ASC";
        Statement st = connection.createStatement();
        rs = st.executeQuery(sql);
        return false;
    }

    public boolean insertStockLogs(String ID, String Name, String quantity) throws SQLException {
        String sql = "INSERT INTO stockslogs(Product_id,Product_name,Quantity,Time)VALUES('" + ID + "','" + Name + "','" + quantity + "',CONCAT(CURTIME(),' ',CURDATE()))";
        Statement st = connection.createStatement();
        st.executeUpdate(sql);
        return false;

    }

    public boolean addLog(String Date) throws SQLException {
        String sql = "SELECT * FROM newstockslogs where action='Add'  and Date='" + Date + "' ";
        Statement st = connection.createStatement();
        rs = st.executeQuery(sql);
        return false;

    }

    public boolean updateLog(String Date) throws SQLException {
        String sql = "SELECT * FROM newstockslogs where action='Update' and Date= '" + Date + "' ";
        Statement st = connection.createStatement();
        rs = st.executeQuery(sql);
        return false;

    }

    public boolean deleteLog(String Date) throws SQLException {
        String sql = "SELECT * FROM newstockslogs where action='Delete' and Date='" + Date + "' ";
        Statement st = connection.createStatement();
        rs = st.executeQuery(sql);
        return false;

    }
    
    public boolean AddStockLog(String Date) throws SQLException {
        String sql = "SELECT * FROM newstockslogs where action='Add Stock'  and Date='"+Date+"' ";
        Statement st = connection.createStatement();
        rs = st.executeQuery(sql);
        return false;

    }

}
