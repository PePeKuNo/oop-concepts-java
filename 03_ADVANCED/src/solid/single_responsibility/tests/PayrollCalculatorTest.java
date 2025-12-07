package solid.single_responsibility.tests;

import solid.single_responsibility.after.Employee;
import solid.single_responsibility.after.PayrollCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Testy jednostkowe dla PayrollCalculator.
 *
 * Dzięki SRP, PayrollCalculator może być testowany niezależnie,
 * bez potrzeby mockowania bazy danych czy generatorów raportów.
 */
@DisplayName("PayrollCalculator Tests")
class PayrollCalculatorTest {

    private PayrollCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new PayrollCalculator();
    }

    @Test
    @DisplayName("Should calculate pay for Developer with base salary")
    void shouldCalculatePayForDeveloper() {
        // Given
        Employee developer = new Employee("John Doe", "Developer", 5000.0, 3);

        // When
        double pay = calculator.calculatePay(developer);

        // Then
        // Base: 5000 * 1.1 (Developer bonus) = 5500
        // Experience: 3 * 100 = 300
        // Total: 5800
        assertEquals(5800.0, pay, 0.01);
    }

    @Test
    @DisplayName("Should calculate pay for Senior Developer")
    void shouldCalculatePayForSeniorDeveloper() {
        // Given
        Employee seniorDev = new Employee("Jane Smith", "Senior Developer", 8000.0, 5);

        // When
        double pay = calculator.calculatePay(seniorDev);

        // Then
        // Base: 8000 * 1.2 (Senior Developer bonus) = 9600
        // Experience: 5 * 100 = 500
        // Total: 10100
        assertEquals(10100.0, pay, 0.01);
    }

    @Test
    @DisplayName("Should calculate pay for Manager")
    void shouldCalculatePayForManager() {
        // Given
        Employee manager = new Employee("Bob Manager", "Manager", 10000.0, 8);

        // When
        double pay = calculator.calculatePay(manager);

        // Then
        // Base: 10000 * 1.3 (Manager bonus) = 13000
        // Experience: 8 * 100 = 800
        // Total: 13800
        assertEquals(13800.0, pay, 0.01);
    }

    @Test
    @DisplayName("Should calculate pay for unknown position without bonus")
    void shouldCalculatePayForUnknownPosition() {
        // Given
        Employee intern = new Employee("Alice Intern", "Intern", 3000.0, 0);

        // When
        double pay = calculator.calculatePay(intern);

        // Then
        // Base: 3000 (no bonus)
        // Experience: 0 * 100 = 0
        // Total: 3000
        assertEquals(3000.0, pay, 0.01);
    }

    @Test
    @DisplayName("Should calculate annual pay correctly")
    void shouldCalculateAnnualPay() {
        // Given
        Employee employee = new Employee("Test User", "Developer", 5000.0, 2);

        // When
        double annualPay = calculator.calculateAnnualPay(employee);

        // Then
        // Monthly: 5000 * 1.1 + 200 = 5700
        // Annual: 5700 * 12 = 68400
        assertEquals(68400.0, annualPay, 0.01);
    }

    @Test
    @DisplayName("Should calculate insurance correctly")
    void shouldCalculateInsurance() {
        // Given
        Employee employee = new Employee("Test User", "Developer", 5000.0, 2);

        // When
        double insurance = calculator.calculateInsurance(employee);

        // Then
        // Pay: 5000 * 1.1 + 200 = 5700
        // Insurance: 5700 * 0.15 = 855
        assertEquals(855.0, insurance, 0.01);
    }

    @Test
    @DisplayName("Should handle zero experience")
    void shouldHandleZeroExperience() {
        // Given
        Employee newbie = new Employee("Newbie", "Developer", 4000.0, 0);

        // When
        double pay = calculator.calculatePay(newbie);

        // Then
        assertEquals(4400.0, pay, 0.01); // 4000 * 1.1 + 0
    }

    @Test
    @DisplayName("Should handle high experience")
    void shouldHandleHighExperience() {
        // Given
        Employee veteran = new Employee("Veteran", "Senior Developer", 12000.0, 15);

        // When
        double pay = calculator.calculatePay(veteran);

        // Then
        // Base: 12000 * 1.2 = 14400
        // Experience: 15 * 100 = 1500
        // Total: 15900
        assertEquals(15900.0, pay, 0.01);
    }
}


