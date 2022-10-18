package com.ytustr.sort;

import java.util.Arrays;

/**
 * 归并排序
 * @author Ytu-str
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {4,1,83,7,9,98,100,67};
        int[] temp = new int[arr.length];
        mergeSort(arr,0,arr.length-1,temp);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int left, int right, int[] temp){
        if (left < right){
            int mid = (left + right) / 2;
            //理解：将左边递归到底，才开始递归右边，右边也递归底，才开始执行合并方法
            mergeSort(arr,left,mid,temp);
            mergeSort(arr,mid + 1,right,temp);
            //每分一次就合一次
            merge(arr,left,mid,right,temp);
        }
    }

    /**
     * 合并的方法
     * @param arr 排序的原始数组
     * @param left 左边有序序列的初始索引
     * @param mid 中间索引
     * @param right 右边的索引
     * @param temp 中转数组
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp){
        System.out.println("xxxxxx");
        int i = left;
        //右边序列的初始索引
        int j = mid + 1;
        //temp的索引
        int t = 0;
        while (i <= mid && j <= right){
            if (arr[i] <= arr[j]){
                temp[t] = arr[i];
                i++;
                t++;
            }else {
                temp[t] = arr[j];
                j++;
                t++;
            }
        }
        //左边还有剩余
        while (i <= mid){
            temp[t] = arr[i];
            i++;
            t++;
        }
        while (j <= right){
            temp[t] = arr[j];
            j++;
            t++;
        }
        t = 0;
        int tempLeft = left;
        System.out.println("tempLeft:"+tempLeft+" right:"+right);
        while (tempLeft <= right){
            arr[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }
    }
}
