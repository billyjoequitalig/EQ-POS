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
public class PointOfSale {

    public static ResultSet rs;
    private final String Url;
    public final String Host;
    private final String Database;
    private final String Username;
    private final String Password;
    public java.sql.Connection connection = null;

    public PointOfSale(String host, String database, String username, String password) {
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

    public boolean SelectCustomers() throws SQLException {
        String sql = "SELECT Fname,LName FROM customers";
        Statement st = connection.createStatement();
        rs = st.executeQuery(sql);
        return false;
    }

    public boolean CurrentDate() throws SQLException {
        String sql = "SELECT Curdate()";
        Statement st = connection.createStatement();
        rs = st.executeQuery(sql);
        return false;
    }

    public boolean customerAddress(String name) throws SQLException {
        String sql = "SELECT Address from customers  where FullName='" + name + "'  ";
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

    public boolean ReadProducts() throws SQLException {
        String sql = "SELECT Quantity, UOM, Description, UnitPrice "
                + "FROM products ORDER BY Product ASC";
        Statement st = connection.createStatement();
        rs = st.executeQuery(sql);
        return false;
    }

    public boolean SearchProduct(String Search) throws SQLException {
        String sql = "SELECT  Quantity, UOM, Description, UnitPrice "
                + "FROM products WHERE product LIKE '%" + Search + "%' order by product ASC";

        Statement st = connection.createStatement();
        rs = st.executeQuery(sql);
        return false;
    }

    public boolean showPayLogs(String Date) throws SQLException {
        String sql = "SELECT * FROM paylogs  ";
        Statement st = connection.createStatement();
        rs = st.executeQuery(sql);
        return false;

    }

    public boolean pay(int Quantity, String Description) throws SQLException {
        String sql = "UPDATE products SET Quantity = '" + Quantity + "' WHERE description = '" + Description + "'";
        Statement st = connection.createStatement();
        st.executeUpdate(sql);
        return false;
    }

    public boolean points(String Fullname, Double Points) throws SQLException {
        String sql = "UPDATE customers SET points = '" + Points + "' WHERE FullName = '" + Fullname + "' ";
        Statement st = connection.createStatement();
        st.executeUpdate(sql);
        return false;
    }

    public boolean CheckPoints(String FullName) throws SQLException {
        String sql = "SELECT Points from customers where Fullname='" + FullName + "'";
        Statement st = connection.createStatement();
        rs = st.executeQuery(sql);
        return false;
    }

    public boolean Print() throws SQLException {
        String sql = "SELECT * from products";
        Statement st = connection.createStatement();
        rs = st.executeQuery(sql);
        return false;
    }

    public boolean PayLogs(String user, double cash_gave, double cost, double change, int quantity, String products, String customer) throws SQLException {
        String sql = "INSERT INTO paylogs (user,cash_gave,cost,changed,quantity,products,customer,time,date) VALUES ('" + user + "','" + cash_gave + "','" + cost + "','" + change + "','" + quantity + "', '" + products + "','" + customer + "',CURTIME(),CURDATE())";
        Statement st = connection.createStatement();
        st.executeUpdate(sql);
        return false;
    }

    public boolean QuantitySum(String Product_ID, int Quantity) throws SQLException {
        String sql = "UPDATE products SET Quantity =(SELECT SUM(Quantity-" + Quantity + ") WHERE Product_ID = '1810002') WHERE Product_ID = '" + Product_ID + "'";
        Statement st = connection.createStatement();
        st.executeUpdate(sql);
        return false;
    }

    public void showPayLogs() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean addPayLog(String Customer, String Date) throws SQLException {
        String sql = "SELECT * FROM paylogs where Customer='" + Customer + "'  and Date='" + Date + "' ";
        Statement st = connection.createStatement();
        rs = st.executeQuery(sql);
        return false;

    }

    public boolean RangeSearch(String Customer, String fromDate, String toDate) throws SQLException {
        String sql = "SELECT * FROM paylogs where Customer='" + Customer + "'  and Date Between '" + fromDate + "' and '" + toDate + "' ";
        Statement st = connection.createStatement();
        rs = st.executeQuery(sql);
        return false;

    }

    public boolean getDate(String Date) throws SQLException {
        String sql = "SELECT date,daily_amount from report where Date='" + Date + "'";
        Statement st = connection.createStatement();
        rs = st.executeQuery(sql);
        return false;
    }

    public boolean updateReportSum(Double Amount, String Date) throws SQLException {
        String sql = "UPDATE report SET daily_amount = '" + Amount + "' WHERE date = '" + Date + "' ";
        Statement st = connection.createStatement();
        st.executeUpdate(sql);
        return false;
    }

    public boolean updateReportSumFinal(String month, String year, Double monthly_amount, Double yearly_amount) throws SQLException {
        String sql = "UPDATE report SET monthly_amount='" + monthly_amount + "',yearly_amount='" + yearly_amount + "' WHERE month = '" + month + "' and year='" + year + "'";
        Statement st = connection.createStatement();
        st.executeUpdate(sql);
        return false;
    }

    public boolean insertReport(String Date, Double Amount, String Month, String Year, Double monthly_amount) throws SQLException {
        String sql = "INSERT INTO report (date,daily_amount,month,year,monthly_amount,yearly_amount) VALUES ('" + Date + "','" + Amount + "','" + Month + "','" + Year + "','" + monthly_amount + "','0')";
        Statement st = connection.createStatement();
        st.executeUpdate(sql);
        return false;
    }

    public boolean getMonthlyTotal(String month, String year) throws SQLException {
        String sql = "SELECT SUM(daily_amount) FROM report WHERE MONTH='" + month + "' AND YEAR='" + year + "'";
        Statement st = connection.createStatement();
        rs = st.executeQuery(sql);
        return false;
    }

    public boolean getYearlyTotal(String year) throws SQLException {
        String sql = "SELECT SUM(DISTINCT monthly_amount)FROM report WHERE YEAR='" + year + "'";
        Statement st = connection.createStatement();
        rs = st.executeQuery(sql);
        return false;
    }

}
