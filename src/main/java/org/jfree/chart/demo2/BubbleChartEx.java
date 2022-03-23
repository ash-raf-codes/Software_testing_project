package org.jfree.chart.demo2;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYBubbleRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.DefaultXYZDataset;
import org.jfree.data.xy.XYZDataset;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;


public class BubbleChartEx extends JFrame {

    public BubbleChartEx() {

        initUI();
    }

    private void initUI() {

        XYZDataset dataset = createDataset();

        JFreeChart chart = createChart(dataset);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.white);
        add(chartPanel);

        pack();

        setTitle("Bubble chart");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private XYZDataset createDataset() {

        var dataset = new DefaultXYZDataset();

        dataset.addSeries("Product A", new double[][]{{50}, {642}, {23 * 5}});
        dataset.addSeries("Product B", new double[][]{{23}, {540}, {47 * 5}});
        dataset.addSeries("Product C", new double[][]{{19}, {188}, {30 * 5}});

        return dataset;
    }

    private JFreeChart createChart(XYZDataset dataset) {

        JFreeChart chart = ChartFactory.createBubbleChart(
                "Products",
                "Quantity",
                "Price",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false);

        XYPlot plot = (XYPlot) chart.getPlot();

        NumberAxis nax1 = (NumberAxis) plot.getDomainAxis();
        nax1.setLowerMargin(0.2);
        nax1.setUpperMargin(0.2);

        NumberAxis nax2 = (NumberAxis) plot.getRangeAxis();
        nax2.setLowerMargin(0.9);
        nax2.setUpperMargin(0.9);

        XYBubbleRenderer renderer = (XYBubbleRenderer) plot.getRenderer();
        renderer.setDefaultItemLabelsVisible(true);

        chart.setTitle(new TextTitle("Products",
                new Font("Serif", java.awt.Font.BOLD, 18))
        );

        return chart;
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {

            var ex = new BubbleChartEx();
            ex.setVisible(true);
        });
    }
}
