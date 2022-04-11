package file;

import service.Matrix;
import service.MatrixUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FileReader {
    static MatrixUtil matrixUtil = new MatrixUtil();

    private FileReader() {
    }

    public static Matrix readFromFile() throws FileNotFoundException {
        File file;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите имя файла");
            String filename = "resources/" + scanner.nextLine();
            file = new File(filename);
            if (!file.exists()) {
                System.err.println("Файла с таким именем нет!");
            } else break;
        }
        Scanner fileReader = null;
        int rowSize = 0;
        try {
            fileReader = new Scanner(file);
            rowSize = fileReader.nextInt();
        } catch (InputMismatchException e) {
            System.err.println("Некорректно введен размер матрицы!");
            System.exit(1);
        }
        return new Matrix(rowSize, rowSize + 1, matrixUtil.readMatrix(fileReader, rowSize, rowSize + 1));
    }
}
