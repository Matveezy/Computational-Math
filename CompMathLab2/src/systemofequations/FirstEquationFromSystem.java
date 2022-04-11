package systemofequations;

public class FirstEquationFromSystem implements EquationFromSystem {


    @Override
    public double getEquation(double x, double y) {
        return Math.pow(x, 2) + Math.pow(y, 2) - 4;
    }

    @Override
    public double getDerivativeX(double x, double y) {
        return 2 * x;
    }

    @Override
    public double getDerivativeY(double x, double y) {
        return 2 * y;
    }

    @Override
    public String showEquation() {
        return "x^2 + y^2 = 4";
    }

    @Override
    public String showDerivativeX() {
        return "2*x";
    }

    @Override
    public String showDerivativeY() {
        return "2*y";
    }
}
