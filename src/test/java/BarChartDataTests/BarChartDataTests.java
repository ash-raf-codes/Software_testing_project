package BarChartDataTests;

import org.jfree.chart.demo2.Entry;
import org.jfree.chart.demo2.BarChartData;
import org.jfree.chart.demo2.BarChartDataDAO;

import org.jfree.data.category.DefaultCategoryDataset;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BarChartDataTests {

    private BarChartData barChartData;
    private BarChartDataDAO dao;
    private DefaultCategoryDataset dataset;


    // The first 4 tests are written by S M Ashraf
    @Test
    void testWithOneCountryAndManyCities() {
        dao = mock(BarChartDataDAO.class);
        when(dao.getData()).thenReturn(List.of(new Entry(25.22, "Vancouver", "Canada"),
                new Entry(27.22, "Victoria", "Canada"), new Entry(29.22, "Toronto", "Canada")));
        dataset = new DefaultCategoryDataset();
        dataset.addValue(25.22,"Vancouver","Canada");
        dataset.addValue(27.22,"Victoria","Canada");
        dataset.addValue(29.22,"Toronto","Canada");

        assertThat(barChartData.createDataSet(dao.getData())).isEqualTo(dataset);
    }

    @Test
    void testWithValueEqualsZero() {
        dao = mock(BarChartDataDAO.class);
        when(dao.getData()).thenReturn(List.of(new Entry(0, "Vancouver", "Canada")));
        dataset = new DefaultCategoryDataset();

        assertThat(barChartData.createDataSet(dao.getData())).isEqualTo(dataset);
    }

    @Test
    void testWithNullCity() {
        dao = mock(BarChartDataDAO.class);
        when(dao.getData()).thenReturn(List.of(new Entry(25.22, null, "Canada")));
        dataset = new DefaultCategoryDataset();

        assertThat(barChartData.createDataSet(dao.getData())).isEqualTo(dataset);
    }

    @Test
    void testWithNullCountry() {
        dao = mock(BarChartDataDAO.class);
        when(dao.getData()).thenReturn(List.of(new Entry(36.33, "Vancouver", null)));
        dataset = new DefaultCategoryDataset();

        assertThat(barChartData.createDataSet(dao.getData())).isEqualTo(dataset);
    }


}
