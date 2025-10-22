package dev.lpa;

import java.util.Arrays;
import java.util.List;

public class MainTwo {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        // Write your code here
        List<Integer> squaredNumbers = numbers.stream()
                .map(n -> n * n)
                .toList();

        System.out.println(squaredNumbers);

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eva");
        names.stream()
                .mapToInt(String::length)
                .max()
                .ifPresent(System.out::println);


    }
}