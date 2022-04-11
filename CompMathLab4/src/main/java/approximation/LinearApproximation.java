package approximation;

import entity.Function;
import entity.Pair;
import gaussemethod.Gausse;
import userio.UserIO;
import utils.FunctionUtil;

import javax.sound.sampled.Line;
import java.util.Arrays;
import java.util.List;

public class LinearApproximation extends Function implements Approximation {

    public LinearApproximation() {
    }

    @Override
    public String typeOfApproximation() {
        return "Линейная";
    }

    @Override
    public double getApproximationFunction(double x, double... params) {
        return params[0] * x + params[1];
    }


    @Override
    public double[][] getMatrixLeftSide(Function function, Approximation approximation) {
        double[] x = function.getArrayX();
        return new double[][]{
                {approximation.sumXX(x), approximation.sumX(x)},
                {approximation.sumX(x), function.getPoints().size()}
        };
    }

    @Override
    public double[] getMatrixRightSide(Function function, Approximation approximation) {
        return new double[]{approximation.sumXY(function), approximation.sumY(function.getArrayY())};
    }


}
