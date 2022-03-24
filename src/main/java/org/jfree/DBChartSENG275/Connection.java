package org.jfree.DBChartSENG275;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.Statement;

public class Connection {
    Connection conn;

    public Connection(){
        this.conn = null;
    }
    public Connection(Connection conn){
        this.conn = conn;
    }

    public Statement Connecting(){
        DefaultPieDataset dataset = new DefaultPieDataset( );
        try {
            // db parameters
            String url = "jdbc:sqlite:chinook.db";
            // create a connection to the database
            this.conn = (Connection) DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");
            return this.conn.createStatement( );


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void extracted() {
        this.conn.close();
    }


}
