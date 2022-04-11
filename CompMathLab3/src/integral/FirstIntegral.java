package integral;

public class FirstIntegral implements Integral {


    @Override
    public double getFunction(double x) {
        return Math.pow(x, 2);
    }

    @Override
    public double getSecondDerivative(double x) {
        return 2;
    }

//    @Override
//    public double getSecondDerivativeMaxValue(double[] borders) {
//        return 2;
//    }

    @Override
    public String getFunctionAsString() {
        return "x ^ 2";
    }
}
