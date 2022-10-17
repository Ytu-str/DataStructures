package com.ytustr.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * @author Ytu-str
 */
public class BobbleSort {
    public static void main(String[] args) {
        int[] arr = {3,9,-1,10,4,7};
        int temp = 0;
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j+1]){
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            if (!flag){
                break;
            }else {
                flag = false;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
