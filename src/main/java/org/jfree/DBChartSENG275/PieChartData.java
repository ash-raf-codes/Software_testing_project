package org.jfree.DBChartSENG275;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PieChartData {

//    private static Connecting conn;
//
//    public PieChartData(Connecting conn){
//        this.conn = conn;
//    }

    /* **THIS IS THE OLD DESCRIPTION**
    Param: DefaultPieDataset, ResultSet, Connection
    Return: Return the dataset containing inputs from resultSet
    -This method will read the resultSet and use its inputs to create a dataset that will
     represent the Pie Chart based on the database
    */

    /*
    Param: List of type Entry
    Return: DefaultPieDataset
    - this method will read from a List and turn that into a DefaultPieDataset from which a Pie Chart can be made
    - Myfanwy refactored from the Hint 1 given to ou group
     */
    public static DefaultPieDataset createDataset(List<Entry> allDBEntries){

        //preparing what we return
        DefaultPieDataset filteredDataset = new DefaultPieDataset();
        for (int i = 0; i< allDBEntries.size(); i++) {
            String country = allDBEntries.get(i).getCountry();
            Double value = allDBEntries.get(i).getValue();
            if (filteredDataset.getKeys().contains(country)) {
                value += (double) filteredDataset.getValue(country);
            }
            filteredDataset.setValue(country, value);
        }
        return filteredDataset;

//        return null;



        //our old function, this passed in: (DefaultPieDataset dataset, ResultSet resultSet)
//        try {
//            while (resultSet.next()) {
//                // country:  Category
//                // val: Categorical value. On a pie chart, the size of the slice of a category
//                //      depends on val.
//                String country = resultSet.getString("BillingCountry");
//                Double val = resultSet.getDouble("Total");
//
//                //If the dataset already contain the category (or country), then
//                //update by adding the new val to the current val in dataset
//                if (dataset.getKeys().contains(country)) {
//                    val += (double) dataset.getValue(country);
//                }
//
//                // Update the dataset with country and val
//                dataset.setValue(country, val);
//            }
//            //Disconnection
//            //conn.close();
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
    }

    // This main method will call the remaining methods in this file
    // to create the dataset and produce the pie chart. Previously,
    // everything is implemented inside this function. For testability
    // purpose, we create several smaller methods and use readChinookDataset()
    // as a wrapper that simply call other methods, without changing the behavior.
    public static PieDataset readChinookDataset() {
        //calling this here, this is the actual connection to the DB I will be passing into createDataset
        PieChartDataDAO dao = new PieChartDataDAO();
        ArrayList<Entry> invoices = (ArrayList<Entry>) dao.getData();
        DefaultPieDataset dataset = null;
        dataset = createDataset(invoices);


        //the old code, using Connecting.java and
//        //initialize dataset
//        DefaultPieDataset dataset = new DefaultPieDataset();
//        if(conn == null)
//            conn = new Connecting();
//        conn.getConn();
//        ResultSet resultSet = conn.getResultSet();
//        createDataset(dataset, resultSet);
//        conn.closeConn();
//
//        //return dataset
        return dataset;
    }
}

