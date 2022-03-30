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


// TASK: some of the test code will go in here

    public class PieChartDataTestAshraf {
        // Tests written by S M Ashraf, got idea from Myfanwy's test class

        private PieChartData pieChartData;
        private DefaultPieDataset defaultPieDataset;
        private PieChartDataDAO dao;

        //test when the value for each country is 0 - Ash
        @Test
        void valueOfZeroPerCountry() {
            Entry e1 = new Entry("Bulgaria", 0);
            Entry e2 = new Entry("New Zealand", 0);
            Entry e3 = new Entry("USA", 0);
            List<Entry> list = new ArrayList<>();
            list.add(e1);
            list.add(e2);
            list.add(e3);

            dao = mock(PieChartDataDAO.class);
            when(dao.getData()).thenReturn(list);

            defaultPieDataset = new DefaultPieDataset();

            defaultPieDataset.setValue(e1.getCountry(), e1.getValue());
            defaultPieDataset.setValue(e2.getCountry(), e2.getValue());
            defaultPieDataset.setValue(e3.getCountry(), e3.getValue());
            assertThat(pieChartData.createDataset(dao.getData())).isEqualTo(defaultPieDataset);

        }

        //test when values are large negatives - Ash
        @Test
        void negativeValuesPerCountry() {
            Entry e1 = new Entry("Canada", -200000000.9844);
            Entry e2 = new Entry("USA", -12314562.0089);
            Entry e3 = new Entry("Azerbaijan", -999999999.3342);
            List<Entry> list = new ArrayList<>();
            list.add(e1);
            list.add(e2);
            list.add(e3);

            dao = mock(PieChartDataDAO.class);
            when(dao.getData()).thenReturn(list);

            defaultPieDataset = new DefaultPieDataset();

            defaultPieDataset.setValue(e1.getCountry(), e1.getValue());
            defaultPieDataset.setValue(e2.getCountry(), e2.getValue());
            defaultPieDataset.setValue(e3.getCountry(), e3.getValue());
            assertThat(pieChartData.createDataset(dao.getData())).isEqualTo(defaultPieDataset);
        }
    }


