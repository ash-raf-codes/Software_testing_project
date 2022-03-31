package org.jfree.chart.demo2;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BarChartDataDAO {
    public List<org.jfree.chart.demo2.Entry> getData() {
        Connection conn;
        ArrayList<org.jfree.chart.demo2.Entry> wholeDataset = new ArrayList<>();
        try {
            String url = "jdbc:sqlite:chinook.db";
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");

            Statement statement = conn.createStatement( );
            ResultSet resultSet = statement.executeQuery("select * from Invoices" );
            while( resultSet.next() ) {
                Entry oneEntry = new Entry(resultSet.getInt("Total"), resultSet.getString("BillingCity"), resultSet.getString("BillingCountry"));
                wholeDataset.add(oneEntry);
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return wholeDataset;
    }
}
