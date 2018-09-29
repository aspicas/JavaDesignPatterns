package factory;

enum CoordinateSystem {
    CARTESIAN,
    POLAR
}

class Point {
    private double x, y;

    /**
     *
     * @param a is x if cartisian or rho if polar
     * @param b
     * @param cs
     */
    public Point(double a, double b, CoordinateSystem cs) {
        switch (cs){
            case POLAR:
                x = a * Math.cos(b);
                y = a * Math.sin(b);
                break;
            case CARTESIAN:
                this.x = a;
                this.y = b;
                break;
        }
    }
}

