package com.ytustr.sort;

import java.util.Arrays;

/**
 * 希尔排序
 * @author Ytu-str
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {4,1,9,7,2};
        shellSort2(arr);
    }

    /**
     * 交换法
     * @param arr
     */
    public static void shellSort(int[] arr){
        int temp = 0;
        for (int gap = arr.length / 2; gap > 0; gap = gap / 2){
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j-=gap) {
                    if (arr[j] > arr[j + gap]){
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 移位法
     * @param arr
     */
    public static void shellSort2(int[] arr){
        for (int gap = arr.length / 2; gap > 0; gap = gap / 2){
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j-gap]){
                    while (j - gap >= 0 && temp < arr[j - gap]){
                        arr[j] = arr[j-gap];
                        j -= gap;
                    }
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
