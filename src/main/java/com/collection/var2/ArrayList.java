package java.collection.var2;

import java.collection.List;

public class ArrayList<E> implements List<E> {
    private int size;

    @Override
    public void addItem(E item) {
        size++;
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
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        size--;
    }
}
