package org.jfree.DBChartSENG275;
import java.sql.*;


public class Connecting {


    public static Connection connect(Connection conn) {
        try {
        // db parameters
        String url = "jdbc:sqlite:chinook.db";
        // create a connection to the database
        conn = DriverManager.getConnection(url);

        System.out.println("Connection to SQLite has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    public static void close(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static ResultSet read(Connection conn) throws SQLException {
        Statement statement = conn.createStatement();

        ResultSet resultSet = statement.executeQuery("select * from Invoices");
        return resultSet;
    }
    /**
     * @param args the command line arguments
     */
    public static ResultSet main(String[] args) throws SQLException {
        Connection conn = null;
////      db parameters
//        String url = "jdbc:sqlite:chinook.db";
//        // create a connection to the database
//        conn = DriverManager.getConnection(url);
        ResultSet resultSet = null;
        conn = connect(conn);
        resultSet = read(conn);
        close(conn);
        return resultSet;
    }



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
