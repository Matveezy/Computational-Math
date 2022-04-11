package exceptions;

public class NotValidBordersException extends Exception{

    public NotValidBordersException() {
        super("Границы интегрирования введены некорректно!");
    }
}
