package org.jfree.DBChartSENG275;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import java.sql.*;

public class PieChartData {
    /**
     * Readings in a dataset from an existing DB
     * @return A sample dataset.
     * SENG 275 Project Tasks:
     * We need to refactor this to pull out the code that creates our database;
     * Use mocks so we can test this method without using the database!
     * We need to test the code in here that calculates invoices per country - does it work?
     * We should write code for testing all the CRUD operations with the database!
     * We should write code to test what happens if the database is empty.
     */
    protected static PieDataset readChinookDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset( );
        /* Create SQLite Database Connection */
        Connection conn = null;
        try {
            Statement statement = Connection.Connecting();

            ResultSet resultSet = statement.executeQuery("select * from Invoices" );
            while( resultSet.next() ) {
                String country = resultSet.getString("BillingCountry");
                Double val = resultSet.getDouble("Total");
                if (dataset.getKeys().contains(country)) {
                    val += (double) dataset.getValue(country);
                }
                dataset.setValue(country, val);
            }

           // conn.close();
            Connection.extracted();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dataset;
    }
}

