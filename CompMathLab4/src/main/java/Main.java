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
    }
}
