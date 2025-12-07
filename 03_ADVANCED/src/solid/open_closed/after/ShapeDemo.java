package solid.open_closed.after;

/**
 * Demonstracja Open/Closed Principle.
 *
 * Pokazuje, jak można rozszerzać funkcjonalność systemu (dodawać nowe kształty)
 * bez modyfikowania istniejącego kodu (AreaCalculator).
 */
public class ShapeDemo {

    public static void main(String[] args) {
        // Tworzymy różne kształty
        Shape circle = new Circle(5.0);
        Shape rectangle = new Rectangle(4.0, 6.0);
        Shape triangle = new Triangle(3.0, 4.0, 5.0);

        // ✅ AreaCalculator nie wymaga modyfikacji dla nowego kształtu (Triangle)
        AreaCalculator calculator = new AreaCalculator();

        System.out.println("=== Informacje o kształtach ===");
        calculator.printShapeInfo(circle);
        calculator.printShapeInfo(rectangle);
        calculator.printShapeInfo(triangle);

        // Obliczamy sumy dla wszystkich kształtów
        Shape[] shapes = {circle, rectangle, triangle};

        System.out.println("\n=== Podsumowanie ===");
        System.out.printf("Total Area: %.2f%n", calculator.calculateTotalArea(shapes));
        System.out.printf("Total Perimeter: %.2f%n", calculator.calculateTotalPerimeter(shapes));

        // Demonstracja polimorfizmu
        System.out.println("\n=== Polimorfizm w akcji ===");
        for (Shape shape : shapes) {
            System.out.printf("%s -> Area: %.2f%n",
                    shape.getName(),
                    shape.calculateArea());
        }
    }
}

