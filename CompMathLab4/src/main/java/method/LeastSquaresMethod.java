package method;

import approximation.*;
import entity.*;
import ui.Drawer;
import userio.UserIO;

import java.util.*;

public class LeastSquaresMethod {


    public static void leastSquaresMethodRunner() {
        int functionChoose = UserIO.getFunctionChoose();
        int approximationChoose = UserIO.getApproximationChoose();
        leastSquaresMethod(FunctionStorage.getFunction(functionChoose), ApproximationStorage.getApproximation(approximationChoose));

    }

    private static void leastSquaresMethod(Function function, Approximation approximation) {
        approximationRunner(function, approximation);
    }

    private static void approximationRunner(Function function, Approximation approximation) {
        Function firstApproximation = approximation.approximation(function, approximation);
        Pair max = findPointWithMaxDifference(function, firstApproximation.getArrayY());
        Function functionAfterExclusion = functionAfterExclusion(function, max);
        Function approximationAfterExclusion = approximation.approximation(functionAfterExclusion, approximation);
        UserIO.printDeviation(getDeviation(getDifference(function, firstApproximation.getArrayY())));
        Drawer.draw(function, firstApproximation, approximationAfterExclusion);
    }

    private static List<Double> getDifference(Function function, double[] newY) {
        List<Double> functionPoints = function.getPoints()
                .stream()
                .map(point -> point.getY())
                .toList();
        List<Double> difference = new ArrayList<>();
        for (int i = 0; i < newY.length; i++) {
            difference.add(newY[i] - functionPoints.get(i));
        }
        return difference;
    }

    public static Pair findPointWithMaxDifference(Function function, double[] newY) {
        double max = 0;
        double x = 0;
        List<Pair> points = function.getPoints();
        for (int i = 0; i < points.size(); i++) {
            double y = points.get(i).getY();
            if (Math.abs(newY[i] - y) > max) {
                x = points.get(i).getX();
                max = Math.abs(newY[i] - y);
            }
        }
        double finalX = x;
        return points.stream()
                .filter(point -> (point.getX() == finalX))
                .findFirst()
                .get();
    }

    private static double getDeviation(List<Double> difference) {
        return difference.stream()
                .mapToDouble(dig -> dig * dig)
                .sum();
    }

    private static Function functionAfterExclusion(Function function, Pair point) {
        List<Pair> pointsAfterExclusion = function.getPoints().stream()
                .filter(entity -> entity.getX() != point.getX())
                .toList();
        return new Function(pointsAfterExclusion);
    }
}
