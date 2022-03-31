package org.jfree.chart.demo2;

public class Entry {
    private int value;
    private String rowkey;
    private String columnkey;

    public Entry(int value, String rowkey, String columnkey) {
        this.value = value;
        this.rowkey = rowkey;
        this.columnkey = columnkey;
    }

    public int getValue() {
        return value;
    }

    public String getRowkey() {
        return rowkey;
    }

    public String getColumnkey() {
        return columnkey;
    }
}
