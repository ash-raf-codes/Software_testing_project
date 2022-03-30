package org.jfree.DBChartSENG275;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import java.sql.*;

public class PieChartData {


    /*
    Param: DefaultPieDataset, ResultSet, Connection
    Return: Return the dataset containing inputs from resultSet
    -This method will read the resultSet and use its inputs to create a dataset that will
     represent the Pie Chart based on the database
    */
    public static void createDataset(DefaultPieDataset dataset, Connection conn, ResultSet resultSet){
        try {
            while (resultSet.next()) {
                // country:  Category
                // val: Categorical value. On a pie chart, the size of the slice of a category
                //      depends on val.
                String country = resultSet.getString("BillingCountry");
                Double val = resultSet.getDouble("Total");

                //If the dataset already contain the category (or country), then
                //update by adding the new val to the current val in dataset
                if (dataset.getKeys().contains(country)) {
                    val += (double) dataset.getValue(country);
                }

                // Update the dataset with country and val
                dataset.setValue(country, val);
            }
            //Disconnection
            //conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // This main method will call the remaining methods in this file
    // to create the dataset and produce the pie chart. Previously,
    // everything is implemented inside this function. For testability
    // purpose, we create several smaller methods and use readChinookDataset()
    // as a wrapper that simply call other methods, without changing the behavior.
    public static PieDataset readChinookDataset() {
        //initialize dataset
        DefaultPieDataset dataset = new DefaultPieDataset();


        Connecting connection = new Connecting();
        Connection conn = connection.getConn();
        ResultSet resultSet = connection.getResultSet();
        createDataset(dataset, conn, resultSet);
        connection.closeConn();

        //return dataset
        return dataset;
    }
}

