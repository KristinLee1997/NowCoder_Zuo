package com.kristin.base.one;

import com.kristin.base.util.Template;

/**
 * @author hang li
 * @since 2018/3/29
 */
public class BubbleSort {
    public static void sort1(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    Template.swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void sort2(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean flag = true;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    Template.swap(arr, j, j + 1);
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }

    public static void sort3(int[] arr) {
        int pos = 0;
        for (int i = 0; i < arr.length; i = arr.length - pos) {
            pos = 0;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    Template.swap(arr, j, j + 1);
                    pos = j + 1;
                }
            }
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
            sort3(arr1);
            Template.comparator(arr2);
            if (!Template.isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "SuccessFul!" : "Please try again!");
    }
}
