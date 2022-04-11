package equations;

public class ThirdEquation implements Equation {

    @Override
    public double getEquation(double x) {
        return Math.sqrt(x) - (1 / x);
    }

    @Override
    public double getFirstDerivative(double x) {
        return 1 / (2 * Math.sqrt(x));
    }

    @Override
    public double getSecondDerivative(double x) {
        return -1 / (4 * Math.pow(x, 1.5));
    }

    @Override
    public String showEquation() {
        return "(x)^(1/2) - 1/x = 0";
    }
}
