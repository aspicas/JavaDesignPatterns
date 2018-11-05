package structural.adapter.bridge;

interface Renderer3 {
    public String whatToRenderAs();
}

abstract class Shape3
{
    protected Renderer3 renderer;
    public String name;

    public Shape3(Renderer3 renderer) {
        this.renderer = renderer;
    }

    @Override
    public String toString() {
        return String.format("Drawing %s as %s", name, renderer.whatToRenderAs());
    }
}

class Triangle extends Shape3
{
    public Triangle(Renderer3 renderer) {
        super(renderer);
        name = "Triangle";
    }
}

class Square extends Shape3
{
    public Square(Renderer3 renderer) {
        super(renderer);
        name = "Square";
    }
}

class VectorSquare implements Renderer3
{
    @Override
    public String whatToRenderAs() {
        return "lines";
    }
}

class RasterSquare implements Renderer3
{
    @Override
    public String whatToRenderAs() {
        return "pixels";
    }
}

// imagine VectorTriangle and RasterTriangle are here too