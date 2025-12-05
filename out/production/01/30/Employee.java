import java.util.*;
import java.util.stream.Collectors;

abstract class Employee {
    protected String id;
    protected String name;
    protected double baseSalary;
    public Employee(String id, String name, double baseSalary) {
        this.id = id;
        this.name = name;
        this.baseSalary = baseSalary;
    }
    public abstract double calculateSalary();
    public String getEmployeeInfo() {
        return String.format("ID: %s, 姓名: %s, 基础工资: %.2f, 实际工资: %.2f",
                id, name, baseSalary, calculateSalary());
    }
    public String getId() { return id; }
    public String getName() { return name; }
    public double getBaseSalary() { return baseSalary; }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
