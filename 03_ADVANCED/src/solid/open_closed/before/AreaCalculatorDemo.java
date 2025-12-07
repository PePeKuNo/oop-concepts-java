package solid.open_closed.before;

/**
 * Demonstracja naruszenia Open/Closed Principle.
 *
 * Problem: Każde dodanie nowego kształtu wymaga modyfikacji klasy AreaCalculator.
 */
public class AreaCalculatorDemo {

    public static void main(String[] args) {
        AreaCalculator calculator = new AreaCalculator();

        // Tworzymy przykładowe figury
        Rectangle rectangle = new Rectangle(5.0, 3.0);
        Circle circle = new Circle(4.0);

        System.out.println("=== Obliczanie powierzchni ===");
        System.out.printf("Rectangle area: %.2f%n", calculator.calculateArea(rectangle));
        System.out.printf("Circle area: %.2f%n", calculator.calculateArea(circle));

        // Problem: Co jeśli chcemy dodać Triangle?
        // ❌ Musimy zmodyfikować metodę calculateArea() w AreaCalculator!

        Object[] shapes = {rectangle, circle};
        System.out.printf("%nTotal area: %.2f%n", calculator.calculateTotalArea(shapes));

        System.out.println("\n⚠️ Problem:");
        System.out.println("- Dodanie Triangle wymaga modyfikacji AreaCalculator");
        System.out.println("- Naruszenie OCP: klasa nie jest zamknięta na modyfikację");
        System.out.println("- Wysokie ryzyko wprowadzenia błędów");
    }
}

