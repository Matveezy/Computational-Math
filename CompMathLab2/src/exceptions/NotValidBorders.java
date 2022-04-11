package exceptions;

public class NotValidBorders extends Exception{

    public NotValidBorders() {
        super("Некорректно введены границы изоляции!");
    }
}
