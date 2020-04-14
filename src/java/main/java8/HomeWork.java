package java8;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
}
