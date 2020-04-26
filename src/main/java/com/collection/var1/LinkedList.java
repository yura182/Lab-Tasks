package java.collection.var1;

import java.collection.List;

public class LinkedList<E> implements List<E> {
    private int size;
    private Node<E> first;
    private Node<E> current;

    public LinkedList() {
        size = 0;
    }

    @Override
    public void addItem(E item) {
        if (first == null) {
            addFirst(item);
        } else {
            addElement(item);
        }

        size++;
    }

    private void addElement(E item) {
        Node<E> newNode = new Node<>(item, null, current);
        current.next = newNode;
        current = newNode;
    }

    private void addFirst(E item) {
        first = new Node<>(item, null, null);
        current = first;
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

        Node<E> nodeToRemove = getNodeToDelete(index);

        if (nodeToRemove.prev != null) {
            nodeToRemove.prev.next = nodeToRemove.next;
        } else {
            first = nodeToRemove.next;
        }

        if (nodeToRemove.next != null) {
            nodeToRemove.next.prev = nodeToRemove.prev;
        } else {
            current = nodeToRemove.prev;
        }

        size--;
    }

    private Node<E> getNodeToDelete(int index) {
        Node<E> nodeToRemove = first;

        for (int i = 0; i < index; i++) {
            nodeToRemove = nodeToRemove.next;
        }
        return nodeToRemove;
    }

    private static class Node<E> {
        E element;
        Node<E> next;
        Node<E> prev;

        Node(E element, Node<E> next, Node<E> prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
