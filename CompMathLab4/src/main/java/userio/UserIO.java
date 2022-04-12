package userio;

import approximation.Approximation;
import approximation.ApproximationStorage;
import entity.Function;
import entity.FunctionStorage;
import entity.Pair;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class UserIO {

    private static Scanner scanner = new Scanner(System.in);
    private static Map<Integer, Approximation> approximations;

    public static void introduction() {
        System.out.println("Чухно Матвей. Метод наименьших квадратов");
    }

    public static void showFunctions() {
        Map<Integer, Function> functions = FunctionStorage.getFunctions();
        for (int i = 1; i <= functions.size(); i++) {
            System.out.println("Таблица значений " + i);
            showTable(functions.get(i));
        }
    }

    private static void showTable(Function function) {
        System.out.print("x:| ");
        List<Pair> points = function.getPoints();
        for (int i = 0; i < points.size(); i++) {
            System.out.print(points.get(i).getX() + " ");
        }
        System.out.println("|");
        System.out.print("y:| ");
        for (int i = 0; i < points.size(); i++) {
            System.out.print(points.get(i).getY() + " ");
        }
        System.out.println("|");
    }

    public static int getFunctionChoose() {
        System.out.println("Выберите номер аппроксимируемой функции");
        return scanner.nextInt();
    }

    public static int getApproximationChoose() {
        System.out.println("Выберите номер аппроксимиции");
        printAllTypesOfApproximations();
        return scanner.nextInt();
    }

    public static void printAllTypesOfApproximations() {
        for (Map.Entry<Integer, Approximation> entry : ApproximationStorage.getApproximations().entrySet()) {
            System.out.println(entry.getKey() + "." + entry.getValue().typeOfApproximation());
        }
    }

    public static void printParams(double[] params) {
        for (int i = 0; i < params.length; i++) {
            System.out.printf("\u001B[36m" + "a[" + i + "]= " + "%.6f\n" + "\u001B[0m", params[i]);
        }
        System.out.println();
    }

    public static void printDeviation(double deviation) {
        System.out.printf("\u001B[36m" + "Мера отклонения: " + "%.6f\n" + "\u001B[0m", deviation);
    }
}
