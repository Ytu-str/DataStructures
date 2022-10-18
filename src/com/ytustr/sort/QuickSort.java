package com.ytustr.sort;

import java.util.Arrays;

/**
 * 快速排序
 * @author Ytu-str
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {4,1,83,7,9,98,100,67,3,43};
        quickSort(arr,0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int left, int right){
        int l = left;
        int r = right;
        int pivot = arr[(left + right) / 2];
        int temp = 0;
        while (l < r){
            //在pivot左边找到一个大于等于pivot的值
            while (arr[l] < pivot){
                l += 1;
            }
            //在pivot右边找到一个小于等于pivot的值
            while (arr[r] > pivot){
                r -= 1;
            }
            if (l >= r){
                break;
            }
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            if (arr[l] == pivot){
                r -= 1;
            }
            if (arr[r] == pivot){
                l += 1;
            }
        }
        if (l == r){
            l += 1;
            r -= 1;
        }
        if (left < r) {
            quickSort(arr, left, r);
        }
        if (right > l){
            quickSort(arr,l,right);
        }
    }
}
