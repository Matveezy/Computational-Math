package equations;

public class SecondEquation implements Equation {

    @Override
    public double getEquation(double x) {
        return Math.pow(x, 2) - 20 * Math.sin(x);
    }

    @Override
    public double getFirstDerivative(double x) {
        return 2 * x - 20 * Math.cos(x);
    }

    @Override
    public double getSecondDerivative(double x) {
        return 20 * Math.sin(x) + 2;
    }

    @Override
    public String showEquation() {
        return "x^2 - 20*sin(x) = 0";
    }
}
