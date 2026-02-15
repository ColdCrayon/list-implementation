package edu.grinnell.csc207.lists;

import java.util.Arrays;

/**
 * An array-based implementation of the list ADT.
 */
public class ArrayList {
    int data[];
    int size;

    public ArrayList() {
        this.data = new int[0];
        this.size = 0;
    }

    /**
     * Adds <code>value</code> to the end of the list
     * 
     * @param value the value to add to the end of the list
     */
    public void add(int value) {
        int[] arr = Arrays.copyOf(this.data, this.data.length + 1);
        arr[this.data.length] = value;

        this.size++;
        this.data = arr;
    }

    /**
     * @return the number of elements in the list
     */
    public int size() {
        return this.size;
    }

    /**
     * @param index the index of the element to retrieve
     * @return the value at the specified <code>index</code>
     */
    public int get(int index) {
        if (index >= size()) {
            return -1;
        }

        return this.data[index];
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

        int removed = get(index);
        int[] arr1 = Arrays.copyOf(this.data, index);
        int[] arr2 = Arrays.copyOfRange(data, index + 1, size);

        int[] result = new int[size - 1];

        for (int i = 0; i < arr1.length; i++) {
            result[i] = arr1[i];
        }

        for (int i = 0; i < arr2.length; i++) {
            result[index + i] = arr2[i];
        }

        this.data = result;
        this.size--;

        return removed;
    }
}
