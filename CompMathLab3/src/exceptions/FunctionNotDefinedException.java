package exceptions;

public class FunctionNotDefinedException extends Exception{

    public FunctionNotDefinedException() {
        super("Функция не определена на данном отрезке!");
    }
}
