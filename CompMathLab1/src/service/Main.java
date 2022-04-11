package service;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        MatrixUtil matrixUtil = new MatrixUtil();
        Gausse gausse = new Gausse();
        Matrix matrix = matrixUtil.createMatrix();
        System.out.println("Расширенная матрица");
        matrixUtil.printMatrix(matrix);
        System.out.println("Определитель матрицы");
        System.out.printf("%.4f", gausse.getDeterminant(matrix));
        System.out.println();
        Matrix triangle = gausse.methodGausse(matrix);
        System.out.println("Треугольная матрица:");
        matrixUtil.printMatrix(triangle);
        double[] unknowns = gausse.getUnknownColumn(matrix);
        System.out.println("Столбец неизвестных:");
        if (unknowns == null) {
            System.out.println("Матрица несовместна");
        } else {
            matrixUtil.printColumn(unknowns);
        }
        double[] residuals = gausse.getResidualColumn(matrix);
        System.out.println("Столбец невязок:");
        if (residuals==null) {
            System.out.println("Матрица несовместна!");
        } else {
            matrixUtil.printColumn(residuals);
        }
    }
}
