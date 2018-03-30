package com.kristin.base.two;

import com.kristin.base.util.Template;

/**
 * @author hang li
 * @since 2018/3/29
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {1, 5, 9, 7, 2, 3, 8, 6, 4};
        sort(arr);
        Template.printArray(arr);
    }

    public static void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = (l + r) / 2;
        int pos = partation(arr, l, r);
        sort(arr, l, pos - 1);
        sort(arr, pos + 1, r);
    }

    private static int partation(int[] arr, int l, int r) {
        int v = arr[l];
        int i = l + 1;
        int j = r;
        while (i < j) {
            while (i < j && v < arr[j]) {
                j--;
            }
            arr[i] = arr[j];
            while (i < j && v > arr[i]) {
                i++;
            }
            arr[j] = arr[i];
        }
        arr[j] = v;
        return j;
    }
}
