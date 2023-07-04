package com.example.touchingawss3.collection;

import java.util.ArrayList;
import java.util.List;

public class FixedLengthQueue<E> {

    private static final int QUEUE_SIZE = 3;

    private Node<E> first;
    private Node<E> last;
    private int size = 0;

    public void add(E element) {

        if (size() == 0) {
            first = new Node<>(null, element, null);
            last = first;

            size++;
            return;
        }

        if (size() == 1) {
            last = new Node<>(first, element, null);
            first.next = last;

            size++;
            return;
        }

        if (size() < QUEUE_SIZE) {
            Node<E> append = new Node<>(last, element, null);
            last.next = append;
            last = append;

            size++;
            return;
        }

        if (size() == QUEUE_SIZE) {
            first =  first.next;
            first.prev = null;

            Node<E> append = new Node<>(last, element, null);
            last.next = append;
            last = append;
        }
    }

    public E get() {
        if (size() != 0) {
            return last.value;
        } else {
            return null;
        }
    }

    public List<E> getAll(){
        List<E> result = new ArrayList<>();

        int i = 0;
        Node<E> element = first;
        while (i < size()) {
            result.add(element.value);
            element = element.next;
            i++;
        }
        return result;
    }

    public int size() {
        return size;
    }

    private static class Node<E> {
        E value;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.value = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
