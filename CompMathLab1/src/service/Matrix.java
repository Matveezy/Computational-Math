package service;

public class Matrix {
    private int rowSize;
    private int columnSize;
    private double[][] matrix;

    public Matrix(int rowSize, int columnSize) {
        this.rowSize = rowSize;
        this.columnSize = columnSize;
        matrix = new double[rowSize][columnSize];
    }

    public Matrix(int rowSize, int columnSize, double[][] matrix) {
        this.rowSize = rowSize;
        this.columnSize = columnSize;
        this.matrix = matrix;
    }

    public int getRowSize() {
        return rowSize;
    }

    public int getColumnSize() {
        return columnSize;
    }

    public double[][] getMatrix() {
        return matrix;
    }

    public void setRowSize(int rowSize) {
        this.rowSize = rowSize;
    }

    public void setColumnSize(int columnSize) {
        this.columnSize = columnSize;
    }

    public void setMatrix(double[][] matrix) {
        this.matrix = matrix;
    }

    public void setElement(int i, int j , double value){
        this.matrix[i][j] = value;
    }

    public double getElement(int i, int j){
        return matrix[i][j];
    }

    public void setRow(int i ,double[] row){
        matrix[i] = row;
    }

    public double[] getRow(int i){
        return matrix[i];
    }


}
