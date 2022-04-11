package equations;

import java.util.HashMap;
import java.util.Map;

public class Equations {

    private static Map<Integer, Equation> equations;

    static {
        equations = new HashMap<>();
        equations.put(1, new FirstEquation());
        equations.put(2, new SecondEquation());
        equations.put(3, new ThirdEquation());
    }

    public static Map<Integer, Equation> getEquations() {
        return equations;
    }

    public static Equation getEquation(int number) {
        if (number <= 1 || number > equations.size()) {
            number = 1;
        }
        Equation eq = equations.get(number);
        return eq;
    }
}
