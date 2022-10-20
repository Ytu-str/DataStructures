package com.ytustr.search;

/**
 * 插值查找
 * @author Ytu-str
 */
public class InsertValueSearch {
    public static void main(String[] args) {
        int[] arr = {1,8,10,89,1000,1000,1234};
        int i = insertValueSearch(arr, 0, arr.length - 1, 89);
        System.out.println(i);
    }
    public static int insertValueSearch(int[] arr, int left, int right, int findVal){
        if (left > right || findVal < arr[0] || findVal > arr[arr.length - 1]){
            return -1;
        }
        int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
        int midVal = arr[mid];
        if (findVal > midVal){
            return insertValueSearch(arr,mid+1,right,findVal);
        }else if (findVal < midVal){
            return insertValueSearch(arr,left,mid-1,findVal);
        }else {
            return mid;
        }
    }
}
