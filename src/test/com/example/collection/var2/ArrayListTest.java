package com.example.collection.var2;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

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
    public void size_ShouldReturnZeroForEmptyList() {
        int expected = 0;
        int actual = items.size();

        assertEquals(expected, actual);
    }

    @Test
    public void size_ShouldReturnOneForOneItemInList() {
        items.addItem(1);

        int expected = 1;
        int actual = items.size();

        assertEquals(expected, actual);
    }

    @Test
    public void removeItemByIndex_ShouldThrowIndexOutOfBoundsForNegativeIndex() {
        exception.expect(IndexOutOfBoundsException.class);
        exception.expectMessage("Index out of bounds");

        items.removeItemByIndex(-2);
    }

    @Test
    public void removeItemByIndex_ShouldThrowIndexOutOfBoundsForIndexGreaterSize() {
        items.addItem(1);

        exception.expect(IndexOutOfBoundsException.class);
        exception.expectMessage("Index out of bounds");

        items.removeItemByIndex(1);
    }

    @Test
    public void removeItemByIndex_ShouldRemoveItem() {
        items.addItem(1);
        items.addItem(2);
        items.removeItemByIndex(1);

        int expected = 1;
        int actual = items.size();

        assertEquals(expected, actual);
    }
}