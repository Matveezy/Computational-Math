package exceptions;

public class SameSignsException extends Exception {

    public SameSignsException() {
        super("На концах данного отрезка функция имеет одинаковые знаки!");
    }
}
