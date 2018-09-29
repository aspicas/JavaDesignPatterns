package factory;

class Point {
    private double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

class PointFactory {
    public static Point newCartesianPoint(double x, double y) {
        return new Point(x, y);
    }

    public static Point newPolarPoint(double rho, double theta) {
        return new Point(rho * Math.cos(theta),
                rho * Math.sin(theta));
    }
}

class Demo9 {
    public static void main(String[] args) {
        Point point = PointFactory.newCartesianPoint(2, 3);
        Point point1 = new Point(2, 3);
    }
}
