package lesson1;

import java.util.ArrayList;
import java.util.Scanner;

public class InsertionSort {
    public static void main(String[] args) {
        // ввод размера массива и его элементов
        Scanner scanner = new Scanner(System.in);
        short size = scanner.nextShort();
        ArrayList<Short> array = new ArrayList<>();
        for (short i = 0; i < size; ++i) {
            array.add(scanner.nextShort());
        }

        // сортировка вставками
        short j;
        short temp;
        for (short i = 1; i < size; ++i) {
            j = i;
            while (j > 0 && array.get(j-1) > array.get(j)) {
                temp = array.get(j);
                array.set(j, array.get(j-1));
                array.set(j - 1, temp);
                --j;
            }

        }

        // вывод массива
        for (short i = 0; i < size; ++i) {
            System.out.print(array.get(i) + " ");
        }
    }
}
