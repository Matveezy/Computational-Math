package methods;

import exceptions.FunctionNotDefinedException;
import exceptions.IrremediableGapException;
import exceptions.NotValidBordersException;
import integral.Integral;
import integral.IntegralsStorage;
import userio.UserIO;

public class TrapezoidMethod {

    public static void trapezoidMethodRunner() throws IrremediableGapException, FunctionNotDefinedException, NotValidBordersException {
        int chooseOfIntegral = UserIO.chooseAmount();
        double[] borders = UserIO.getBorders();
        double accuracy = UserIO.getAccuracy();
        double res = trapezoidMethod(borders, accuracy, chooseOfIntegral);
        UserIO.showDigitResultColorful(res);
    }

    public static double trapezoidMethod(double[] borders, double accuracy, int choose) throws IrremediableGapException, FunctionNotDefinedException, NotValidBordersException {

        if (borders[0] >= borders[1]) {
            throw new NotValidBordersException();
        }
        Integral integral = IntegralsStorage.getIntegral(choose);
        double maxValueOnSegment = integral.getSecondDerivativeMaxValue(borders);
        int amount = integral.getAmountOnSegment(borders, accuracy, maxValueOnSegment);
        double h = (borders[1] - borders[0]) / amount;
        isFunctionDefined(integral, borders[0]);
        System.out.println("Для заданной точности нам нужно разбить отрезок " + amount + " частей");
        double sum = 0;
        int n = 0;
        double x_0 = borders[0];
        while (n < amount) {
            if (Math.abs(x_0 - 0) < 0.0001) {
                x_0 = 0;
            }
            if (gapIdentifier(integral, x_0)) {
                x_0 += 0.0011;
                continue;

            }
            sum += getSquare(h, x_0, x_0 + h, integral);
            x_0 += h;
            n++;
        }
        return sum;
    }

    public static double getSquare(double h, double a, double b, Integral integral) {
        double result;
        if (integral.getFunction(a) * integral.getFunction(b) >= 0) {
            return (Math.abs(integral.getFunction(a)) + Math.abs(integral.getFunction(b))) / 2 * h;
        } else {
            double right = a;
            if (integral.getFunction(a) < 0) {
                while (integral.getFunction(right) < 0) {
                    right += 0.001;
                }
            } else {
                while (integral.getFunction(right) > 0) {
                    right += 0.001;
                }
            }
            result = getSquare(right - a, a, right - 0.0011, integral) + getSquare(b - right, right, b, integral);
        }
        return result;
    }

    public static boolean isGapDisposable(Integral integral, double x) throws IrremediableGapException {
        Double right = integral.getFunction(x - 0.0000001);
        Double left = integral.getFunction(x + 0.0000001);
        System.err.println("Точка разрыва при x = " + x);
        if (Math.abs(right - left) < 0.001) {
            System.out.println("Предел слева и справа сходятся - устранимый разрыв первого рода");
            System.out.println("Расчитаем интеграл до разрыва и после него!");
            return true;
        } else throw new IrremediableGapException("Неустранимый разрыв первого рода в точке ", x);
    }

    public static boolean gapIdentifier(Integral integral, double x) throws IrremediableGapException {
        Double y = integral.getFunction(x);
        if (y.isInfinite()) {
            throw new IrremediableGapException("Неустранимый разрыв второго рода в точке ", x);
        }
        if (y.isNaN()) {
            if (isGapDisposable(integral, x)) return true;
        }
        return false;
    }

    public static void isFunctionDefined(Integral integral, double x) throws FunctionNotDefinedException {
        Double y = integral.getFunction(x);
        if (y.isNaN()) {
            Double yLeft = integral.getFunction(x - 0.00001);
            Double yRight = integral.getFunction(x + 0.00001);
            if (yLeft.isNaN() || yRight.isNaN()) {
                throw new FunctionNotDefinedException();
            }
        }
    }

}