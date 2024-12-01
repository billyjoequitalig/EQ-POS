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
import java.util.HashMap;

/**
 *
 * @author billy
 */
public class Stocks {

    public static ResultSet ResultSet;
    public static ResultSet rs;
//    private final String Url;
//    private final String Host;
//    private final String Database;
//    private final String Username;
//    private final String Password;
    private int SecId;
    private String Sec;
    DBConnection DBCon = new DBConnection("localhost", "3306", "eqpos", "root", "001995234");
//    public java.sql.Connection DBCon.gettter() = null;

//    public Stocks(String host, String database, String username, String password) {
//        Host = host;
//        Database = database;
//        Username = username;
//        Password = password;
//        Url = "jdbc:mysql://" + Host + ":3306/";
//    }
//
//    public void Open() throws SQLException {
//        DBCon.gettter() = DriverManager.getConnection(Url + Database + "?autoReconnect=true&useSSL=false" + "", Username, Password);
//    }
//
//    // To Close Connection
//    public void Close() throws SQLException {
//        DBCon.gettter().close();
//    }

    public boolean SearchProducts(String Search) throws SQLException {
        String sql = "SELECT products.Product_ID, products.Product, supplier.SupplierName, products.UOM, "
                + "products.Quantity, products.size, category.Category, subcategory.SubCategory, color.Color, "
                + "products.UnitPrice FROM products "
                + "INNER JOIN category ON category.Category_ID = products.Category_ID "
                + "INNER JOIN subcategory ON subcategory.SubCategory_ID = products.SubCategory_ID "
                + "INNER JOIN color ON color.Color_ID = products.Color_ID "
                + "INNER JOIN supplier ON supplier.Supplier_ID = products.Supplier_ID "
                + "WHERE CONCAT(products.Product_ID, products.Product) LIKE '%" + Search + "%'";
        Statement st = DBCon.gettter().createStatement();
        rs = st.executeQuery(sql);
        return false;
    }

    public boolean ReadProducts() throws SQLException {
        String sql = "SELECT products.Product_ID, products.Product, supplier.SupplierName, products.UOM, "
                + "products.Quantity, products.size, category.Category, subcategory.SubCategory, color.Color, "
                + "products.UnitPrice FROM products "
                + "INNER JOIN category ON category.Category_ID = products.Category_ID "
                + "INNER JOIN subcategory ON subcategory.SubCategory_ID = products.SubCategory_ID "
                + "INNER JOIN color ON color.Color_ID = products.Color_ID "
                + "INNER JOIN supplier ON supplier.Supplier_ID = products.Supplier_ID "
                + "ORDER BY products.Product ASC";
        Statement st = DBCon.gettter().createStatement();
        rs = st.executeQuery(sql);
        return false;
    }

    public boolean ReadSection() throws SQLException {
        String sql = "SELECT subcategory.SubCategory_ID, subcategory.SubCategory "
                + "FROM subcategory WHERE subcategory.Category_ID = 2 ";
        Statement st = DBCon.gettter().createStatement();
        rs = st.executeQuery(sql);
        return false;
    }
    
    public boolean ReadAccessories() throws SQLException {
        String sql = "SELECT subcategory.SubCategory_ID, subcategory.SubCategory "
                + "FROM subcategory WHERE subcategory.Category_ID = 1 ";
        Statement st = DBCon.gettter().createStatement();
        rs = st.executeQuery(sql);
        return false;
    }

    public boolean ReadCategory() throws SQLException {
        String sql = "SELECT * FROM category";
        Statement st = DBCon.gettter().createStatement();
        rs = st.executeQuery(sql);
        return false;
    }

    public boolean ReadSupplier() throws SQLException {
        String sql = "SELECT Supplier_ID, SupplierName FROM supplier";
        Statement st = DBCon.gettter().createStatement();
        rs = st.executeQuery(sql);
        return false;
    }
    
    public boolean ReadSubCategory(String SubCategory) throws SQLException {
        String sql = "SELECT Category_ID "
                + "FROM subcategory WHERE SubCategory = '" + SubCategory + "'";
        Statement st = DBCon.gettter().createStatement();
        rs = st.executeQuery(sql);
        return false;
    }
    
    public boolean ReadSubCategorySort(String SubCategory_ID) throws SQLException {
        String sql = "SELECT products.Product_ID, products.Product, supplier.SupplierName, products.UOM, "
                + "products.Quantity, products.size, category.Category, subcategory.SubCategory, color.Color, "
                + "products.UnitPrice FROM products "
                + "INNER JOIN category ON category.Category_ID = products.Category_ID "
                + "INNER JOIN subcategory ON subcategory.SubCategory_ID = products.SubCategory_ID "
                + "INNER JOIN color ON color.Color_ID = products.Color_ID "
                + "INNER JOIN supplier ON supplier.Supplier_ID = products.Supplier_ID "
                + "WHERE products.SubCategory_ID = '" + SubCategory_ID + "'";
        Statement st = DBCon.gettter().createStatement();
        rs = st.executeQuery(sql);
        return false;
    }
    
