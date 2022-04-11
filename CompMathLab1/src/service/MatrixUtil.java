package service;

import file.FileReader;
import randomgenerator.RandomGenerator;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

public class MatrixUtil {
    private Scanner scanner = new Scanner(System.in);

    public Matrix createMatrix() throws FileNotFoundException {
        int option;
        while (true) {
            System.out.println("Выберите режим работы:\n" +
                    "1 - Считать из файла\n" +
                    "2 - Ввести вручную\n" +
                    "3 - Сгенерировать автоматически\n");
            option = scanner.nextInt();
            if (option != 1 && option != 2 && option != 3) {
                System.out.println("Введите вариант из предложенных");
            } else break;
        }
        Matrix matrix;
        switch (option) {
            case (1): {
                matrix = FileReader.readFromFile();
                break;
            }
            case (2): {
                int rowSize = getSize();
                matrix = new Matrix(rowSize, rowSize + 1, readMatrix(scanner, rowSize, rowSize + 1));
                break;
            }
            case (3): {
                int rowSize = getSize();
                matrix = RandomGenerator.generateRandomMatrix(rowSize);
                break;
            }
            default:
                throw new IllegalStateException("Unexpected value: " + option);
        }
        return matrix;
    }

    public double[][] readMatrix(Scanner input, int rowsSize, int columnsSize) {
        double[][] matrix = new double[rowsSize][columnsSize];
        try {
            for (int i = 0; i < rowsSize; i++) {
                for (int j = 0; j < columnsSize; j++) {
                    matrix[i][j] = input.nextDouble();
                }
            }
        } catch (NoSuchElementException e) {
            System.err.println("Некорректно введена матрица");
            System.exit(1);
        }
        return matrix;
    }

    public void printMatrix(Matrix matrix) {
        for (int i = 0; i < matrix.getRowSize(); i++) {
            for (int j = 0; j < matrix.getColumnSize(); j++) {
                if (j == matrix.getColumnSize() - 1) {
                    System.out.printf("| %.4f", matrix.getElement(i, j));
                } else {
                    System.out.printf("%.4f ", matrix.getElement(i, j));
                }
            }
            System.out.println();
        }
    }

    public void printColumn(double[] column) {
        for (double v : column) {
            System.out.printf("%.4f\n", v);
        }
    }

    public void inputOption() {

    }

    public int getSize() {
        while (true) {
            System.out.println("Введите размер матрицы:");
            int rows = scanner.nextInt();
            if (rows < 2 || rows > 20) {
                System.out.println("Размер матрицы должен быть не больше 20 и не меньше 2");
            } else {
                return rows;
            }
        }
    }

    public void copyMatrix(Matrix src, Matrix dst) {
        for (int i = 0; i < src.getRowSize(); i++) {
            for (int j = 0; j < src.getColumnSize(); j++) {
                dst.setElement(i, j, src.getElement(i, j));
            }
        }
    }
}
