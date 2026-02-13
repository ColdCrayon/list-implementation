package edu.grinnell.csc207.lists;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.IntRange;

public class LinkedListTests {
    @Test
    public void emptyListTest() {
        LinkedList list = new LinkedList();
        assertEquals(0, list.size());
    }

    @Test
    public void singletonTest() {
        LinkedList list = new LinkedList();
        list.add(1);

        assertEquals(1, list.size());
    }

    @Test
    public void addingTest() {
        LinkedList list = new LinkedList();
        list.add(1);

        assertEquals(1, list.get(0));
    }

    @Test
    public void listAddSize10() {
        LinkedList list = new LinkedList();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        assertEquals(10, list.size());
    }

    @Test
    public void listGetTest() {
        LinkedList list = new LinkedList();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        assertEquals(list.get(0), 0);
    }

    @Test
    public void getIndexOutOfBoundsTest() {
        LinkedList list = new LinkedList();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        assertEquals(-1, list.get(10));
    }

    @Test
    public void getEmptyTest() {
        LinkedList list = new LinkedList();
        assertEquals(-1, list.get(0));
    }

    @Test
    public void listRemoveTest() {
        LinkedList list = new LinkedList();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        list.remove(0);
        assertEquals(1, list.get(0));
    }

    @Test
    public void singletonRemoveTest() {
        LinkedList list = new LinkedList();
        list.add(1);

        list.remove(0);
        assertEquals(0, list.size());
    }

    @Test
    public void dingletonRemoveTest() {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(1);

        list.remove(1);
        assertEquals(1, list.size());
    }

    @Test
    public void removeEmptyTest() {
        LinkedList list = new LinkedList();

        assertEquals(-1, list.remove(0));
    }

    @Property
    public boolean listAddSize(@ForAll @IntRange(min = 0, max = 1000) int sz) {
        LinkedList list = new LinkedList();
        for (int i = 0; i < sz; i++) {
            list.add(i);
        }
        return list.size() == sz;
    }

    @Property
    public boolean listGet(@ForAll @IntRange(min = 1, max = 1000) int sz) {
        LinkedList list = new LinkedList();
        for (int i = 0; i < sz; i++) {
            list.add(i);
        }

        return list.get(sz - 1) == sz - 1;
    }

    @Property
    public boolean listGetRandomIndex(@ForAll @IntRange(min = 0, max = 999) int index) {
        LinkedList list = new LinkedList();
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }

        return list.get(index) == index;
    }
}
