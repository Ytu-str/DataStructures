package com.ytustr.sort;

import java.util.Arrays;

/**
 * 基数排序
 * @author Ytu-str
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {5,3,542,748,14,214};
        radixSort(arr);
    }

    public static void radixSort(int[] arr){
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max){
                max = arr[i];
            }
        }
        int maxLength = (max + "").length();

        int[][] bucket = new int[10][arr.length];
        int[] bucketElementCounts = new int[10];

        for (int i = 0,n=1;i < maxLength; i++,n*=10) {
            for (int j = 0; j < arr.length; j++) {
                int digitOfElement = arr[j] / n %10;
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;
            }
            int index = 0;
            for (int k = 0; k < bucketElementCounts.length; k++) {
                if (bucketElementCounts[k] != 0){
                    for (int j = 0; j < bucketElementCounts[k]; j++) {
                        arr[index++] = bucket[k][j];
                    }
                }
                bucketElementCounts[k] = 0;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
