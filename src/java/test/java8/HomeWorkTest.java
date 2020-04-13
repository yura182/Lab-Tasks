package java8;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class HomeWorkTest {

    @Test
    public void shouldReturnStringOfNames() {
        HomeWork homeWork = new HomeWork();
        List<String> names = Arrays.asList("Diana", "Yura", "Vasya", "Anton", "Katya", "Daria", "Sveta", "Tom");

        String expected = "1. Yura, 3. Anton, 5. Daria, 7. Tom";
        String actual = homeWork.task1(names);

        System.out.println(actual);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnEmpty() {
        HomeWork homeWork = new HomeWork();
        List<String> names = Collections.emptyList();

        String expected = "";
        String actual = homeWork.task1(names);

        System.out.println(actual);
        assertEquals(expected, actual);
    }
}