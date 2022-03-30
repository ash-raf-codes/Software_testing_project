package org.jfree.chart.demo2.DBChart;
import org.jfree.DBChartSENG275.Entry;
import org.jfree.DBChartSENG275.PieChartData;
import org.jfree.DBChartSENG275.PieChartDataDAO;
import org.jfree.data.general.DefaultPieDataset;
import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;



public class PieChartDataTestJasraj {

    private PieChartDataDAO dao;
    private PieChartData pieChartData;
    private DefaultPieDataset temp;



    @Test
    void test_negative_numbers_integers(){

        Entry one = new Entry("Canada", -1);
        Entry two = new Entry("Germany", -1000);
        Entry three = new Entry("India", -50);


        List<Entry> list1 = new ArrayList<>();

        list1.add(one);
        list1.add(two);
        list1.add(three);

        dao = mock(PieChartDataDAO.class);

        when(dao.getData()).thenReturn(list1);

      temp = new DefaultPieDataset();

      temp.setValue(one.getCountry(), one.getValue());
       temp.setValue(two.getCountry(), two.getValue());
        temp.setValue(three.getCountry(), three.getValue());
        assertThat(pieChartData.createDataset(dao.getData())).isEqualTo(temp);
    }
}
