package java8;

import java.util.Arrays;
import java.util.Comparator;
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
                .map(n -> n.split("\\D+"))
                .flatMap(Arrays::stream)
                .collect(Collectors.joining(","));
    }

    public String task3v2(List<String> numbers) {
        return String.join(",", numbers);
    }
}