    public boolean SortProduct(String Category_ID) throws SQLException {
        String sql = "SELECT products.Product_ID, products.Product, supplier.SupplierName, products.UOM, "
                + "products.Quantity, products.size, category.Category, subcategory.SubCategory, color.Color, "
                + "products.UnitPrice FROM products "
                + "INNER JOIN category ON category.Category_ID = products.Category_ID "
                + "INNER JOIN subcategory ON subcategory.SubCategory_ID = products.SubCategory_ID "
                + "INNER JOIN color ON color.Color_ID = products.Color_ID "
                + "INNER JOIN supplier ON supplier.Supplier_ID = products.Supplier_ID "
                + "WHERE products.Category_ID = '" + Category_ID + "'";
        Statement st = DBCon.gettter().createStatement();
        rs = st.executeQuery(sql);
        return false;
    }
    
    public boolean RefreshSubCategory(String Category_ID) throws SQLException {
        String sql = "SELECT Category_ID"
                + "FROM subcategory WHERE Category_ID = '" + Category_ID + "'";
        Statement st = DBCon.gettter().createStatement();
        rs = st.executeQuery(sql);
        return false;
    }
    
    public boolean InsertSubCategory(String Category_ID, String SubCategory) throws SQLException {
        String sql = "INSERT INTO subcategory (Category_ID, SubCategory) VALUES ('" + Category_ID + "', '" + SubCategory + "')";
        Statement st = DBCon.gettter().createStatement();
        st.executeUpdate(sql);
        return false;
    }

    public boolean SelectSubCategoryExist(String SubCategory) throws SQLException {
        String sql = "SELECT SubCategory_ID, SubCategory "
                + "FROM subcategory WHERE SubCategory = '" + SubCategory + "'";
        Statement st = DBCon.gettter().createStatement();
        rs = st.executeQuery(sql);
        return false;
    }

    public boolean SelectColorAccessories() throws SQLException {
        String sql = "SELECT color.Color_ID, color.Color FROM color WHERE color.Category_ID = 1";
        Statement st = DBCon.gettter().createStatement();
        rs = st.executeQuery(sql);
        return false;
    }

    public boolean SelectColorSection() throws SQLException {
        String sql = "SELECT color.Color_ID, color.Color FROM color WHERE color.Category_ID = 2";
        Statement st = DBCon.gettter().createStatement();
        rs = st.executeQuery(sql);
        return false;
    }

    public boolean SelectProductExist(String Product, String Size, String UOM, String Color, String Product_ID) throws SQLException {
        String sql = "SELECT * FROM Products "
                + "INNER JOIN color ON products.Color_ID = color.Color_ID "
                + "WHERE (Product = '" + Product + "' AND Size = '" + Size + "') AND (UOM = '" + UOM + "' AND color.Color_ID = '" + Color + "') AND Product_ID != '" + Product_ID + "'";
        Statement st = DBCon.gettter().createStatement();
        rs = st.executeQuery(sql);
        return false;
    }

    public boolean SelectMaxID() throws SQLException {
        String sql = "SELECT MAX(Product_ID) FROM Products";
        Statement st = DBCon.gettter().createStatement();
        rs = st.executeQuery(sql);
        return false;
    }

    public boolean InsertProduct(String Product_ID, String Supplier_ID, String Product, String Size, String Quantity, String UnitPrice, String UOM, String Category_ID, String SubCategory_ID, String Color_ID, String Color) throws SQLException {
        String sql = "INSERT INTO products (Product_ID, Supplier_ID, Product, Size, "
                + "Quantity, UnitPrice, UOM, Category_ID, SubCategory_ID, Color_ID, Description) "
                + "VALUES ('" + Product_ID + "','" + Supplier_ID + "','" + Product + "','" + Size + "', "
                + "'" + Quantity + "','" + UnitPrice + "','" + UOM + "'," + Category_ID + ", "
                + "" + SubCategory_ID + ",'" + Color_ID + "', CONCAT('" + Product + "', '" + ", Size: " + "', '" + Size + "', '" + ", Color: " + "', '" + Color + "'))";
        Statement st = DBCon.gettter().createStatement();
        st.executeUpdate(sql);
        return false;
    }

    public boolean DeleteProduct(String Product_ID) throws SQLException {
        String sql = "DELETE FROM products WHERE Product_ID = '" + Product_ID + "'";
        Statement st = DBCon.gettter().createStatement();
        st.executeUpdate(sql);
        return false;
    }

    public boolean DeleteSubCategory(String SubCategory_ID) throws SQLException {
        String sql = "DELETE FROM subcategory WHERE SubCategory_ID = '" + SubCategory_ID + "'";
        Statement st = DBCon.gettter().createStatement();
        st.executeUpdate(sql);
        return false;
    }
    
