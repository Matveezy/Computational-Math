import method.LeastSquaresMethod;
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYSeries;
import org.knowm.xchart.internal.series.Series;
import org.knowm.xchart.style.lines.SeriesLines;
import userio.UserIO;

public class Main {
    public static void main(String[] args) {
        UserIO.introduction();
        UserIO.showFunctions();
        LeastSquaresMethod.leastSquaresMethodRunner();
//        double[] xData = new double[] {0.0, 1.0, 2.0, 3.0, 4.0, 5, 6};
//        double[] yData = new double[] {106, 44, 26, 10, 7.5, 3.4, .88};
//        double[] yData2 = new double[] {102, 49, 23.6, 11.3, 5.4, 2.6, 1.25};
//
//        XYChart chart = QuickChart.getChart("Sample Chart", "X", "Y", "y(x)", xData, yData);
////        Series red = chart.add
////        char
//
//        XYSeries series = chart.addSeries("A", xData, yData2);
//        series.setLineStyle(SeriesLines.NONE);
//        new SwingWrapper(chart).displayChart();
    }
}
