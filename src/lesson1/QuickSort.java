package lesson1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class QuickSort {

    public static void main(String[] args) {
        // ввод массива
        Scanner scanner = new Scanner(System.in);
        short size = scanner.nextShort();
        ArrayList<Short> array = new ArrayList<>();
        for (short i = 0; i < size; ++i) {
            array.add(scanner.nextShort());
        }

        // быстрая сортировка
        qsort((short)0, (short) (size - 1), array);

        // вывод массива
        for (short i = 0; i < size; ++i) {
            System.out.print(array.get(i) + " ");
        }
    }

    public static void qsort(short l, short r, ArrayList<Short> array) {
        if (l >= r) {
            return;
        }

        short[] it = new short[2];
        partition(l, r, array.get((l + r) / 2), array, it);
        qsort(l, it[0], array);
        qsort(it[1], r, array);
    }

    public static void partition(short l, short r, short pivot, ArrayList<Short> array, short[] it) {
        short i = l;
        short j = r;
        while (i <= j) {
            while (array.get(i) < pivot) ++i;
            while (array.get(j) > pivot) --j;
            if (i <= j) {
                Collections.swap(array, i++, j--);
            }
        }
        it[0] = j;
        it[1] = i;
    }
}