package org.jfree.DBChartSENG275;
import org.jfree.data.general.DefaultPieDataset;

import java.sql.*;


public class Connecting {

    //private DefaultPieDataset dataset;
    private ResultSet resultSet;
    private Connection conn;

    //Constructor for mocking
    public Connecting(ResultSet resultSet, Connection conn){
        //this.dataset = new DefaultPieDataset();
        this.resultSet = resultSet;
        this.conn = conn;
    }

    // Constructor when using the database
    public Connecting(){
        //this.dataset = new DefaultPieDataset();
        this.resultSet = null;
        this.conn = null;
    }

    /*
    Param: nothing
    Return: Connection
    -This method take a String as parameter to create and return a connection
     based on the url in that String
     */
    public Connection getConn() {

        try {
            if (conn == null)
                conn = DriverManager.getConnection("jdbc:sqlite:chinook.db");
//            Connection connection = null;
//            return connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
        }
        return this.conn;
    }

    /*
    Param: nothing
    Return: resultSet after connection has been established
    - This method create and return a resultSet after connecting to the database
    */
    public ResultSet getResultSet() {
        try {
            if (this.resultSet == null) {
                Statement statement = conn.createStatement();
                this.resultSet = statement.executeQuery("select * from Invoices");
            }
//            Statement statement = conn1.createStatement();
//            return resultSet = statement.executeQuery("select * from Invoices" );
        } catch (SQLException e) {}

        return this.resultSet;
    }

    /*
    Param: nothing
    Return: nothing
    - This method closes the connection to the database
    */
    public void closeConn() {
        try {
            this.conn.close();
        }
        catch(SQLException e){}
    }


//    public static Connection connect(Connection conn) {
//        try {
//        // db parameters
//        String url = "jdbc:sqlite:chinook.db";
//        // create a connection to the database
//        conn = DriverManager.getConnection(url);
//
//        System.out.println("Connection to SQLite has been established.");
//
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//        return conn;
//    }
//    public static void close(Connection conn) {
//        try {
//            if (conn != null) {
//                conn.close();
//            }
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//    }
//
//    public static ResultSet read(Connection conn) throws SQLException {
//        Statement statement = conn.createStatement();
//
//        ResultSet resultSet = statement.executeQuery("select * from Invoices");
//        return resultSet;
//    }
//    /**
//     * @param args the command line arguments
//     */
//    public static ResultSet main(String[] args) throws SQLException {
//        Connection conn = null;
//////      db parameters
////        String url = "jdbc:sqlite:chinook.db";
////        // create a connection to the database
////        conn = DriverManager.getConnection(url);
//        ResultSet resultSet = null;
//        conn = connect(conn);
//        resultSet = read(conn);
//        close(conn);
//        return resultSet;
//    }
//


//    Connection conn;
//    Statement statement;
//
//    public Connecting(){
//        this.conn = null;
//        this.statement = null;
//    }
//    public Connecting(Connection conn){
//        this.conn = conn;
//        this.statement = null;
//    }
//
//    public void OpenConnection(){
//        DefaultPieDataset dataset = new DefaultPieDataset( );
//        try {
//            // db parameters
//            String url = "jdbc:sqlite:chinook.db";
//            // create a connection to the database
//            this.conn = (Connection) DriverManager.getConnection(url);
//            System.out.println("Connection to SQLite has been established.");
////            return this.conn.createStatement( );
//
//
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//    }
//
//    public void workWithDB() throws SQLException {
//        this.statement = this.conn.createStatement( );
//    }
//
//
//
//    public void closeDB() throws SQLException {
//        this.conn.close();
//    }


}
