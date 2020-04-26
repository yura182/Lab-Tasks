package java.collection.var1;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class LinkedListTest {
    private LinkedList<Integer> items;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void initList() {
        items = new LinkedList<>();
    }

    @Test
    public void isEmpty_ShouldReturnTrueForEmptyList() {
        boolean expected = true;
        boolean actual = items.isEmpty();

        assertEquals(expected, actual);
    }

    @Test
    public void isEmpty_ShouldReturnFalseForNonEmptyList() {
        items.addItem(1);

        boolean expected = false;
        boolean actual = items.isEmpty();

        assertEquals(expected, actual);
    }

    @Test
    public void size_ShouldReturnZeroForEmptyList() {
        int expected = 0;
        int actual = items.size();

        assertEquals(expected, actual);
    }

    @Test
    public void size_ShouldReturnOneForOneElement() {
        items.addItem(0);

        int expected = 1;
        int actual = items.size();

        assertEquals(expected, actual);
    }

    @Test
    public void removeItemByIndex_ShouldThrowIndexOutOfBoundsExceptionForNegativeIndex() {
        exception.expect(IndexOutOfBoundsException.class);
        exception.expectMessage("Index is out of bounds");

        items.removeItemByIndex(-1);
    }

    @Test
    public void removeItemByIndex_ShouldThrowIndexOutOfBoundsExceptionForIndexGreaterSize() {
        items.addItem(1);

        exception.expect(IndexOutOfBoundsException.class);
        exception.expectMessage("Index is out of bounds");

        items.removeItemByIndex(1);
    }

    @Test
    public void removeItemByIndex_ShouldRemoveElementByIndex() {
        items.addItem(0);

        items.removeItemByIndex(0);

        int expected = 0;
        int actual = items.size();

        assertEquals(expected, actual);
    }
}