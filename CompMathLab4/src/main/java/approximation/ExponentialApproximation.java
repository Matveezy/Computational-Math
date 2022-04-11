package approximation;

import entity.Function;
import gaussemethod.Gausse;
import userio.UserIO;
import utils.FunctionUtil;

import java.util.Arrays;
import java.util.List;

public class ExponentialApproximation extends Function implements Approximation {

    @Override
    public String typeOfApproximation() {
        return "Экспоненциальная";
    }

    @Override
    public double getApproximationFunction(double x, double... params) {
        return params[0] * Math.exp(x * params[1]);
    }

    @Override
    public double[][] getMatrixLeftSide(Function function, Approximation approximation) {
        double[] x = function.getArrayX();
        return new double[][]{
                {function.getPoints().size(), approximation.sumX(x)},
                {approximation.sumX(x), approximation.sumXX(x)}
        };
    }

    @Override
    public double[] getMatrixRightSide(Function function, Approximation approximation) {
        return new double[]{approximation.sumLnY(function.getArrayY()), approximation.sumXLnY(function)};
    }

    @Override
    public Function approximation(Function function, Approximation approximation) {
        double[][] matrix = getMatrixLeftSide(function, approximation);
        double[] results = getMatrixRightSide(function, approximation);
        double[] params = Gausse.getUnknownColumn(matrix, results);
        params[0] = Math.exp(params[0]);
        UserIO.printParams(params);
        List<Double> newY = getNewYPoints(function, params);
        return new Function(FunctionUtil.yGlueX(function, newY));
    }
}
