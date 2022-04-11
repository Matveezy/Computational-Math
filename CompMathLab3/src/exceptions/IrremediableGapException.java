package exceptions;

public class IrremediableGapException extends Exception {

    public IrremediableGapException(String message, double x) {
        super(message + x);
    }
}
