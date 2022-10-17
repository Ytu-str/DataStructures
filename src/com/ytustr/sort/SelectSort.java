package com.ytustr.sort;

import java.util.Arrays;

/**
 * 选择排序
 * @author Ytu-str
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {4,1,7,9};
        selectSort(arr);
    }

    public static void selectSort(int[] arr){
        for (int j = 0; j < arr.length-1; j++) {
            int minIndex = j;
            int min = arr[minIndex];
            for (int i = j + 1; i < arr.length; i++) {
                if (min > arr[i]){
                    min = arr[i];
                    minIndex = i;
                }
            }
            arr[minIndex] = arr[j];
            arr[j] = min;
        }
        System.out.println(Arrays.toString(arr));
    }
}
