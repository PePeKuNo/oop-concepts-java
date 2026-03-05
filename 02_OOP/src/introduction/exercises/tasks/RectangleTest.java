package introduction.exercises.tasks;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class RectangleTest {

    @BeforeEach
    void resetCounter() {
        RectangleTask.Rectangle.instanceCount = 0;
    }

    @Test
    void constructor_ValidValues_CreatesRectangle() {
        var r = new RectangleTask.Rectangle(4.0, 3.0);
        assertEquals(4.0, r.getWidth(), 1e-9);
        assertEquals(3.0, r.getHeight(), 1e-9);
    }

    @Test
    void constructor_ZeroWidth_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> new RectangleTask.Rectangle(0, 3));
    }

    @Test
    void constructor_NegativeHeight_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> new RectangleTask.Rectangle(4, -1));
    }

    @Test
    void area_ReturnsWidthTimesHeight() {
        var r = new RectangleTask.Rectangle(4.0, 3.0);
        assertEquals(12.0, r.area(), 1e-9);
    }

    @Test
    void perimeter_ReturnsCorrectValue() {
        var r = new RectangleTask.Rectangle(4.0, 3.0);
        assertEquals(14.0, r.perimeter(), 1e-9);
    }

    @Test
    void isSquare_EqualSides_ReturnsTrue() {
        var r = new RectangleTask.Rectangle(5.0, 5.0);
        assertTrue(r.isSquare());
    }

    @Test
    void isSquare_DifferentSides_ReturnsFalse() {
        var r = new RectangleTask.Rectangle(4.0, 3.0);
        assertFalse(r.isSquare());
    }

    @Test
    void scale_ReturnsNewObject() {
        var r = new RectangleTask.Rectangle(4.0, 3.0);
        var scaled = r.scale(2.0);
        assertNotSame(r, scaled);
        assertEquals(8.0, scaled.getWidth(), 1e-9);
        assertEquals(6.0, scaled.getHeight(), 1e-9);
        // original unchanged
        assertEquals(4.0, r.getWidth(), 1e-9);
    }

    @Test
    void setter_ZeroValue_ThrowsException() {
        var r = new RectangleTask.Rectangle(4.0, 3.0);
        assertThrows(IllegalArgumentException.class, () -> r.setWidth(0));
        assertThrows(IllegalArgumentException.class, () -> r.setHeight(-5));
    }

    @Test
    void instanceCount_IncreasesOnCreation() {
        new RectangleTask.Rectangle(1, 1);
        new RectangleTask.Rectangle(2, 2);
        new RectangleTask.Rectangle(3, 3);
        assertEquals(3, RectangleTask.Rectangle.instanceCount);
    }
}
