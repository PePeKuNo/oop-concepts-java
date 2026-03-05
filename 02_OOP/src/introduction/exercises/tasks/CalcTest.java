package introduction.exercises.tasks;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class CalcTest {

    private CalcTask.Calculator calc;

    @BeforeEach
    void setUp() { calc = new CalcTask.Calculator(); }

    @Test
    void add_TwoPositive_ReturnsSum() {
        assertEquals(5.0, calc.add(2, 3), 1e-9);
    }

    @Test
    void add_WithNegative_ReturnsCorrect() {
        assertEquals(0.0, calc.add(-1, 1), 1e-9);
        assertEquals(-3.0, calc.add(-1, -2), 1e-9);
    }

    @Test
    void subtract_ReturnsCorrect() {
        assertEquals(1.0, calc.subtract(3, 2), 1e-9);
        assertEquals(-5.0, calc.subtract(0, 5), 1e-9);
    }

    @Test
    void multiply_WithZero_ReturnsZero() {
        assertEquals(0.0, calc.multiply(5, 0), 1e-9);
    }

    @Test
    void multiply_TwoValues_ReturnsProduct() {
        assertEquals(12.0, calc.multiply(3, 4), 1e-9);
    }

    @Test
    void divide_ByZero_ThrowsArithmeticException() {
        assertThrows(ArithmeticException.class, () -> calc.divide(10, 0));
    }

    @Test
    void divide_ValidValues_ReturnsQuotient() {
        assertEquals(2.5, calc.divide(10, 4), 1e-9);
    }

    @Test
    void power_NegativeExponent_ReturnsCorrect() {
        assertEquals(0.5, calc.power(2, -1), 1e-9);
    }

    @Test
    void power_ZeroExponent_ReturnsOne() {
        assertEquals(1.0, calc.power(5, 0), 1e-9);
    }

    @Test
    void sqrt_ValidValue_ReturnsRoot() {
        assertEquals(4.0, calc.sqrt(16), 1e-9);
    }

    @Test
    void sqrt_Negative_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> calc.sqrt(-1));
    }

    @Test
    void history_RecordsOperations() {
        calc.add(2, 3);
        calc.divide(10, 4);
        var hist = calc.getHistory();
        assertEquals(2, hist.size());
        assertTrue(hist.get(0).contains("add"));
        assertTrue(hist.get(1).contains("divide"));
    }

    @Test
    void clearHistory_EmptiesHistory() {
        calc.add(1, 2);
        calc.clearHistory();
        assertTrue(calc.getHistory().isEmpty());
    }
}
