package introduction.exercises.tasks;

import java.util.ArrayList;
import java.util.List;

/**
 * ZADANIE 4: TDD — Kalkulator
 */
public class CalcTask {

    public static class Calculator {
        private final List<String> history = new ArrayList<>();

        public double add(double a, double b) {
            double result = a + b;
            history.add("add(" + a + "," + b + ")=" + result);
            return result;
        }

        public double subtract(double a, double b) {
            double result = a - b;
            history.add("subtract(" + a + "," + b + ")=" + result);
            return result;
        }

        public double multiply(double a, double b) {
            double result = a * b;
            history.add("multiply(" + a + "," + b + ")=" + result);
            return result;
        }

        public double divide(double a, double b) {
            if (b == 0) throw new ArithmeticException("Division by zero");
            double result = a / b;
            history.add("divide(" + a + "," + b + ")=" + result);
            return result;
        }

        public double power(double base, int exponent) {
            double result = Math.pow(base, exponent);
            history.add("power(" + base + "," + exponent + ")=" + result);
            return result;
        }

        public double sqrt(double n) {
            if (n < 0) throw new IllegalArgumentException("Cannot sqrt negative number: " + n);
            double result = Math.sqrt(n);
            history.add("sqrt(" + n + ")=" + result);
            return result;
        }

        public List<String> getHistory()  { return new ArrayList<>(history); }
        public void clearHistory()        { history.clear(); }
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println(calc.add(2, 3));       // 5.0
        System.out.println(calc.divide(10, 4));   // 2.5
        System.out.println(calc.power(2, 10));    // 1024.0
        System.out.println(calc.sqrt(16));        // 4.0
        System.out.println(calc.getHistory());
    }
}
