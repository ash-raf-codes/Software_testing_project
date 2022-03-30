package org.jfree.chart.demo2.DBChart;

import org.jfree.DBChartSENG275.Entry;
import org.jfree.DBChartSENG275.PieChartData;
import org.jfree.DBChartSENG275.PieChartDataDAO;
import org.jfree.data.general.DefaultPieDataset;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


// TASK: some of the test code will go in here

class PieChartDataTest {

    private PieChartDataDAO dao;
    private PieChartData data;
    private DefaultPieDataset res;


    //test1 & test2 are written by mocking a DAO and editing what ash started - Myfanwy
    @Test
    void test1(){
        dao = mock(PieChartDataDAO.class); //mock the dao
        Entry eTest = new Entry("Canada", 100.0); //one entry to put into the dao and list

        when(dao.getData()).thenReturn(List.of(eTest)); //return a list as the dao should
        res = new DefaultPieDataset();
        res.setValue(eTest.getCountry(), eTest.getValue()); //set up the DefaultPieDataSet

        DefaultPieDataset actualResults = new DefaultPieDataset();
        actualResults = data.createDataset(dao.getData());

        assertEquals(actualResults,res);
    }

    @Test
    void test2(){
        dao = mock(PieChartDataDAO.class);
        when(dao.getData()).thenReturn(List.of(new Entry("Canada", 100.0)));
        res = new DefaultPieDataset();
        res.setValue("Canada", 100.0);
        assertEquals(data.createDataset(dao.getData()),res);
    }

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

    //just making sure its still correct with doubles - Myfanwy
    @Test
    void testDoublesRatherThanInts() {
        Entry e1 = new Entry("Canada", 2.349857);
        Entry e2 = new Entry("NL", 3.5);
        Entry e3 = new Entry("USA", 54.5454);
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

    //just making sure its still correct with very large number - Myfanwy
    @Test
    void testLargeNumbers() {
        Entry e1 = new Entry("Canada", 2675765765.349857);
        Entry e2 = new Entry("NL", 30000.5);
        Entry e3 = new Entry("USA", 54545654);
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


}

