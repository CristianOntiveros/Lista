package uaslp.objetos.list.arraylist;

import uaslp.objetos.list.Iterator;
import uaslp.objetos.list.List;

public class ArrayList <T> implements List<T> {
    private static final int DEFAULT_SIZE = 50;
    private T[] array;
    private int size;

    public ArrayList() {
        array = (T[]) new Object[DEFAULT_SIZE];
    }

    public ArrayList(int size) {
        array = (T[]) new Object[size];
    }

    @Override
    public void addAtTail(T data) {
        if (size == array.length) {
            increaseArraySize();
        }
        array[size] = data;
        size++;
    }

    @Override
    public void addAtFront(T data) {
        if (size == array.length) {
            increaseArraySize();
        }

        if (size >= 0) {
            System.arraycopy(array, 0, array, 1, size);
        }

        array[0] = data;
        size++;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            return;
        }

        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        array[size - 1] = null;
        size--;
    }

    @Override
    public void removeAll() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    @Override
    public void setAt(int index, T data) {
        if (index >= 0 && index < size) {
            array[index] = data;
        }
    }

    /**
     * @param index 0-index
     * @return element at position index
     */

    @Override
    public T getAt(int index) {
        if (index >= 0 && index < size) {
            return array[index];
        } else {
            return null;
        }
    }

    @Override
    public Iterator<T> getIterator() {
        return new ArrayListIterator<>(this);
    }

    @Override
    public int getSize() {
        return size;
    }

    private void increaseArraySize() {
        T[] newArray = (T[]) new Object[array.length * 2];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

}

