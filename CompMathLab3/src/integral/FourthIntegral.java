package integral;

public class FourthIntegral implements Integral {

    @Override
    public double getFunction(double x) {
        return (Math.sin(x) / x);
    }

    @Override
    public double getSecondDerivative(double x) {
        double a = -Math.sin(x);
        double b = (-2 * Math.cos(x)) / x;
        double c = (2 * Math.sin(x)) / (Math.pow(x, 2));
        return (a + b + c) / x;
    }


    @Override
    public String getFunctionAsString() {
        return "sin(x) / x";
    }

}
