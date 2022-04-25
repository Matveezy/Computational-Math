package ui;

import entity.Function;
import entity.Pair;
import org.knowm.xchart.*;
import org.knowm.xchart.style.lines.SeriesLines;
import org.knowm.xchart.style.markers.SeriesMarkers;
import org.knowm.xchart.style.theme.GGPlot2Theme;

import java.awt.*;

public class Drawer {

    public static void draw(Function function, Function firstApproximation, Function secondApproximation, Pair exclusion) {
        double[] xFunctionData = function.getArrayX();
        double[] yFunctionData = function.getArrayY();
        double[] yFirstApproximationData = firstApproximation.getArrayY();

        double[] xSecondApproximationData = secondApproximation.getArrayX();
        double[] ySecondApproximationData = secondApproximation.getArrayY();

        XYChart chart = new XYChartBuilder()
                .width(800)
                .height(600)
                .title("Approximation")
                .xAxisTitle("X")
                .yAxisTitle("Y")
                .build();
        XYSeries functionDraw = chart.addSeries("Table Data", xFunctionData, yFunctionData);
        functionDraw.setLineStyle(SeriesLines.NONE);

        XYSeries firstApproximationDraw = chart.addSeries("Approximation", xFunctionData, yFirstApproximationData);
        firstApproximationDraw.setMarker(SeriesMarkers.NONE);
        firstApproximationDraw.setLineStyle(SeriesLines.DASH_DASH);
        firstApproximationDraw.setLineColor(Color.BLUE);

        XYSeries secondApproximationDraw = chart.addSeries("Approximation after exclusion", xSecondApproximationData, ySecondApproximationData);
        secondApproximationDraw.setMarker(SeriesMarkers.NONE);
        secondApproximationDraw.setLineStyle(SeriesLines.DASH_DASH);
        secondApproximationDraw.setLineColor(Color.pink);

        XYSeries exclusionPoint = chart.addSeries("Exclusion Point", new double[]{exclusion.getX()}, new double[]{exclusion.getY()});
        exclusionPoint.setFillColor(Color.GREEN);

        chart.getStyler().setTheme(new GGPlot2Theme());
        new SwingWrapper(chart).displayChart();
    }
}
