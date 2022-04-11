package methods;

import equations.Equation;
import equations.Equations;
import exceptions.NoDecisionsException;
import exceptions.NotValidBorders;
import exceptions.SameSignsException;
import userio.UserIO;

public class HalfDivision {


    public static void halfDivisionRunner() throws NotValidBorders, SameSignsException, NoDecisionsException {
        UserIO.showAllEquations();
        int number = UserIO.getNumberOfEquation();
        Equation eq = Equations.getEquation(number);
        double e = UserIO.getEpsilon();
        double[] borders = UserIO.getBorders();
        double result =  halfDivision(borders[0], borders[1], e, eq);
        UserIO.showStringColorful("x =");
        UserIO.showDigitResultColorful(result);
    }

    private static double halfDivision(double a, double b, double e, Equation equation) throws NotValidBorders, SameSignsException, NoDecisionsException {

        if (a >= b) {
            throw new NotValidBorders();
        }

        if (!equation.areSignsDifferent(a, b)) {
            throw new SameSignsException();
        }
        double x = Math.abs(equation.getEquation(b)) + 2 * e;

        while (Math.abs(equation.getEquation(x)) > e) {
            x = (a + b) / 2;
            if (equation.areSignsDifferent(a, x)) {
                b = x;
            } else if (equation.areSignsDifferent(x, b)) {
                a = x;
            } else {
                throw new NoDecisionsException();
            }
        }
        return x;
    }
}
