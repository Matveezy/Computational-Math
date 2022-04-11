package equations;

public interface Equation {

    double getEquation(double x);

    double getFirstDerivative(double x);

    double getSecondDerivative(double x);

    String showEquation();

    default boolean areSignsDifferent(double a, double b) {
        return (getEquation(a) * getEquation(b) < 0);
    }

}
