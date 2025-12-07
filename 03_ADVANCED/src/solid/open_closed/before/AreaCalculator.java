package solid.open_closed.before;

/**
 * Naruszenie Open/Closed Principle.
 *
 * Problem: Dodanie nowego kształtu wymaga modyfikacji tej klasy.
 */
public class AreaCalculator {

    public double calculateArea(Object shape) {
        if (shape instanceof Rectangle) {
            Rectangle rectangle = (Rectangle) shape;
            return rectangle.getWidth() * rectangle.getHeight();
        } else if (shape instanceof Circle) {
            Circle circle = (Circle) shape;
            return Math.PI * circle.getRadius() * circle.getRadius();
        }
        // ❌ Każdy nowy kształt wymaga dodania kolejnego if!
        return 0;
    }

    public double calculateTotalArea(Object[] shapes) {
        double total = 0;
        for (Object shape : shapes) {
            total += calculateArea(shape);
        }
        return total;
    }
}

class Rectangle {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() { return width; }
    public double getHeight() { return height; }
}

class Circle {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() { return radius; }
}

