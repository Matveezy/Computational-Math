package integral;

import java.util.HashMap;
import java.util.Map;

public class IntegralsStorage {

    private static Map<Integer, Integral> integrals;

    static {
        integrals = new HashMap<>();
        integrals.put(1, new FirstIntegral());
        integrals.put(2, new SecondIntegral());
        integrals.put(3, new ThirdIntegral());
        integrals.put(4, new FourthIntegral());
        integrals.put(5, new FifthIntegral());
    }

    public static Integral getIntegral(int number) {
        if (number <= 1 || number > integrals.size()) {
            number = 1;
        }
        Integral integral = integrals.get(number);
        return integral;
    }

    public static Map<Integer, Integral> getIntegrals() {
        return integrals;
    }
}
