import java.util.List;
import java.util.stream.Stream;

//OCP + Specification
enum Color {
    RED, GREEN, BLUE
}

enum Size {
    SMALL, MEDIUM, LARGE, YUGE
}

class Product {

    public String name;
    public Color color;
    public Size size;

    public Product(String name, Color color, Size size) {
        this.name = name;
        this.color = color;
        this.size = size;
    }
}

class ProductFiler {

    public Stream<Product> filterByColor(List<Product> products,
                                         Color color) {
        return  products.stream().filter(p -> p.color == color);
    }

    public Stream<Product> filterBySize(List<Product> products,
                                         Size size) {
        return  products.stream().filter(p -> p.size == size);
    }

    public Stream<Product> filterBySizeAndColor(List<Product> products,
                                         Color color,
                                         Size size) {
        return  products.stream().filter(p -> p.color == color && p.size == size);
    }

}

class Demo1 {
    public static void main(String[] args) {

    }
}