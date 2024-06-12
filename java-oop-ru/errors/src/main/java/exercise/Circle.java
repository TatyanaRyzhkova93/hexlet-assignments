package exercise;

import static java.lang.Math.PI;

class Circle {
    Point point;
    int radius;

    public Circle(Point point, int radius) {
        this.point = point;
        this.radius = radius;
    }

    public double getSquare() throws NegativeRadiusException {
        if (radius < 0) {
            throw new NegativeRadiusException("Не удалось посчитать площадь");
        }
        return PI * radius * radius;
    }

    public int getRadius() {
        return radius;
    }
}
