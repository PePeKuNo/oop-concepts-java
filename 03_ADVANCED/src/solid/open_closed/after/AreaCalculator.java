package solid.open_closed.after;

/**
 * AreaCalculator zgodny z Open/Closed Principle.
 *
 * Klasa jest zamknięta na modyfikację - nie musimy jej zmieniać przy dodawaniu nowych kształtów.
 * System jest otwarty na rozszerzanie - możemy dodawać nowe implementacje Shape.
 */
public class AreaCalculator {

    /**
     * Oblicza pole powierzchni dla pojedynczego kształtu.
     * ✅ Nie wymaga modyfikacji przy dodawaniu nowych kształtów!
     */
    public double calculateArea(Shape shape) {
        return shape.calculateArea();
    }

    /**
     * Oblicza sumę pól powierzchni dla wielu kształtów.
     */
    public double calculateTotalArea(Shape[] shapes) {
        double total = 0;
        for (Shape shape : shapes) {
            total += shape.calculateArea();
        }
        return total;
    }

    /**
     * Oblicza sumę obwodów dla wielu kształtów.
     */
    public double calculateTotalPerimeter(Shape[] shapes) {
        double total = 0;
        for (Shape shape : shapes) {
            total += shape.calculatePerimeter();
        }
        return total;
    }

    /**
     * Wyświetla informacje o kształcie.
     */
    public void printShapeInfo(Shape shape) {
        System.out.printf("%s: Area = %.2f, Perimeter = %.2f%n",
                shape.getName(),
                shape.calculateArea(),
                shape.calculatePerimeter());
    }
}

