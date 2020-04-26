package java.collection.var1;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class ArrayListTest {
    private ArrayList<Integer> items;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void initList() {
        items = new ArrayList<>();
    }

    @Test
    public void isEmpty_ShouldReturnTrueForEmptyList() {
        boolean expected = true;
        boolean actual = items.isEmpty();

        assertEquals(expected, actual);
    }

    @Test
    public void isEmpty_ShouldReturnFalseForNotEmptyList() {
        items.addItem(1);

        boolean expected = false;
        boolean actual = items.isEmpty();

        assertEquals(expected, actual);
    }

    @Test
    public void size_ShouldReturnZeroIfListEmpty() {
        int expected = 0;
        int actual = items.size();

        assertEquals(expected, actual);
    }

    @Test
    public void size_ShouldReturnOneIfHasOneElement() {
        items.addItem(1);

        int expected = 1;
        int actual = items.size();

        assertEquals(expected, actual);
    }

    @Test
    public void size_ShouldReturnTwoIfListHasTwoElements() {
        items.addItem(1);
        items.addItem(2);

        int expected = 2;
        int actual = items.size();

        assertEquals(expected, actual);
    }

    @Test
    public void size_ShouldReturnThreeIfListHasThreeElements() {
        items.addItem(1);
        items.addItem(2);
        items.addItem(3);

        int expected = 3;
        int actual = items.size();

        assertEquals(expected, actual);
    }

    @Test
    public void removeItemByIndex_ShouldThrowIndexOutOfBoundsForNegativeIndex() {
        exception.expect(IndexOutOfBoundsException.class);
        exception.expectMessage("Index is out of bounds");

        items.removeItemByIndex(-1);
    }

    @Test
    public void removeItemByIndex_ShouldThrowIndexOutOfBoundsForIndexGreaterSize() {
        items.addItem(1);

        exception.expect(IndexOutOfBoundsException.class);
        exception.expectMessage("Index is out of bounds");

        items.removeItemByIndex(2);
    }

    @Test
    public void removeItemByIndex_ShouldRemoveItemByIndexForSizeThree() {
        items.addItem(1);
        items.addItem(2);
        items.addItem(3);
        items.removeItemByIndex(1);

        int expected = 2;
        int actual = items.size();

        assertEquals(expected, actual);
    }

    @Test
    public void removeItemByIndex_ShouldRemoveItemByIndexForSizeOne() {
        items.addItem(1);
        items.removeItemByIndex(0);

        int expected = 0;
        int actual = items.size();

        assertEquals(expected, actual);
    }
}