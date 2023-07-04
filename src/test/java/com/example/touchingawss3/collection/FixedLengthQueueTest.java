package com.example.touchingawss3.collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class FixedLengthQueueTest {

    FixedLengthQueue<String> queue;

    @BeforeEach
    public void init() {
        queue = new FixedLengthQueue<>();
    }

    @Test
    public void add() {
        assertEquals(null, queue.get());
        queue.add("someValue");
        assertEquals("someValue", queue.get());
    }

    @Test
    public void size() {
        assertEquals(0, queue.size());

        queue.add("1");
        assertEquals(1, queue.size());

        queue.add("2");
        assertEquals(2, queue.size());

        queue.add("3");
        assertEquals(3, queue.size());

        queue.add("4");
        assertEquals(3, queue.size());
    }

    @Test
    public void get() {
        queue.add("1");
        assertEquals("1", queue.get());

        queue.add("secondValue");
        assertEquals("secondValue", queue.get());
    }

    @Test
    public void getAll() {
        queue.add("0");
        queue.add("1");
        queue.add("2");
        queue.add("3");
        queue.add("4");

//      Если размерм очереди QUEUE_SIZE = 3
        List<String> list = List.of("2", "3", "4");
        assertEquals(list, queue.getAll());
    }

}