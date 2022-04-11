package entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FunctionStorage {

    private static Map<Integer, Function> functions;

    static {
        functions = new HashMap<>();
        functions.put(1, new Function(List.of(
                new Pair(1.2, 7.4),
                new Pair(2.9, 9.5),
                new Pair(4.1, 11.1),
                new Pair(5.5, 12.9),
                new Pair(6.7, 14.6),
                new Pair(7.8, 17.3),
                new Pair(9.2, 18.2),
                new Pair(10.3, 20.7)
        )));
        functions.put(2, new Function(List.of(
                new Pair(1.1, 3.5),
                new Pair(2.3, 4.1),
                new Pair(3.7, 5.2),
                new Pair(4.5, 6.9),
                new Pair(5.4, 8.3),
                new Pair(6.8, 14.8),
                new Pair(7.5, 21.2)
        )));
        functions.put(3, new Function(List.of(
                new Pair(1.1, 2.73),
                new Pair(2.3, 5.12),
                new Pair(3.7, 7.74),
                new Pair(4.5, 8.91),
                new Pair(5.4, 10.59),
                new Pair(6.8, 12.75),
                new Pair(7.5, 13.43)
        )));
    }

    public static Function getFunction(int choose) {
        if (choose <= 1 || choose > functions.size()) {
            choose = 1;
        }
        return functions.get(choose);
    }

    public static Map<Integer, Function> getFunctions() {
        return functions;
    }

}
