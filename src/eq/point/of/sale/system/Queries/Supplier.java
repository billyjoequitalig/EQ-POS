/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eq.point.of.sale.system.Queries;

import static eq.point.of.sale.system.Queries.Supplier.rs;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Diowinard Medrano
 */
public class Supplier {
    public static ResultSet rs;
    private final String Url;
    private final String Host;
    private final String Database;
    private final String Username;
    private final String Password;
    public java.sql.Connection connection = null;

    public Supplier(String host, String database, String username, String password) {
        Host = host;
        Database = database;
        Username = username;
        Password = password;
        Url = "jdbc:mysql://" + Host + ":3306/";
    }

    public void Open() throws SQLException {
        //To Open Connection
        connection = DriverManager.getConnection(Url + Database + "?autoReconnect=true&useSSL=false" + "", Username, Password);
    }

    public void Close() throws SQLException {
        // To Close Connection
        connection.close();
    }

    public boolean ReadSupplier() throws SQLException {
        //Read Supplier
        String sql = "SELECT * FROM supplier ORDER BY SupplierName ASC";
        Statement st = connection.createStatement();
        rs = st.executeQuery(sql);
        return false;
    }

    public boolean DeleteSupplier(String Supplier_ID) throws SQLException {
        //Delete Supplier
        String sql = "DELETE FROM supplier WHERE Supplier_ID = '" + Supplier_ID + "'";
        Statement st = connection.createStatement();
        st.executeUpdate(sql);
        return false;
    }

    public boolean UpdateSupplier(String Supplier_ID, String SupplierName, String contact, String Address) throws SQLException {
        //Update Supplier
        String sql = "UPDATE supplier SET SupplierName= '" + SupplierName + "',Contact='" + contact + "',Address='" + Address + "' WHERE Supplier_ID ='" + Supplier_ID + "' ";
        Statement st = connection.createStatement();
        st.executeUpdate(sql);
        return false;
    }

    public boolean InsertSupplier(String Supplier_ID, String SupplierName, String contact, String Address) throws SQLException {
        //Insert Supplier
        String sql = "INSERT INTO supplier (SupplierName,Contact,Address) VALUES ('" + SupplierName + "','" + contact + "','" + Address + "')";
        Statement st = connection.createStatement();
        st.executeUpdate(sql);
        return false;
    }

    public boolean SearchSupplier(String Search) throws SQLException {
        //Search Supplier
        String sql = "SELECT * FROM supplier WHERE CONCAT(SupplierName,Contact,Address) LIKE '%" + Search + "%'";
        Statement st = connection.createStatement();
        rs = st.executeQuery(sql);
        return false;
    }
    
    public boolean SupplierExist(String Name, String Supplier_ID) throws SQLException {
        //Supplier Exist
        String sql = "SELECT * FROM supplier WHERE SupplierName='" + Name + "' AND Supplier_ID='" + Supplier_ID + "'";
        Statement st = connection.createStatement();
        rs = st.executeQuery(sql);
        return false;
    }

}
