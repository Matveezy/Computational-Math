package service;

import java.util.Arrays;

public class Gausse {
    private MatrixUtil matrixUtil = new MatrixUtil();

    public Matrix methodGausse(Matrix matrix) {
        Matrix copy = new Matrix(matrix.getRowSize(), matrix.getColumnSize());
        matrixUtil.copyMatrix(matrix, copy);
        for (int k = 0; k < copy.getRowSize() - 1; k++) {
            if (copy.getElement(k, k) == 0) {
                System.out.println("Матрицу нельзя привести к треугольному виду");
                System.exit(1);
            }
            for (int i = k + 1; i < copy.getRowSize(); i++) {
                if (copy.getElement(i, k) == 0) continue;
                double specialEl = copy.getElement(i, k);
                for (int j = 0; j < copy.getColumnSize(); j++) {
                    double coefficient = specialEl / copy.getElement(k, k);
                    copy.getMatrix()[i][j] -= (double) Math.round(copy.getElement(k, j) * (coefficient) * 10000) / 10000;
                }
            }
        }
        return copy;
    }

    public double getDeterminant(Matrix matrix) {
        Matrix triangleMatrix = methodGausse(matrix);
        double determinant = 1;
        for (int i = 0; i < triangleMatrix.getRowSize(); i++) {
            determinant *= triangleMatrix.getElement(i, i);
        }
        determinant = determinant == 0 ? Math.abs(determinant) : determinant;
        return determinant;
    }

    public double[] getUnknownColumn(Matrix matrix) {
        Matrix triangle = methodGausse(matrix);
        if (isInJoint(triangle)) return null;
        double[] unknowns = getNullColumn(triangle.getRowSize());
        for (int i = triangle.getRowSize() - 1; i >= 0; i--) {
            double elementsSum = 0;
            double b = triangle.getElement(i, triangle.getColumnSize() - 1);
            if (!isNullRow(triangle.getRow(i)) && triangle.getElement(i, i) != 0) {
                for (int j = 0; j < triangle.getColumnSize() - 1; j++) {
                    if (j != i) elementsSum += unknowns[j] * triangle.getElement(i, j);
                }
                unknowns[i] = (b - elementsSum) / triangle.getElement(i, i);
            }
        }
        return unknowns;
    }

    public double[] getResidualColumn(Matrix matrix) {
        Matrix triangle = methodGausse(matrix);
        if (isInJoint(triangle)) return null;
        double[] unknowns = getUnknownColumn(matrix);
        double[] residuals = new double[unknowns.length];
        for (int i = triangle.getRowSize() - 1; i >= 0; i--) {
            double b = triangle.getElement(i, triangle.getColumnSize() - 1);
            double sum = 0;
            for (int j = 0; j < triangle.getColumnSize() - 1; j++) {
                sum += unknowns[j] * triangle.getElement(i, j);
            }
            residuals[i] = b - sum;
        }
        return residuals;
    }

    public boolean isNullRow(double[] row) {
        return Arrays.stream(row)
                .allMatch(el -> el == 0);
    }

    public boolean isInJoint(Matrix matrix) {
        for (int i = 0; i < matrix.getRowSize(); i++) {
            if (isNullRow(matrix.getRow(i)) && matrix.getElement(i, matrix.getColumnSize() - 1) != 0) return true;
        }
        return false;
    }

    private double[] getNullColumn(int size) {
        double[] column = new double[size];
        Arrays.stream(column)
                .forEach(el -> el = 0);
        return column;
    }
}
