import java.util.*;
class Employee {
    String name;
    int age;
    double salary;
    Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
    public String toString() {
        return name + " - Age: " + age + ", Salary: " + salary;
    }
}
public class PartA {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("Aarav", 28, 55000),
            new Employee("Riya", 24, 70000),
            new Employee("Karan", 32, 45000),
            new Employee("Meera", 29, 90000)
        );
        System.out.println("Sort by Name:");
        employees.stream().sorted((e1, e2) -> e1.name.compareTo(e2.name)).forEach(System.out::println);

        System.out.println("\nSort by Age:");
        employees.stream().sorted(Comparator.comparingInt(e -> e.age)).forEach(System.out::println);

        System.out.println("\nSort by Salary Descending:");
        employees.stream().sorted((e1, e2) -> Double.compare(e2.salary, e1.salary)).forEach(System.out::println);
    }
}
