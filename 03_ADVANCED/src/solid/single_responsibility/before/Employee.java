package solid.single_responsibility.before;

/**
 * Przykład naruszenia zasady Single Responsibility Principle.
 *
 * Ta klasa ma zbyt wiele odpowiedzialności:
 * 1. Reprezentacja danych pracownika
 * 2. Obliczanie wynagrodzenia (logika biznesowa)
 * 3. Persystencja danych (zapis do bazy)
 * 4. Raportowanie (generowanie raportów)
 *
 * Powody do zmiany:
 * - Zmiana struktury danych pracownika
 * - Zmiana zasad obliczania wynagrodzenia
 * - Zmiana technologii bazy danych
 * - Zmiana formatu raportów
 */
public class Employee {
    private String name;
    private String position;
    private double salary;
    private int experienceYears;

    public Employee(String name, String position, double salary, int experienceYears) {
        this.name = name;
        this.position = position;
        this.salary = salary;
        this.experienceYears = experienceYears;
    }

    // Gettery i settery
    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    // ODPOWIEDZIALNOŚĆ 1: Logika biznesowa - obliczanie wynagrodzenia
    public double calculatePay() {
        double basePay = salary;

        // Premie zależne od stanowiska
        if (position.equals("Manager")) {
            basePay *= 1.3;
        } else if (position.equals("Senior Developer")) {
            basePay *= 1.2;
        } else if (position.equals("Developer")) {
            basePay *= 1.1;
        }

        // Dodatek za staż
        basePay += experienceYears * 100;

        return basePay;
    }

    // ODPOWIEDZIALNOŚĆ 2: Persystencja - zapis do bazy danych
    public void save() {
        System.out.println("Connecting to database...");
        System.out.println("Saving employee: " + name);
        System.out.println("SQL: INSERT INTO employees (name, position, salary) VALUES ('"
            + name + "', '" + position + "', " + salary + ")");
        System.out.println("Employee saved successfully!");
    }

    // ODPOWIEDZIALNOŚĆ 3: Raportowanie - generowanie raportu
    public String generateReport() {
        StringBuilder report = new StringBuilder();
        report.append("═══════════════════════════════════════\n");
        report.append("         EMPLOYEE REPORT\n");
        report.append("═══════════════════════════════════════\n");
        report.append("Name:            ").append(name).append("\n");
        report.append("Position:        ").append(position).append("\n");
        report.append("Base Salary:     $").append(String.format("%.2f", salary)).append("\n");
        report.append("Experience:      ").append(experienceYears).append(" years\n");
        report.append("Calculated Pay:  $").append(String.format("%.2f", calculatePay())).append("\n");
        report.append("═══════════════════════════════════════\n");
        return report.toString();
    }

    // ODPOWIEDZIALNOŚĆ 4: Dodatkowe raportowanie - generowanie JSON
    public String toJson() {
        return "{\n" +
               "  \"name\": \"" + name + "\",\n" +
               "  \"position\": \"" + position + "\",\n" +
               "  \"salary\": " + salary + ",\n" +
               "  \"experienceYears\": " + experienceYears + ",\n" +
               "  \"calculatedPay\": " + calculatePay() + "\n" +
               "}";
    }
}


