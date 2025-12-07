package solid.single_responsibility.after;

/**
 * Model danych pracownika - zgodnie z zasadą SRP.
 *
 * Jedyna odpowiedzialność: Reprezentacja danych pracownika.
 * Jeden powód do zmiany: Zmiana struktury danych pracownika.
 */
public class Employee {
    private final String name;
    private final String position;
    private final double salary;
    private final int experienceYears;

    public Employee(String name, String position, double salary, int experienceYears) {
        this.name = name;
        this.position = position;
        this.salary = salary;
        this.experienceYears = experienceYears;
    }

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

    @Override
    public String toString() {
        return "Employee{" +
               "name='" + name + '\'' +
               ", position='" + position + '\'' +
               ", salary=" + salary +
               ", experienceYears=" + experienceYears +
               '}';
    }
}


