import methods.LeastSquaresMethod;
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import userio.UserIO;

import java.util.Scanner;
//TODO
// - Шум

public class Main {
    public static void main(String[] args) {
        UserIO.introduction();
        UserIO.showFunctions();
        LeastSquaresMethod.leastSquaresMethodRunner();
//        double[] xData = new double[]{1.2, 2.9, 4.1, 5.5, 6.7, 7.8, 9.2, 10.3};
//        double[] yData = new double[]{7.4, 9.5, 11.1, 12.9, 14.6, 17.3, 18.2, 20.7};
//        XYChart chart = QuickChart.getChart("Simple chart", "X", "Y", "function", xData, yData);
//        System.out.println("Privet");
//        Scanner scanner = new Scanner(System.in);
//        scanner.next();
//        new SwingWrapper(chart).displayChart();
    }
}
