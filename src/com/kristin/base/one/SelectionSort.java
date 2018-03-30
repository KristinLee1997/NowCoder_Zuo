package com.kristin.base.one;

import com.kristin.base.util.Template;

/**
 * @author hang li
 * @since 2018/3/29
 */
public class SelectionSort {
    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            Template.swap(arr, i, minIndex);
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
