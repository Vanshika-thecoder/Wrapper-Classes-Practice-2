import java.util.*;
import java.util.stream.*;
import java.util.Comparator;
class Product {
    String name, category;
    double price;
    Product(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }
    public String toString() {
        return name + " (" + category + ") - ₹" + price;
    }
}
public class PartC {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Laptop", 80000, "Electronics"),
            new Product("Headphones", 3000, "Electronics"),
            new Product("Shirt", 1500, "Clothing"),
            new Product("Pants", 2000, "Clothing"),
            new Product("Watch", 6000, "Accessories"),
            new Product("Necklace", 12000, "Accessories")
        );
        System.out.println("Products Grouped by Category:");
        Map<String, List<Product>> grouped = products.stream()
            .collect(Collectors.groupingBy(p -> p.category));
        grouped.forEach((cat, list) -> System.out.println(cat + ": " + list));

        System.out.println("\nMost Expensive Product in Each Category:");
        Map<String, Optional<Product>> expensive = products.stream()
            .collect(Collectors.groupingBy(p -> p.category, Collectors.maxBy(Comparator.comparingDouble(p -> p.price))));
        expensive.forEach((cat, prod) -> System.out.println(cat + ": " + prod.get()));
        double avgPrice = products.stream().collect(Collectors.averagingDouble(p -> p.price));
        System.out.println("\nAverage Price of All Products: ₹" + avgPrice);
    }
}
