package J8;

import java.util.*;
import java.util.stream.Collectors;

/*
* In Java 8, map() and flatMap() are both intermediate operations in streams, but they serve different purposes. Here's how they differ:

1. map()
Purpose: map() is used when you want to transform each element of a stream into another object or type. The function you provide returns a single value for each input element.
Output: A stream where each input element is transformed individually.
Example:

List<String> words = Arrays.asList("hello", "world");
List<Integer> wordLengths = words.stream()
                                 .map(String::length)
                                 .collect(Collectors.toList());
System.out.println(wordLengths);  // Output: [5, 5]
In this example, map() transforms each string into its length.

2. flatMap()
Purpose: flatMap() is used when each element in a stream needs to be transformed into multiple elements or another stream, and you want to "flatten" the results into a single stream.
Output: A stream where each input element can produce zero, one, or many output elements (flattened into a single stream).
Example:

List<List<String>> wordsList = Arrays.asList(
    Arrays.asList("hello", "world"),
    Arrays.asList("java", "streams")
);

List<String> allWords = wordsList.stream()
                                 .flatMap(Collection::stream)
                                 .collect(Collectors.toList());
System.out.println(allWords);  // Output: [hello, world, java, streams]
In this case, flatMap() flattens multiple lists into a single stream of words.

Key Differences:
map(): Transforms elements one-to-one, i.e., for each input element, it returns exactly one output.
flatMap(): Transforms elements one-to-many (or zero-to-many), i.e., it can return multiple elements (in the form of a stream) for each input element and flattens them into a single stream.
Use map() when the function returns a single value and flatMap() when the function returns a stream or collection of values.
*
* ---Below is a real life example of flatmap----------
*
* A real-life example of using flatMap() in Java 8 can be seen in processing data like orders in an e-commerce platform. Suppose you have a list of customer orders, and each order contains a list of purchased products. You want to extract a unique list of all the products that have been purchased by all customers. Here's how flatMap() can help in this situation:

Scenario:
Each customer order contains multiple products.
You want to flatten all products from all orders into a single list to easily get a unique list of all purchased products.
* */

class Order {
    private List<String> products;

    public Order(List<String> products) {
        this.products = products;
    }

    public List<String> getProducts() {
        return products;
    }
}

public class FlatMapExample {
    public static void main(String[] args) {
        // Orders with multiple products
        List<Order> orders = Arrays.asList(
                new Order(Arrays.asList("Laptop", "Mouse")),
                new Order(Arrays.asList("Keyboard", "Monitor")),
                new Order(Arrays.asList("Mouse", "Monitor", "Laptop")),
                new Order(Arrays.asList("Desk", "Chair"))
        );

        // Use flatMap to extract and flatten all product lists into a single stream
        List<String> allProducts = orders.stream()
                .flatMap(order -> order.getProducts().stream())  // Flatten each order's product list into one stream
                .distinct()  // Remove duplicates
                .collect(Collectors.toList());

        System.out.println("All distinct products purchased: " + allProducts);
    }
}
