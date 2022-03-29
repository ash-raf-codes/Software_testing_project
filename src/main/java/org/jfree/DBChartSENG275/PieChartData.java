package org.jfree.DBChartSENG275;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import java.sql.*;

public class PieChartData {

    //Create a separate fields for DefaultPieDataset, ResultSet and Connection class
    private static DefaultPieDataset dataset;
    private static ResultSet resultSet;
    private static Connection conn;

    //Constructor
    public PieChartData(DefaultPieDataset dataset, ResultSet resultSet, Connection conn){
        this.dataset = dataset;
        this.resultSet = resultSet;
        this.conn = conn;
    }

    /*
    Param: String
    Return: Connection
    -This method take a String as parameter to create and return a connection
     based on the url in that String
     */
    public static Connection getConn(String url){
        try{
            Connection connection = null;
            return connection = DriverManager.getConnection(url);
        }catch (SQLException e){

        }
        return null;
    }

    /*
    Param: ResultSet, Connection
    Return: resultSet after connection has been established
    - This method create and return a resultSet after connecting to the database
    */
    public static ResultSet getResultSet(ResultSet resultSet, Connection conn1){
        try{
            Statement statement = conn1.createStatement();
            return resultSet = statement.executeQuery("select * from Invoices" );
        }catch (SQLException e){

        }
        return null;
    }

    /*
    Param: DefaultPieDataset, ResultSet, Connection
    Return: Return the dataset containing inputs from resultSet
    -This method will read the resultSet and use its inputs to create a dataset that will
     represent the Pie Chart based on the database
    */
    public static void createDataset(DefaultPieDataset dataset, ResultSet resultSet, Connection conn){
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
            conn.close();
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
        dataset = new DefaultPieDataset();
        String url = "jdbc:sqlite:chinook.db";

        conn = getConn(url);                            //Get Connection
        resultSet = getResultSet(resultSet, conn);      //Get ResultSet based on successful Connection
        createDataset(dataset, resultSet, conn);        //Sorting and store the result in dataset.

        //return dataset
        return dataset;
    }
}