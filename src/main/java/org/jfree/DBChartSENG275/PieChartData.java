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

// This is from the readChinook method{
// //String url = "jdbc:sqlite:chinook.db";
////        conn = getConn(url);                            //Get Connection
////        resultSet = getResultSet(resultSet, conn);      //Get ResultSet based on successful Connection
////        createDataset(dataset, resultSet, conn);        //Sorting and store the result in dataset.
// }

//Create a separate fields for DefaultPieDataset, ResultSet and Connection class
//    private DefaultPieDataset dataset;
//    private ResultSet resultSet;
//    private Connection conn;
//
//    //Constructor for mocking
//    public PieChartData(ResultSet resultSet, Connection conn){
//        this.dataset = new DefaultPieDataset();
//        this.resultSet = resultSet;
//        this.conn = conn;
//    }
//
//    // Constructor when using the database
//    public PieChartData(){
//        this.dataset = new DefaultPieDataset();
//        this.resultSet = null;
//        this.conn = null;
//    }
//
//    /*
//    Param: String
//    Return: Connection
//    -This method take a String as parameter to create and return a connection
//     based on the url in that String
//     */
//    public void getConn(){
//        try{
//            if(conn == null)
//                conn = DriverManager.getConnection("jdbc:sqlite:chinook.db");
//            else
//                return;
////            Connection connection = null;
////            return connection = DriverManager.getConnection(url);
//        }catch (SQLException e){
//
//        }
//    }
//
//    /*
//    Param: ResultSet, Connection
//    Return: resultSet after connection has been established
//    - This method create and return a resultSet after connecting to the database
//    */
//    public void getResultSet(){
//        try{
//            if(resultSet == null) {
//                Statement statement = conn.createStatement();
//                resultSet = statement.executeQuery("select * from Invoices");
//            }
//            else
//                return;
////            Statement statement = conn1.createStatement();
////            return resultSet = statement.executeQuery("select * from Invoices" );
//        }catch (SQLException e){
//
//        }
//    }
