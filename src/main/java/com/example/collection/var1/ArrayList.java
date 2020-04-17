package com.example.collection.var1;

import com.example.collection.List;

public class ArrayList<E> implements List<E> {
    private static final int DEFAULT_SIZE = 2;

    private Object[] items;
    private int size;
    private int capacity;

    public ArrayList() {
        this.size = 0;
        this.capacity = DEFAULT_SIZE;
        this.items = new Object[DEFAULT_SIZE];
    }


    @Override
    public void addItem(E item) {
        if (size == capacity - 1) {
            grow();
        }

        items[size++] = item;
    }

    private void grow() {
        capacity *= 2;
        Object[] tempItems = new Object[capacity];
        System.arraycopy(items, 0, tempItems, 0, size);

        items = tempItems;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void removeItemByIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }

        int elementsToMove = size - index - 1;
        System.arraycopy(items, index + 1, items, index, elementsToMove);

        size--;
    }
}
