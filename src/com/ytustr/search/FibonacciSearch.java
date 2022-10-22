package com.ytustr.search;

import java.util.Arrays;

/**
 * 斐波拉契查找
 * @author Ytu-str
 */
public class FibonacciSearch {
    private static int maxSize = 20;
    public static void main(String[] args) {
        int[] arr = {1,8,10,89,1000,1111,1234};
        int i = fibonacciSearch(arr, 1234);
        System.out.println(i);
    }
    public static int fibonacciSearch(int[] arr, int key){
        int low = 0;
        int high = arr.length - 1;
        //斐波拉契分割数值的下标
        int k = 0;
        int mid =0;
        int[] fib = fib();
        while(high > fib[k] - 1){
            k++;
        }
        int[] temp = Arrays.copyOf(arr,fib[k]);
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = arr[high];
        }
        while (low <= high){
            mid = low + fib[k-1] -1;
            if (key<temp[mid]){
                high = mid - 1;
                k--;
            }else if (key > temp[mid]){
                low = mid + 1;
                k -= 2;
            }else {
                if (mid <= high){
                    return mid;
                }else {
                    return  high;
                }
            }
        }
        return -1;
    }

    public static int[] fib(){
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i-1] + f[i-2];
        }
        return f;
    }
}
