package exceptions;

public class NoDecisionsException extends Exception{

    public NoDecisionsException() {
        super("На данном отрезке изоляции уравнение корней не имеет!");
    }
}
