package methods;

import equations.Equation;
import equations.Equations;
import exceptions.NoDecisionsException;
import exceptions.NotValidBorders;
import exceptions.SameSignsException;
import userio.UserIO;

public class NewThoneMethod {

    public static void newToneMethodRunner() throws NoDecisionsException, NotValidBorders, SameSignsException {
        UserIO.showAllEquations();
        int number = UserIO.getNumberOfEquation();
        Equation eq = Equations.getEquation(number);
        double e = UserIO.getEpsilon();
        double[] borders = UserIO.getBorders();
        double result = newTone(borders[0], borders[1], e, eq);
        UserIO.showStringColorful("x =");
        UserIO.showDigitResultColorful(result);
    }

    private static double newTone(double a, double b, double e, Equation equation) throws NoDecisionsException, NotValidBorders, SameSignsException {

        if (a >= b) {
            throw new NotValidBorders();
        }

        if (!equation.areSignsDifferent(a, b)) {
            throw new SameSignsException();
        }

        double x_0 = (a + b) / 2;
        double previousX = x_0 + 2 * e;
//        System.out.println("x на первом приближении " + x_0);
        while (Math.abs(x_0 - previousX) > e) {
            previousX = x_0;
            x_0 = getNextX(equation, x_0);
        }
        return x_0;
    }

    private static boolean isConverge(Equation equation, double x) {
        return (equation.getEquation(x) * equation.getSecondDerivative(x) > 0);
    }

    private static double getNextX(Equation equation, double x) {
        if (Math.abs(x - 0) < 0.0001) {
            x = 0.0001;
        }
        return (x - (equation.getEquation(x) / equation.getFirstDerivative(x)));
    }
}
