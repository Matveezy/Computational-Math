package entity;

import java.util.List;

public class Function {

    private List<Pair> points;

    public Function() {
    }

    public Function(List<Pair> points) {
        this.points = points;
    }

    public List<Pair> getPoints() {
        return points;
    }

    public double[] getArrayX() {
        return getPoints().stream()
                .mapToDouble(Pair::getX)
                .toArray();
    }

    public double[] getArrayY() {
        return getPoints().stream()
                .mapToDouble(Pair::getY)
                .toArray();
    }

}

