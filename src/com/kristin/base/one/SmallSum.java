package com.kristin.base.one;

import java.util.Arrays;

/**
 * @author hang li
 * @since 2018/3/29
 */
public class SmallSum {
    public static int sort(int[] arr) {
        return sort(arr, 0, arr.length - 1);
    }

    private static int sort(int[] arr, int l, int r) {
        if (l >= r) {
            return 0;
        }
        int mid = (l + r) / 2;
        return sort(arr, l, mid) + sort(arr, mid + 1, r) + merge(arr, l, mid, r);
    }

    private static int merge(int[] arr, int l, int mid, int r) {
        int[] aux = Arrays.copyOfRange(arr, l, r + 1);
        int i = l;
        int j = mid + 1;
        int res = 0;
        for (int k = l; k < r; k++) {
            if (i > mid) {
                arr[k] = aux[i - l];
                i++;
            } else if (j > r) {
                arr[k] = aux[j - l];
                j++;
            } else if (aux[i - l] < aux[j - l]) {
                arr[k] = aux[i - l];
                res += (r - j + 1) * arr[k];
                i++;
            } else {
                arr[k] = aux[j - l];
                j++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int arr[] = {1, 3, 4, 2, 5};
        int res = sort(arr);
        System.out.println(res);
    }
}
