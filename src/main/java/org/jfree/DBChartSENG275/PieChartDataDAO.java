package org.jfree.DBChartSENG275;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//Myfanwy wrote this, with lots of help from Hint 1
//an actual DAO to remove all connectivity to the database to here
//contains only one method, which retrieves all needed Entries from the DB and puts them into a List
//this is largely code pulled from the original project, if I am remembering correctly, I just added more documentation because this is new and confusing for me
public class PieChartDataDAO {
    public List<Entry> getData() {
        Connection conn;
        ArrayList<Entry> wholeDataset = new ArrayList<>();
        try {
            //this section connects to the database
            // db parameters
            String url = "jdbc:sqlite:chinook.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established."); // not needed but helpful

            //grab everything from the DB
            Statement statement = conn.createStatement( );
            ResultSet resultSet = statement.executeQuery("select * from Invoices" );
            while( resultSet.next() ) { // note, no aggregation is happening in here, only adding to the list
                Entry oneEntry = new Entry(resultSet.getString("BillingCountry"), resultSet.getDouble("Total"));
                wholeDataset.add(oneEntry);
            }
            conn.close();
        } catch (SQLException e) { //just the error message
            System.out.println(e.getMessage());
        }
        return wholeDataset;
    }
}
