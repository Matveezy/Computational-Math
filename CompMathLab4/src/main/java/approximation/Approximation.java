package approximation;

import entity.Function;
import gaussemethod.Gausse;
import userio.UserIO;
import util.FunctionUtil;

import java.util.Arrays;
import java.util.List;

public interface Approximation {

    double getApproximationFunction(double x, double... params);

    String typeOfApproximation();

    default double sumX(double[] x) {
        return Arrays.stream(x).sum();
    }

    default double sumY(double[] y) {
        return Arrays.stream(y).sum();
    }

    double[][] getMatrixLeftSide(Function function, Approximation approximation);

    double[] getMatrixRightSide(Function function, Approximation approximation);

    default double sumXX(double[] x) {
        return Arrays.stream(x).map(digit -> digit * digit).sum();
    }

    default double sumXY(Function function) {
        return function.getPoints().stream()
                .mapToDouble(point -> point.getX() * point.getY())
                .sum();
    }

    default double sumXXY(Function function) {
        return function.getPoints().stream()
                .mapToDouble(point -> Math.pow(point.getX(), 2) * point.getY())
                .sum();
    }

    default double sumXXX(double[] x) {
        return Arrays.stream(x).map(digit -> Math.pow(digit, 3)).sum();
    }

    default double sumX_4(double[] x) {
        return Arrays.stream(x).map(digit -> Math.pow(digit, 4)).sum();
    }

    default double sumXLnY(Function function) {
        return function.getPoints().stream()
                .mapToDouble(point -> point.getX() * Math.log(point.getY()))
                .sum();
    }

    default double sumLnY(double[] y) {
        return Arrays.stream(y).map(digit -> Math.log(digit)).sum();
    }

    default List<Double> getNewYPoints(Function function, double[] params) {
        List<Double> newY = Arrays.stream(function.getArrayX())
                .mapToObj(Double::valueOf)
                .map(xCoord -> getApproximationFunction(xCoord, params))
                .toList();
        return newY;
    }

    default Function approximation(Function function, Approximation approximation) {
        double[][] matrix = getMatrixLeftSide(function, approximation);
        double[] results = getMatrixRightSide(function, approximation);
        double[] params = Gausse.getUnknownColumn(matrix, results);
        UserIO.printParams(params);
        List<Double> newY = getNewYPoints(function, params);
        return new Function(FunctionUtil.yGlueX(function, newY));
    }
}