    public boolean UpdateProducts(String Product_ID, String Product, String Supplier_ID, String UOM, String Quantity, String Size, String Category_ID, String SubCategory_ID, String Color_ID, String UnitPrice, String Color) throws SQLException {
        String sql = "UPDATE products SET Product='" + Product + "',Supplier_ID='" + Supplier_ID + "', "
                + "UOM='" + UOM + "', Quantity = '" + Quantity + "',Size='" + Size + "', "
                + "Category_ID =" + Category_ID + ", SubCategory_ID =" + SubCategory_ID + ", "
                + "Color_ID='" + Color_ID + "', UnitPrice='" + UnitPrice + "', "
                + "Description=CONCAT('" + Product + "', '" + ", Size: " + "', '" + Size + "', '" + ", Color: " + "', '" + Color + "') WHERE Product_ID ='" + Product_ID + "'";
        Statement st = DBCon.gettter().createStatement();
        st.executeUpdate(sql);
        return false;
    }
    
    public boolean NewStocksLogs(String user, String Product_ID, String Product_Name, String Supplier_ID, String UOM, String Size, String Category_ID, String SubCategory_ID, String Color_ID, String UnitPrice, String Quantity) throws SQLException {
        String sql = "INSERT INTO newstockslogs (user, Product_ID, Supplier_ID, Product_Name, "
                + "Description, UnitOfMeasure, Quantity, Size, Category_ID, SubCategory_ID, Color_ID, Unit_Price, Time, Date, action) "
                + "VALUES ('" + user + "','" + Product_ID + "','" + Supplier_ID + "','" + Product_Name + "', "
                + "CONCAT('" + Product_Name + "', '" + ", Size: " + "', '" + Size + "', '" + ", Color: " + "', '" + Color_ID + "'), "
                + "'" + UOM + "', '" + Quantity + "', '" + Size + "', '" + Category_ID + "', '" + SubCategory_ID + "','" + Color_ID + "','" + UnitPrice + "',CURTIME(),CURDATE(),'ADD')";
        Statement st = DBCon.gettter().createStatement();
        st.executeUpdate(sql);
        return false;
    }
    
    public boolean UpdateStocksLogs(String user, String Product_ID, String Product_Name, String Supplier_ID, String UOM, String Size, String Category_ID, String SubCategory_ID, String Color_ID, String UnitPrice, String Quantity) throws SQLException {
        String sql = "INSERT INTO newstockslogs (user, Product_ID, Product_Name, Supplier_ID, "
                + "Description, UnitOfMeasure, Quantity, Size, Category_ID, SubCategory_ID, Color_ID, "
                + "Unit_Price, Time, Date, action) "
                + "VALUES ('" + user + "','" + Product_ID + "','" + Product_Name + "','" + Supplier_ID + "', "
                + "CONCAT('" + Product_Name + "', '" + ", Size: " + "', '" + Size + "', '" + ", Color: " + "', '" + Color_ID + "'), "
                + "'" + UOM + "','" + Quantity + "','" + Size + "','" + Category_ID + "','" + SubCategory_ID + "','" + Color_ID + "','" + UnitPrice + "',CURTIME(),CURDATE(),'UPDATE')";
        Statement st = DBCon.gettter().createStatement();
        st.executeUpdate(sql);
        return false;
    }
    
    public boolean DeleteStocksLogs(String user, String Product_ID, String Product_Name, String Supplier_ID, String UOM, String Size, String Category_ID, String SubCategory_ID, String Color_ID, String UnitPrice, String Quantity) throws SQLException {
        String sql = "INSERT INTO newstockslogs (user, Product_ID, Product_Name, Supplier_ID, "
                + "Description, UnitOfMeasure, Quantity, Size, Category_ID, SubCategory_ID, Color_ID, "
                + "Unit_Price, Time, Date, action) "
                + "VALUES ('" + user + "','" + Product_ID + "','" + Product_Name + "','" + Supplier_ID + "', "
                + "CONCAT('" + Product_Name + "', '" + ", Size: " + "', '" + Size + "', '" + ", Color: " + "', '" + Color_ID + "'), "
                + "'" + UOM + "','" + Quantity + "','" + Size + "','" + Category_ID + "','" + SubCategory_ID + "','" + Color_ID + "','" + UnitPrice + "',CURTIME(),CURDATE(),'DELETE')";
        Statement st = DBCon.gettter().createStatement();
        st.executeUpdate(sql);
        return false;
    }
    
    public boolean QuantitySum(String Product_ID, String Quantity, int AddQuantity) throws SQLException {
        String sql = "UPDATE products SET Quantity = '" + Quantity + "' + '" + AddQuantity + "' WHERE Product_ID = '" + Product_ID + "' ";
        Statement st = DBCon.gettter().createStatement();
        st.executeUpdate(sql);
        return false;
    }
    
    public boolean QuantitySubtract(String Product_ID, String Quantity, String AddQuantity) throws SQLException {
        String sql = "UPDATE products SET Quantity = '" + Quantity + "' - '" + AddQuantity + "' WHERE Product_ID = '" + Product_ID + "' ";
        Statement st = DBCon.gettter().createStatement();
        st.executeUpdate(sql);
        return false;
    }
}
