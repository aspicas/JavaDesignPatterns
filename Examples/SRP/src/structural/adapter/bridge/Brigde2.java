package structural.adapter.bridge;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

import javax.inject.Inject;

interface Renderer2 {
    void renderCircle(float radius);
}

class VectorRenderer2 implements Renderer2 {
    @Override
    public void renderCircle(float radius) {
        System.out.println("Drawing a circle of radius "
                + radius);
    }
}

class RasterRenderer2 implements Renderer2 {
    @Override
    public void renderCircle(float radius) {
        System.out.println("Drawing pixels for a circle of radius "
                + radius);
    }
}

abstract class Shape2 {
    protected Renderer2 renderer;

    public Shape2(Renderer2 renderer) {
        this.renderer = renderer;
    }

    public abstract void draw();
    public abstract void resize(float factor);
}

class Circle2 extends Shape2 {
    public float radius;

    @Inject
    public Circle2(Renderer2 renderer) {
        super(renderer);
    }

    public Circle2(Renderer2 renderer, float radius) {
        super(renderer);
        this.radius = radius;
    }

    @Override
    public void draw() {
        renderer.renderCircle(radius);
    }

    @Override
    public void resize(float factor) {
        radius *= factor;
    }
}

class ShapeModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Renderer2.class).to(VectorRenderer2.class);
    }
}

class Demo21 {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new ShapeModule());
        Circle2 instance = injector.getInstance(Circle2.class);
        instance.radius = 3;
        instance.draw();
        instance.resize(2);
        instance.draw();
    }
}