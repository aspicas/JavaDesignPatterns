package creational.prototype;

class Point
{
    public int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point point){
        this(point.x, point.y);
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

class Line
{
    public Point start, end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public Line(Line line) {
        start = new Point(line.start);
        end = new Point(line.end);
    }

    public Line deepCopy()
    {
        return new Line(this);
    }

    @Override
    public String toString() {
        return "Line{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}

class Demo15 {
    public static void main(String[] args) {
        Line line = new Line(
                new Point(0, 0),
                new Point(1, 1)
        );

        Line line1 = line.deepCopy();
        line1.end = new Point(4, 4);
        line1.start.y = 5;

        System.out.println(line);
        System.out.println(line1);

        Point point = new Point(5, 5);
        Point point1 = new Point(point);
        point1.y = 1;
        line1.start = point1;

        System.out.println(point);
        System.out.println(point1);
        System.out.println(line1);
    }
}
