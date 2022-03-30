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
}
