package com.kristin.base.one;

import com.kristin.base.util.Template;

/**
 * @author hang li
 * @since 2018/3/29
 */
public class InsertionSort {
    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            for (; j > 0 && arr[j - 1] > temp; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;
        }
    }

    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = Template.generateRandomArray(maxSize, maxValue);
            int[] arr2 = Template.copyArr(arr1);
            sort(arr1);
            Template.comparator(arr2);
            if (!Template.isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "SuccessFul!" : "Please try again!");
    }
}
