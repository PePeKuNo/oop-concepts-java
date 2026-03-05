package introduction.exercises.tasks;

/**
 * ZADANIE 1: Klasa Rectangle z walidacją i metodami geometrycznymi
 */
public class RectangleTask {

    public static class Rectangle {
        private double width;
        private double height;
        public static int instanceCount = 0;

        public Rectangle(double width, double height) {
            if (width <= 0) throw new IllegalArgumentException("Width must be > 0, got: " + width);
            if (height <= 0) throw new IllegalArgumentException("Height must be > 0, got: " + height);
            this.width = width;
            this.height = height;
            instanceCount++;
        }

        public double getWidth()  { return width; }
        public double getHeight() { return height; }

        public void setWidth(double width) {
            if (width <= 0) throw new IllegalArgumentException("Width must be > 0");
            this.width = width;
        }
        public void setHeight(double height) {
            if (height <= 0) throw new IllegalArgumentException("Height must be > 0");
            this.height = height;
        }

        public double area()      { return width * height; }
        public double perimeter() { return 2 * (width + height); }
        public boolean isSquare() { return Math.abs(width - height) < 1e-9; }

        public Rectangle scale(double factor) {
            if (factor <= 0) throw new IllegalArgumentException("Factor must be > 0");
            return new Rectangle(width * factor, height * factor);
        }

        @Override
        public String toString() {
            return "Rectangle(" + width + " x " + height + ")";
        }
    }

    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(4.0, 3.0);
        System.out.println("Rectangle: " + r1);
        System.out.println("Area: " + r1.area());           // 12.0
        System.out.println("Perimeter: " + r1.perimeter()); // 14.0
        System.out.println("isSquare: " + r1.isSquare());   // false

        Rectangle r2 = new Rectangle(5.0, 5.0);
        System.out.println("isSquare: " + r2.isSquare());   // true

        Rectangle r3 = r1.scale(2.0);
        System.out.println("Scaled: " + r3);                // 8.0 x 6.0

        System.out.println("Instances: " + Rectangle.instanceCount); // 3
    }
}
