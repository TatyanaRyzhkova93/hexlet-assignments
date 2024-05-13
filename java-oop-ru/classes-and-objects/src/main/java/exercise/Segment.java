package exercise;

class Segment {
    Point x;
    Point y;
    public Segment(Point x, Point y) {
        this.x = x;
        this.y = y;
    }
    public Point getBeginPoint() {
        return x;
    }
    public Point getEndPoint() {
        return y;
    }
    public Point getMidPoint() {
        return new Point(getMid(x.getX(), y.getX()), getMid(x.getY(), y.getY()));
    }
    private int getMid(int x, int y) {
        if (x * y > 0) {
            return (y - x) == 0 ? 0 : (y - x) / 2;
        } else {
            return (y + x) == 0 ? 0 : (y + x) / 2;
        }
    }
}
