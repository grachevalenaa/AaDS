package lesson4;

public class PriorityQueue {

    DynamicStringArray heap = new DynamicStringArray();

    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.insert("aacd");
        priorityQueue.insert("aabd");
        priorityQueue.insert("xyz");
        priorityQueue.insert("aabda");
        priorityQueue.insert("aa");
        priorityQueue.insert("qwerty");
        try {
            assert priorityQueue.removeMin().equals("aa");
            assert priorityQueue.removeMin().equals("aabd");
            assert priorityQueue.removeMin().equals("aabda");
            assert priorityQueue.removeMin().equals("aacd");
            assert priorityQueue.removeMin().equals("qwerty");
            assert priorityQueue.removeMin().equals("xyz");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void insert(String str) {
       int i = heap.size();
       heap.add(str);  // добавляем в конец кучи новую строку
       int parentInd = (i - 2) / 2;
       while (i > 0 && heap.compare(i, parentInd) == 1) {
           parentInd = (i - 2) / 2;
           heap.swap(i, parentInd);
           i = parentInd;
       }
    }

    public String removeMin() throws Exception {
        String minElem = heap.get(0);
        heap.swap(0, heap.size() - 1);
        int i = 0;
        heap.erase();
        int minChildInd;
        while (2 * i + 1 < heap.size()) {
            minChildInd = 2 * i + 1;
            if (2 * i + 2 < heap.size() && heap.compare(minChildInd, 2 * i + 2) == -1) {
                minChildInd = 2 * i + 2;
            }
            if (heap.compare(minChildInd, i) == 1) {
                heap.swap(minChildInd, i);
                i = minChildInd;
            } else {
                break;
            }
        }
        return minElem;
    }
}

class DynamicStringArray {
    
    private int capacity = 1;

    private String[] strings = new String[capacity];

    private int size = 0;

    public int size() {
        return size;
    }

    public String get(int i) {
        if (i < 0 || i >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return strings[i];
    }

    public void add(String str) {
        if (size + 1 > capacity) {
            ensureCapacity();
        }
        strings[size] = str;
        size++;
    }

    public void erase() throws Exception {
        if (isEmpty()) {
            throw new Exception("Dynamic array is empty!");
        }
        if (size < capacity / 4) {  // чтобы не было занято много лишней памяти, уменьшаем capacity
            String[] newArr = new String[capacity / 2];
            for (int i = 0; i < size; ++i) {
                newArr[i] = strings[i];
            }
            strings = newArr;
            size--;
            return;
        }
        size--;
    }

    public void swap(int i, int j) {
        String temp = strings[i];
        strings[i] = strings[j];
        strings[j] = temp;
    }

    public int compare(int i, int j) {
        /*
         * Метод compare написан для строк состоящих из строчных букв
         * английского алфавита. Будем использовать кодировку ASCII,
         * где символу 'a' соотвествует 97, а 'z' - 122.
         * Используем эти коды для сравнения. Метод возвращает 1,
         * когда элемент по первому индексу i "не меньше" второго, и -1
         * в остальных случаях.
         * */
        String first = strings[i];
        String second = strings[j];
        int minLength = Math.min(first.length(), second.length());
        int firstCode;
        int secondCode;
        for (int k = 0; k < minLength; ++k) {
            firstCode = first.charAt(k);  // в fistCode и secondCode записываются коды из ASCII автоматически
            secondCode = second.charAt(k);
            if (firstCode < secondCode) {
                return 1;
            } else if (firstCode > secondCode) {
                return -1;
            }
        }
        return first.length() <= second.length() ? 1 : -1;
    }

    public void ensureCapacity() {
        capacity *= 2;
        String[] newArray = new String[capacity];
        for (int i = 0; i < size; ++i) {
            newArray[i] = strings[i];
        }
        strings = newArray;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

}