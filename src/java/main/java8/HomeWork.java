package java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class HomeWork {

    /**
     * The method takes a list of names. Returns a string of the form "1. Ivan, 3. Peter ...", only with
     * names on odd indices, respectively
     */
    public String task1(List<String> names) {
        return IntStream.range(0, names.size())
                .filter(index -> index % 2 != 0)
                .mapToObj(index -> index + ". " + names.get(index))
                .collect(Collectors.joining(", "));
    }

    /**
     * The method map list of string to uppercase and then sort descending
     */
    public List<String> task2(List<String> strings) {
        return strings.stream()
                .map(String::toUpperCase)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    /**
     * Given and collection = Arrays.asList ("1, 2, 0", "4, 5")
     * From the collection get all the numbers listed, separated by commas from all the elements
     */
    public String task3v1(List<String> numbers) {
        return numbers.stream()
                .flatMap(x -> Arrays.stream(x.split("\\D")))
                .collect(Collectors.joining(","));
    }

    public String task3v2(List<String> numbers) {
        return String.join(",", numbers);
    }

    /**
     * Using Stream.iterate, make an infinite stream of random numbers — not by
     * calling Math.random but by directly implementing a linear congruential generator. In such a
     * generator, you start with x[0] = seed and then produce x[n + 1] = 1 (a x[n] + c) % m, for
     * appropriate values of a, c, and m. You should implement a method with parameters a, c, m,
     * and seed that yields a Stream<Long>. Try out a = 25214903917, c = 11, and m = 2^48.
     */
    public Stream<Long> task4(long a, long c, long m, long seed) {
        return Stream.iterate(seed, r -> (a * r + c) % m);
    }

    /**
     * Write a method public <T> Stream<T> zip(Stream<T> first, Stream<T> second) that
     * alternates elements from the stream first and second, stopping when one of them runs out of
     * elements.
     */
    public static <T> Stream<T> task5(Stream<T> first, Stream<T> second) {
        Iterator<T> i2 = second.iterator();

        Stream.Builder<T> builder = Stream.builder();

        first.forEach(x -> {
            if (i2.hasNext()) {
                builder.add(x);
                builder.add(i2.next());
            }
        });

        return  builder.build();
    }
}
