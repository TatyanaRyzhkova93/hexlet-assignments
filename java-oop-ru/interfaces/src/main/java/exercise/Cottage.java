package exercise;

class Cottage implements Home {
    double area;
    int floorCount;
    public Cottage(double area, int floorCount) {
        this.area = area;
        this.floorCount = floorCount;
    }
    public String toString() {
        return floorCount + " этажный коттедж площадью " + area + " метров";
    }
    @Override
    public double getArea() {
        return area;
    }
}