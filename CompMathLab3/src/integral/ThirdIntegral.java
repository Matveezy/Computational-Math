package integral;

public class ThirdIntegral implements Integral {

    @Override
    public double getFunction(double x) {
        return x * Math.sqrt(x + 1);
    }

    @Override
    public double getSecondDerivative(double x) {
        return ((3 * x + 4) / (4 * Math.pow(x + 1, 1.5)));
    }

//    @Override
//    public double getSecondDerivativeMaxValue(double[] borders) {
//        return this.getSecondDerivative(borders[1]);
//    }

    @Override
    public String getFunctionAsString() {
        return "x * (x+1) ^ 1/2";
    }

}
