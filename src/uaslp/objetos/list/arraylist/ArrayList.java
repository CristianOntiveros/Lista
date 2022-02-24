package uaslp.objetos.list.arraylist;

public class ArrayList {
    private static final int DEFAULT_SIZE = 50;
    private String[] array;
    private int size;

    public ArrayList() {
        array = new String[DEFAULT_SIZE];
    }

    public ArrayList(int size) {
        array = new String[size];
    }

    public void addAtTail(String data) {
        if (size == array.length) {
            increaseArraySize();
        }
        array[size] = data;
        size++;
    }

    public void addAtFront(String data) {
        if (size == array.length) {
            increaseArraySize();
        }

        if (size >= 0) {
            System.arraycopy(array, 0, array, 1, size);
        }

        array[0] = data;
        size++;
    }

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

    public void removeAll() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    public void setAt(int index, String data) {
        if (index >= 0 && index < size) {
            array[index] = data;
        }
    }

    /**
     * @param index 0-index
     * @return element at position index
     */
    public String getAt(int index) {
        if (index >= 0 && index < size) {
            return array[index];
        } else {
            return null;
        }
    }

    public ArrayListIterator getIterator() {
        return new ArrayListIterator(this);
    }

    public int getSize() {
        return size;
    }

    private void increaseArraySize() {
        String[] newArray = new String[array.length * 2];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

}

