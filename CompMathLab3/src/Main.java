import methods.TrapezoidMethod;

public class Main {
    public static void main(String[] args) {
        System.out.println("Чухно Матвей. Метод трапеций");
        try {
            TrapezoidMethod.trapezoidMethodRunner();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
