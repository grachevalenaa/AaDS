package lesson1;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
    public static void main(String[] args) {
        // ввод массива
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] a1 = new int[size];
        for (int i = 0; i < size; ++i) {
            a1[i] = scanner.nextInt();
        }

        // сортировка слиянием
        int[] a2 = mergeSort(a1);

        // вывод массива в консоль
        for (int el: a2) {
            System.out.print(el + " ");
        }

    }

    public static int[] mergeSort(int[] a) {
        int s = a.length;
        if (s == 1) {
            return a;
        }
        int[] l = Arrays.copyOfRange(a, 0, s / 2);
        int[] r = Arrays.copyOfRange(a, s / 2, s);
        l = mergeSort(l);
        r = mergeSort(r);
        return merge(l, r);
    }

    public static int[] merge(int[] l, int[] r) {
        int n = l.length;
        int m = r.length;
        int i = 0;
        int j = 0;
        int[] c = new int[n + m];
        while (i + j < n + m) {
            if (j == m || (i < n && l[i] < r[j])) {
                c[i + j] = l[i];
                i++;
            } else {
                c[i + j] = r[j];
                j++;
            }
        }
        return c;
    }
}