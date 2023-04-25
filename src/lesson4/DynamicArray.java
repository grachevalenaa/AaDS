package lesson4;

public class DynamicArray {

    private int capacity = 1;

    private int[] elements = new int[capacity];

    private int size = 0;

    public static void main(String[] args) {
        DynamicArray array = new DynamicArray();
        array.add(10);
        array.add(-100);
        array.add(2);
        array.add(-200);
        array.add(0);
        assert array.get(0) == 10;
        assert array.get(4) == 0;
        assert array.size() == 5;
    }

    public DynamicArray() {}

    public int size() {
        return size;
    }

    public Integer get(int i) {
        if (i < 0 || i >= elements.length) {
            return null;
        }
        return elements[i];
    }

    public void add (int x) {
        if (size + 1 > capacity) {
            ensureCapacity();
        }
        elements[size] = x;
        size++;
    }

    public void ensureCapacity() {
        capacity *= 2;
        int[] newArray = new int[capacity];
        for (int i = 0; i < size; ++i) {
            newArray[i] = elements[i];
        }
        elements = newArray;
    }

}
