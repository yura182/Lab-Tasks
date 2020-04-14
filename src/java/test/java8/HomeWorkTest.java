package java8;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
}