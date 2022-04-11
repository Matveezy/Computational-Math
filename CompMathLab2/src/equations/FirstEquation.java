package equations;

public class FirstEquation implements Equation {

    @Override
    public double getEquation(double x) {
        return Math.pow(x, 3) + 4 * x - 3;
    }

    @Override
    public double getFirstDerivative(double x) {
        return 3 * Math.pow(x, 2) + 4;
    }

    @Override
    public double getSecondDerivative(double x) {
        return 6 * x;
    }

    @Override
    public String showEquation() {
        return "x^3 + 4*x -3 = 0";
    }
}
