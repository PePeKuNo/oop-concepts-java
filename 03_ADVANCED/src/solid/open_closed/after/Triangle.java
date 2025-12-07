package solid.open_closed.after;

/**
 * Nowy kształt dodany BEZ modyfikacji istniejących klas!
 * ✅ Zgodnie z Open/Closed Principle.
 */
public class Triangle implements Shape {
    private final double a;
    private final double b;
    private final double c;

    public Triangle(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("Boki trójkąta muszą być większe od zera");
        }
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalArgumentException("Podane boki nie tworzą trójkąta");
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double calculateArea() {
        // Wzór Herona
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public double calculatePerimeter() {
        return a + b + c;
    }

    @Override
    public String getName() {
        return "Triangle";
    }

    public double getA() { return a; }
    public double getB() { return b; }
    public double getC() { return c; }
}

