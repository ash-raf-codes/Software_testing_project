package org.jfree.chart.demo2.DBChart;

import org.jfree.DBChartSENG275.Entry;
import org.jfree.DBChartSENG275.PieChartData;
import org.jfree.DBChartSENG275.PieChartDataDAO;
import org.jfree.data.general.DefaultPieDataset;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


// TASK: some of the test code will go in here

class PieChartDataTest {

    private PieChartDataDAO dao;
    private PieChartData pieChartData;
    private DefaultPieDataset defaultPieDataset;


    //next 2 tests are written by mocking a DAO and editing what ash started - Myfanwy
    @Test
    void testWithMocksOneValuePerCountry(){
        dao = mock(PieChartDataDAO.class); //mock the dao
        Entry eTest = new Entry("Canada", 100.0); //one entry to put into the dao and list

        when(dao.getData()).thenReturn(List.of(eTest)); //return a list as the dao should
        defaultPieDataset = new DefaultPieDataset();
        defaultPieDataset.setValue(eTest.getCountry(), eTest.getValue()); //set up the DefaultPieDataSet

        DefaultPieDataset actualResults = new DefaultPieDataset();
        actualResults = pieChartData.createDataset(dao.getData());

        assertEquals(actualResults,defaultPieDataset);
    }

    @Test
    void testWithMocksOneValuePerCountrySimplified(){
        dao = mock(PieChartDataDAO.class);
        when(dao.getData()).thenReturn(List.of(new Entry("Canada", 100.0)));
        defaultPieDataset = new DefaultPieDataset();
        defaultPieDataset.setValue("Canada", 100.0);
        assertEquals(pieChartData.createDataset(dao.getData()),defaultPieDataset);
    }

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

    // following Tests written by S M Ashraf, got idea from Myfanwy's test class

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

    //Minh's test, checking an empty list/dataset
    @Test
    void TestCreateDatasetWithEmpty() {
        ArrayList<Entry> empty = new ArrayList<Entry>();
        pieChartData = mock(PieChartData.class);

        defaultPieDataset = new DefaultPieDataset();
        assertEquals(pieChartData.createDataset(empty), defaultPieDataset);

    }



}

