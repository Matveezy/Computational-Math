package ui;

import entity.Function;
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.style.Styler;
import org.knowm.xchart.style.theme.GGPlot2Theme;

public class Drawer {

    public static void draw(Function function, Function firstApproximation, Function secondApproximation) {
        double[] xFunctionData = function.getArrayX();
        double[] yFunctionData = function.getArrayY();
        double[] yFirstApproximationData = firstApproximation.getArrayY();

        double[] xSecondApproximationData = secondApproximation.getArrayX();
        double[] ySecondApproximationData = secondApproximation.getArrayY();

        XYChart chart = QuickChart.getChart("Approximation", "X", "Y", "y(x)", xFunctionData, yFunctionData);
        chart.addSeries("Approximation", xFunctionData, yFirstApproximationData);
        chart.addSeries("Approximation after exclusion", xSecondApproximationData, ySecondApproximationData);
        chart.getStyler().setTheme(new GGPlot2Theme());
        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNE);
        chart.getStyler().setAxisTitlesVisible(false);
        new SwingWrapper(chart).displayChart();

    }
}
