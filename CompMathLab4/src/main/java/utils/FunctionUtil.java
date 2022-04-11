package utils;

import entity.Function;
import entity.Pair;

import java.util.ArrayList;
import java.util.List;

public class FunctionUtil {

    public static List<Pair> yGlueX(Function function, List<Double> newY) {
        List<Pair> result = new ArrayList<>();
        List<Pair> points = function.getPoints();
        for (int i = 0; i < points.size(); i++) {
            result.add(new Pair(points.get(i).getX(), newY.get(i)));
        }
        return result;
    }
}
