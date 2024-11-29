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
public class Customers {

    public static ResultSet rs;
    private final String Url;
    private final String Host;
    private final String Database;
    private final String Username;
    private final String Password;
    public java.sql.Connection connection = null;

    public Customers(String host, String database, String username, String password) {
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

    public boolean ReadCustomer() throws SQLException {
        String sql = "SELECT * FROM customers";
        Statement st = connection.createStatement();
        rs = st.executeQuery(sql);
        return false;
    }

    public boolean ReadAccounts() throws SQLException {
        String sql = "SELECT * FROM accounts";
        Statement st = connection.createStatement();
        rs = st.executeQuery(sql);
        return false;
    }


    /*public boolean SelectCustomerExist(String FName, String LName) throws Exception {
        String sql = "SELECT * FROM customers WHERE FName = '" + FName + "' AND LName='" + LName + "'";
        Statement st = connection.createStatement();
        rs = st.executeQuery(sql);
        return false;
    }*/
    public boolean SearchCustomer(String Search) throws SQLException {
        String sql = "SELECT * FROM customers WHERE CONCAT(Customers_ID,FName,MName,LName) LIKE '%" + Search + "%'";
        Statement st = connection.createStatement();
        rs = st.executeQuery(sql);
        return false;
    }

    public boolean InsertCustomer(String FName, String MName, String LName, String Contact, String Address) throws SQLException {
        String sql = "INSERT INTO customers (FName,MName,LName,Contact,Address) VALUES ('" + FName + "','" + MName + "','" + LName + "','" + Contact + "','" + Address + "')";
        Statement st = connection.createStatement();
        st.executeUpdate(sql);
        return false;
    }

    public boolean DeleteCustomer(String Customer_ID) throws SQLException {
        String sql = "DELETE FROM customers WHERE Customers_ID = '" + Customer_ID + "'";
        Statement st = connection.createStatement();
        st.executeUpdate(sql);
        return false;
    }

    public boolean UpdateCustomer(String FName, String MName, String LName, String FullName, String Contact, String Address, String Customers_ID) throws SQLException {
        String sql = "UPDATE Customers SET FName= '" + FName + "',MName='" + MName + "',LName='" + LName + "',FullName='" + FullName + "',Contact='" + Contact + "',Address='" + Address + "' WHERE Customers_ID ='" + Customers_ID + "' ";
        Statement st = connection.createStatement();
        st.executeUpdate(sql);
        return false;
    }

    public boolean InsertCustomer(String FName, String MName, String LName, String FullName, String Contact, String Address) throws SQLException {
        String sql = "INSERT INTO customers (FName,MName,LName,FullName,Contact,Address) VALUES ('" + FName + "','" + MName + "','" + LName + "','" + FullName + "','" + Contact + "','" + Address + "')";
        Statement st = connection.createStatement();
        st.executeUpdate(sql);
        return false;
    }

    public boolean CustomerExist(String Fname, String Lname) throws SQLException {
        String sql = "SELECT * FROM customers WHERE Fname='" + Fname + "'  and Lname='" + Lname + "'";
        Statement st = connection.createStatement();
        rs = st.executeQuery(sql);
        return false;
    }
    
    public boolean addCustomerLog(String user,String FullName) throws SQLException {
        String sql = "INSERT INTO customerlogs (user,FullName,time,date,action) VALUES ('" + user + "','" + FullName + "',CURTIME(),CURDATE(),'Add')";
        Statement st = connection.createStatement();
        st.executeUpdate(sql);
        return false;
    }
       public boolean deleteCustomerLog(String user,String FullName) throws SQLException {
        String sql = "INSERT INTO customerlogs (user,FullName,time,date,action) VALUES ('" + user + "','" + FullName + "',CURTIME(),CURDATE(),'Delete')";
        Statement st = connection.createStatement();
        st.executeUpdate(sql);
        return false;
    }
        public boolean updateCustomerLog(String user,String FullName) throws SQLException {
        String sql = "INSERT INTO customerlogs (user,FullName,time,date,action) VALUES ('" + user + "','" + FullName + "',CURTIME(),CURDATE(),'Update')";
        Statement st = connection.createStatement();
        st.executeUpdate(sql);
        return false;
    }

   
    public boolean SelectCustomers() throws SQLException {
        String sql = "SELECT Fname,LName FROM customers";
        Statement st = connection.createStatement();
        rs = st.executeQuery(sql);
        return false;
    }

    
}
