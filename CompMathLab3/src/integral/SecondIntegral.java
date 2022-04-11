package integral;

public class SecondIntegral implements Integral {

    @Override
    public double getFunction(double x) {
        return ((Math.pow(x, 4) / 12) + (x / 3) - (1 / 60));
    }

    @Override
    public double getSecondDerivative(double x) {
        return Math.pow(x, 2);
    }


    @Override
    public String getFunctionAsString() {
        return "(x^4)/12 + (x/3) - 1/60";
    }
}
