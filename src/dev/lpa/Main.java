package dev.lpa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        List<String> bingoPool = new ArrayList<>(75);

        int start = 1;
        for (char c : "BINGO".toCharArray()) {
            for (int i = start; i < (start + 15); i++) {
                bingoPool.add("" + c + i);
//                System.out.println("" + c + i);
            }
            start += 15;
        }

        Collections.shuffle(bingoPool);
        for (int i = 0; i < 15; i++) {
            System.out.println(bingoPool.get(i));
        }
        System.out.println("------------------------------------");

//        List<String> firstOnes = bingoPool.subList(0, 15);
        List<String> firstOnes = new ArrayList<>(bingoPool.subList(0, 15));
        firstOnes.sort(Comparator.naturalOrder());
        firstOnes.replaceAll(s -> {
            if (s.indexOf('G') == 0 || s.indexOf("O") == 0) {
                String updated = s.charAt(0) + "-" + s.substring(1);
                System.out.print(updated + " ");
                return updated;
            }
            return s;
        });
        System.out.println("\n----------------------------------");

        for (int i = 0; i < 15; i++) {
            System.out.println(bingoPool.get(i));
        }
        System.out.println("------------------------------------");

        bingoPool.stream()
                .limit(15)
                .filter(s -> s.indexOf('G') == 0 || s.indexOf("O") == 0)
                .map(s -> s.charAt(0) + "-" + s.substring(1))
                .sorted()
                .forEach(s -> System.out.print(s + " "));

        System.out.println("\n----------------------------------");

        for (int i = 0; i < 15; i++) {
            System.out.println(bingoPool.get(i));
        }

        createAndPrintBingoPoolList();
    }

    public static void createAndPrintBingoPoolList() {

        System.out.println("----------------------------------");

        Stream<String> bStream = IntStream.range(1, 16)
                .mapToObj(i -> "B-" + i);

        Stream<String> iStream = IntStream.range(16, 31)
                .mapToObj(i -> "I-" + i);

        Stream<String> nStream = IntStream.range(31, 46)
                .mapToObj(i -> "N-"+ i);

        Stream<String> gStream = IntStream.range(46, 61)
                .mapToObj(i -> "G-" + i);

        Stream<String> oStream = IntStream.range(61, 76)
                .mapToObj(i -> "O-" + i);

        Stream.of(bStream, iStream, nStream, gStream, oStream)
                .flatMap(s -> s)
                .forEach(System.out::println);
    }
}
