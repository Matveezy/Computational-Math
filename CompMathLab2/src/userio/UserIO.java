package userio;

import equations.Equation;
import equations.Equations;
import systemofequations.EquationFromSystem;

import java.util.Map;
import java.util.Scanner;

public class UserIO {

    private static Scanner scanner = new Scanner(System.in);

    public static void showSystem(EquationFromSystem eq1, EquationFromSystem eq2) {
        System.out.println("Система нелинейных уравнений");
        System.out.println(eq1.showEquation());
        System.out.println(eq2.showEquation());
    }

    public static void showJacobiMatrix(EquationFromSystem eq1, EquationFromSystem eq2) {
        System.out.println("Матрица Якоби:");
        System.out.println("| " + eq1.showDerivativeX() + " " + eq1.showDerivativeY() + " |");
        System.out.println("| " + eq2.showDerivativeX() + " " + eq2.showDerivativeY() + " |");
    }

    public static double getEpsilon() {
        System.out.println("Введите эпсилон:");
        double e = scanner.nextDouble();
        return e;
    }

    public static double[] getApproximation() {
        double[] results = new double[2];
        System.out.println("Выберите первое приближение:");
        System.out.println("Введите х:");
        results[0] = scanner.nextDouble();
        System.out.println("Введите у:");
        results[1] = scanner.nextDouble();
        return results;
    }

    public static void showDeltas(double[] deltas) {
        System.out.println("delta x :" + deltas[0]);
        System.out.println("delta y :" + deltas[1]);
    }

    public static void showCoordinatesOnNextStep(double[] results) {
        System.out.println("x : " + results[0]);
        System.out.println("y : " + results[1]);
    }

    public static void showDigitResultColorful(double str) {
        System.out.printf("\u001B[36m" + "%.6f\n" + "\u001B[0m", str);
    }

    public static void showStringColorful(String str) {
        System.out.printf("\u001B[36m");
        System.out.printf(str);
        System.out.printf("\u001B[36m" + "\u001B[0m");
    }

    public static void showAllEquations() {
        System.out.println("Выберите уравнение:");
        for (int i = 1; i <= Equations.getEquations().size(); i++) {
            System.out.println(i + ". " + Equations.getEquation(i).showEquation());
        }
    }

    public static int getNumberOfEquation() {
        return scanner.nextInt();
    }

    public static double[] getBorders() {
        double[] borders = new double[2];
        System.out.println("Введите отрезок изоляции корня:");
        System.out.println("Левая граница:");
        borders[0] = scanner.nextDouble();
        System.out.println("Правая граница");
        borders[1] = scanner.nextDouble();
        return borders;
    }
}
