package exercise;

interface Home {
    double area = 0.0;
    double getArea();
    default int compareTo(Home home) {
        if (this.getArea() > home.getArea()) {
            return 1;
        } else if (this.getArea() < home.getArea()) {
            return -1;
        } else {
            return 0;
        }
    }
}
