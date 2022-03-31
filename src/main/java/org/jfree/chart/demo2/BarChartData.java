package org.jfree.chart.demo2;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;



import java.util.ArrayList;
import java.util.List;

public class BarChartData {

    public static DefaultCategoryDataset createDataSet(List<Entry> DBEntries){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i < DBEntries.size(); i++) {


            double value = DBEntries.get(i).getValue();

            String rowkey    =   DBEntries.get(i).getRowkey();
            String columnkey =   DBEntries.get(i).getColumnkey();

            if(value!= 0 || columnkey != null || rowkey!= null ) {
                if (dataset.getColumnKeys().contains(rowkey)) {
                    value += (double) dataset.getValue(rowkey, columnkey);
                }
                dataset.addValue(value, rowkey, columnkey);
            }

        }
        return dataset;
    }

    public static CategoryDataset readChinookDataset() {
        //calling this here, this is the actual connection to the DB I will be passing into createDataset
        BarChartDataDAO dao = new BarChartDataDAO();
        ArrayList<org.jfree.chart.demo2.Entry> invoices = (ArrayList<org.jfree.chart.demo2.Entry>) dao.getData();
        DefaultCategoryDataset dataset = null;
        dataset = createDataSet(invoices);

        return dataset;
    }
}
