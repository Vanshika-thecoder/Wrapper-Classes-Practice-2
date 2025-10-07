import java.util.*;
import java.util.stream.*;
class Student {
    String name;
    double marks;
    Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }
    public String toString() {
        return name + " - Marks: " + marks;
    }
}
public class PartB {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Ananya", 82),
            new Student("Rohit", 68),
            new Student("Sneha", 91),
            new Student("Arjun", 76),
            new Student("Isha", 54)
        );
        System.out.println("Students Scoring Above 75% (Sorted by Marks):");
        students.stream()
            .filter(s -> s.marks > 75)
            .sorted(Comparator.comparingDouble(s -> s.marks))
            .map(s -> s.name)
            .forEach(System.out::println);
    }
}
