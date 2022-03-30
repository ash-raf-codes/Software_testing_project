package org.jfree.chart.demo2.DBChart;

import org.jfree.DBChartSENG275.Entry;
import org.jfree.DBChartSENG275.PieChartData;
import org.jfree.data.general.DefaultPieDataset;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;


// TASK: some of the test code will go in here

class PieChartDataTest {

    private PieChartData pieChartData;
    private DefaultPieDataset defaultPieDataset;

    //test when there is only one value per country - Myfanwy
    @Test
    void oneValuePerCountry() {
        Entry e1 = new Entry("Canada", 2);
        Entry e2 = new Entry("NL", 3);
        Entry e3 = new Entry("USA", 5);
        List<Entry> list = new ArrayList<>();
        list.add(e1);
        list.add(e2);
        list.add(e3);

        defaultPieDataset = new DefaultPieDataset();

        defaultPieDataset.setValue(e1.getCountry(), e1.getValue());
        defaultPieDataset.setValue(e2.getCountry(), e2.getValue());
        defaultPieDataset.setValue(e3.getCountry(), e3.getValue());

        assertEquals(pieChartData.createDataset(list), defaultPieDataset);
    }

    //test when there are 3 entries for the same country - Myfanwy
    @Test
    void manyValuesPerCountry() {
        Entry e1 = new Entry("Canada", 2);
        Entry e2 = new Entry("Canada", 3);
        Entry e3 = new Entry("Canada", 5);
        List<Entry> list = new ArrayList<>();
        list.add(e1);
        list.add(e2);
        list.add(e3);

        defaultPieDataset = new DefaultPieDataset();

        defaultPieDataset.setValue(e1.getCountry(), e1.getValue() + e2.getValue() + e3.getValue());

        assertEquals(pieChartData.createDataset(list), defaultPieDataset);
    }





}

