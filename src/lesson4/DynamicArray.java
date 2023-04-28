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
        try {
            array.erase();
            assert array.size() == 4;
            assert array.get(4) == null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public DynamicArray() {}

    public int size() {
        return size;
    }

    public Integer get(int i) {
        if (i < 0 || i >= size) {
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

    public void erase() throws Exception {
        if (isEmpty()) {
            throw new Exception("Dynamic array is empty!");
        }
        if (size < capacity / 4) {
            int[] newArr = new int[capacity / 2];
            for (int i = 0; i < size; ++i) {
                newArr[i] = elements[i];
            }
            size--;
            return;
        }
        size--;
    }

    public void ensureCapacity() {
        capacity *= 2;
        int[] newArray = new int[capacity];
        for (int i = 0; i < size; ++i) {
            newArray[i] = elements[i];
        }
        elements = newArray;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

}