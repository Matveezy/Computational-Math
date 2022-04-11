package approximation;

import java.util.HashMap;
import java.util.Map;

public class ApproximationStorage {

    private static Map<Integer, Approximation> map;

    static {
        map = new HashMap<>();
        map.put(1, new LinearApproximation());
        map.put(2, new QuadraticApproximation());
        map.put(3, new ExponentialApproximation());
    }

    public static Approximation getApproximation(int number) {
        return map.get(number);
    }

    public static Map<Integer, Approximation> getApproximations() {
        return map;
    }
}
