import methods.HalfDivision;
import methods.NewThoneMethod;
import systemofequations.NewToneMethodSystem;

public class Main {
    public static void main(String[] args) {
        System.out.println("Чухно Матвей. Лабораторная №2");
        try {
            HalfDivision.halfDivisionRunner();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        try {
            NewThoneMethod.newToneMethodRunner();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        NewToneMethodSystem.newtoneMethodSystemRunner();
    }
}
