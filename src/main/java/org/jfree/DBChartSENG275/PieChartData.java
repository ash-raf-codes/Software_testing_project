package org.jfree.DBChartSENG275;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PieChartData {

    /*
    Param: List of type Entry
    Return: DefaultPieDataset
    - this method will read from a List and turn that into a DefaultPieDataset from which a Pie Chart can be made
    - Myfanwy refactored from the Hint 1 given to our group
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
    }

    /* This main method will call the remaining methods in this file
       to create the dataset and produce the pie chart. Previously,
       everything is implemented inside this function. For testability
       purpose, we create several smaller methods and use readChinookDataset()
       as a wrapper that simply call other methods, without changing the behavior.
    */
    public static PieDataset readChinookDataset() {
        //calling this here, this is the actual connection to the DB I will be passing into createDataset
        PieChartDataDAO dao = new PieChartDataDAO();
        ArrayList<Entry> invoices = (ArrayList<Entry>) dao.getData();
        DefaultPieDataset dataset = null;
        dataset = createDataset(invoices);

        return dataset;
    }
}

