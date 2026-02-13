package edu.grinnell.csc207.lists;

/**
 * A linked implementation of the list ADT.
 */
public class LinkedList {
    private static class Node {
        private int value;
        private Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        /**
         * Construct a new node from the given value
         * 
         * @param value the value
         */
        public Node(int value) {
            this(value, null);
        }
    }

    private Node first;

    public LinkedList() {
        this.first = null;
    }

    /**
     * Adds <code>value</code> to the end of the list
     * 
     * @param value the value to add to the end of the list
     */
    public void add(int value) {
        Node next = new Node(value);

        if (size() == 0) {
            this.first = next;
        } else {
            Node curr = this.first;
            for (; curr.next != null; curr = curr.next) {
                // moves curr to the end of the list
            }

            curr.next = next;
        }
    }

    /**
     * @return the number of elements in the list
     */
    public int size() {
        int count = 0;
        for (Node curr = this.first; curr != null; curr = curr.next) {
            count++;
        }

        return count;
    }

    /**
     * @param index the index of the element to retrieve
     * @return the value at the specified <code>index</code>
     */
    public int get(int index) {
        if (index >= size()) {
            return -1;
        }

        Node curr = this.first;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }

        return curr.value;
    }

    /**
     * Removes the value at <code>index</code> from the list
     * 
     * @param index the index of the element to remove
     * @return the element at <code>index</code>
     */
    public int remove(int index) {
        if (index >= size()) {
            return -1;
        }

        Node curr = this.first;
        int value = 0;

        if (index == 0) {
            value = this.first.value;
            this.first = curr.next;
        }

        for (int i = 1; i < index - 1; i++) {
            curr = curr.next;
        }

        if (curr.next != null) {
            value = curr.next.value;
            curr.next = curr.next.next;
        }

        return value;
    }
}
