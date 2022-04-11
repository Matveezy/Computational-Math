package systemofequations;

public class SecondEquationFromSystem implements EquationFromSystem {

    @Override
    public double getEquation(double x, double y) {
        return y - 3 * Math.pow(x, 2);
    }

    @Override
    public double getDerivativeX(double x, double y) {
        return -6 * x;
    }

    @Override
    public double getDerivativeY(double x, double y) {
        return 1;
    }

    @Override
    public String showEquation() {
        return "y = 3 * x^2";
    }

    @Override
    public String showDerivativeX() {
        return "-6*x";
    }

    @Override
    public String showDerivativeY() {
        return "1";
    }
}
