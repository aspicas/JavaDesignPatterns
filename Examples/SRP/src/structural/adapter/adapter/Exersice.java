package structural.adapter.adapter;

class Square {

    public int side;

    public Square(int side) {
        this.side = side;
    }

}

interface Rectangle {
    int getWidth();
    int getHeight();

    default int getArea() {
        return getWidth() * getHeight();
    }
}

class SquareToRectangleAdapter implements Rectangle {
    private Square square;

    public SquareToRectangleAdapter(Square square) {
        this.square = square;
    }

    @Override
    public int getWidth() {
        return square.side * 2;
    }

    @Override
    public int getHeight() {
        return square.side;
    }
}

class Demo19 {
    public static void main(String[] args) {
        Square square = new Square(5);
        SquareToRectangleAdapter adapter = new SquareToRectangleAdapter(square);
        System.out.println(adapter.getArea());
    }
}