package systemofequations;

public interface EquationFromSystem {

    double getEquation(double x, double y);

    double getDerivativeX(double x, double y);

    double getDerivativeY(double x, double y);

    String showEquation();

    String showDerivativeX();

    String showDerivativeY();
}
