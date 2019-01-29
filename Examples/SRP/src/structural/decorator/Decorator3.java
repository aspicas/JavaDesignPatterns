package structural.decorator;


import com.google.common.base.Supplier;

interface Shape1 {
    String info();
}

class Circle1 implements Shape1 {
    private float radius;

    public Circle1() {}

    public Circle1(float radius) {
        this.radius = radius;
    }

    void resize(float factor) {
        radius *= factor;

    }

    @Override
    public String info() {
        return "A circle of radius " + radius;
    }
}

class Square1 implements Shape1 {
    private float side;

    public Square1() {}

    public Square1(float side) {
        this.side = side;
    }

    @Override
    public String info() {
        return "A square with side " + side;
    }
}

class ColoredShaped<T extends Shape1> implements Shape1 {
    private Shape1 shape;
    private String color;

    public ColoredShaped(Supplier<? extends T> ctor, String color) {
        shape = ctor.get();
        this.color = color;
    }

    @Override
    public String info() {
        return shape.info() + " has the color " + color;
    }
}

class TransparentShaped<T extends Shape1> implements Shape1 {
    private Shape1 shape;
    private int transparency;

    public TransparentShaped(Supplier<? extends T> ctor, int transparency) {
        shape = ctor.get();
        this.transparency = transparency;
    }

    @Override
    public String info() {
        return shape.info() + " has " + transparency + "% transparency";
    }
}

class Demo22 {
    public static void main(String[] args) {
        ColoredShaped<Square1> blueSquare = new ColoredShaped<>(
                () -> new Square1(20),
                "blue"
        );
        System.out.println(blueSquare.info());

        TransparentShaped<ColoredShaped<Circle1>> myCircle = new TransparentShaped<>(
                () -> new ColoredShaped<>(
                        () -> new Circle1(5),
                        "green"
                ), 50
        );
        System.out.println(myCircle.info());
    }
}