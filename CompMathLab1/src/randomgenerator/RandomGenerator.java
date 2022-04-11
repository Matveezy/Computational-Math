package randomgenerator;

import service.Matrix;

import java.util.Random;

public class RandomGenerator {

    private RandomGenerator() {
    }

    public static Matrix generateRandomMatrix(int rowSize) {
        Matrix matrix = new Matrix(rowSize, rowSize + 1);
        double[][] matr = matrix.getMatrix();
        for (int i = 0; i < matrix.getRowSize(); i++) {
            for (int j = 0; j < matrix.getColumnSize(); j++) {
                matr[i][j] = Math.random() * 10;
            }
        }
        return matrix;
    }
}
