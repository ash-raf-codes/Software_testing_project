package org.jfree.chart.demo2;

public class Entry {
    private double value;
    private String rowkey;
    private String columnkey;

    public Entry(double value, String rowkey, String columnkey) {
        this.value = value;
        this.rowkey = rowkey;
        this.columnkey = columnkey;
    }

    public double getValue() {
        return value;
    }

    public String getRowkey() {
        return rowkey;
    }

    public String getColumnkey() {
        return columnkey;
    }
}
