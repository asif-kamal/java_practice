package dev.lpa;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

        List<String> sentences = Arrays.asList(
                "Java Stream API provides a fluent interface for processing sequences of elements.",
                "It supports functional-style operations on streams of elements, such as map-reduce transformations.",
                "In this exercise, you need to count the total number of words in all sentences."
        );

        //String joinedSentences = String.join("", sentences);
        long distinctWordCount = sentences.stream()
                .flatMap(sentence -> Arrays.stream(sentence.split("\\W+")))
                .map(String::toLowerCase)
                .distinct()
                .count();

        System.out.println(distinctWordCount);

        List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "elderberry");
        String firstTwoEvenLengthWords = words.stream()
                .filter(word -> word.length() % 2 == 0)
                .limit(2)
                .collect(Collectors.joining());

        System.out.println(firstTwoEvenLengthWords);

        List<Integer> numbersTwo = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        int sum = numbersTwo.stream()
                .filter(number -> number % 2 == 0)
                .map(number -> number * number)
                .reduce(0, Integer::sum);

        System.out.println(sum);

    }
}