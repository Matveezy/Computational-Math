package integral;

public class FifthIntegral implements Integral {

    @Override
    public double getFunction(double x) {
        return (1 / x);
    }

    @Override
    public double getSecondDerivative(double x) {
        return (2 / Math.pow(x, 3));
    }

    @Override
    public String getFunctionAsString() {
        return "1 / x";
    }
}
