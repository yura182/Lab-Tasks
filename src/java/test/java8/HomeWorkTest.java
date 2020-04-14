package java8;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class HomeWorkTest {

    private HomeWork homeWork = new HomeWork();

    @Test
    public void shouldReturnStringOfNamesTask1() {
        List<String> names = Arrays.asList("Diana", "Yura", "Vasya", "Anton", "Katya", "Daria", "Sveta", "Tom");

        String expected = "1. Yura, 3. Anton, 5. Daria, 7. Tom";
        String actual = homeWork.task1(names);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnEmptyTask1() {
        List<String> names = Collections.emptyList();

        String expected = "";
        String actual = homeWork.task1(names);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnListOfStringsTask2() {
        List<String> strings = Arrays.asList("Always", "run", "cats");

        List<String> actual = homeWork.task2(strings);
        List<String> expected = Arrays.asList("RUN", "CATS", "ALWAYS");

        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnStringTask3v1() {
        List<String> strings = Arrays.asList("1, 2, 0", "4, 5");

        String actual = homeWork.task3v1(strings);
        String expected = "1,2,0,4,5";

        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnStringTask3v2() {
        List<String> strings = Arrays.asList("1,2,0", "4,5");

        String actual = homeWork.task3v2(strings);
        String expected = "1,2,0,4,5";

        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnRandomStreamTask4() {
        homeWork.task4(25214903917L, 11L, (long) Math.pow(2, 48), 10L)
                .limit(10)
                .forEach(System.out::println);
    }

    @Test
    public void shouldReturnStreamTask5() {
        Stream<Integer> first = Stream.of(1, 2, 3, 4);
        Stream<Integer> second = Stream.of(10, 20, 30);

        List<Integer> actual = HomeWork.task5(first, second).collect(Collectors.toList());
        List<Integer> expected = Arrays.asList(1, 10, 2, 20, 3, 30);

        assertEquals(expected, actual);
    }
}