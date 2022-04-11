package userio;

import integral.Integral;
import integral.IntegralsStorage;

import java.util.Map;
import java.util.Scanner;

public class UserIO {
    private static Scanner scanner = new Scanner(System.in);

    public static double[] getBorders() {
        double[] borders = new double[2];
        System.out.println("Введите границы интегрирования:");
        borders[0] = scanner.nextDouble();
        borders[1] = scanner.nextDouble();
        return borders;
    }

    public static void showDigitResultColorful(double str) {
        System.out.printf("\u001B[36m" + "%.6f\n" + "\u001B[0m", str);
    }

    public static double getAccuracy() {
        System.out.println("Введите точность, до которой вы хотите посчитать интеграл:");
        return scanner.nextDouble();
    }

    public static int chooseAmount() {
        System.out.println("Выберите интеграл, который хотите посчитать:");
        Map<Integer, Integral> integrals = IntegralsStorage.getIntegrals();
        for (int i = 1; i <= integrals.size(); i++) {
            System.out.println(i + ". " + IntegralsStorage.getIntegral(i).getFunctionAsString());
        }
        int number = scanner.nextInt();
        return number;
    }
}
