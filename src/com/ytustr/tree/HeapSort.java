package com.ytustr.tree;

import java.util.Arrays;

/**
 * 堆排序
 * @author Ytu-str
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {4,6,8,5,9};
        heapSort(arr);
    }
    public static void heapSort(int[] arr){
        int temp = 0;
        for (int i = arr.length/2 - 1; i >= 0 ; i--) {
            adjustHeap(arr,i,arr.length);
        }
        System.out.println(Arrays.toString(arr));
        for (int i = arr.length -1; i >0; i--) {
            //交换
            temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            adjustHeap(arr,0,i);
            System.out.println(Arrays.toString(arr));
        }
//        System.out.println(Arrays.toString(arr));
    }

    /**
     * 将一个数组（二叉树）调整成一个大顶堆
     * @param arr 待调整数组
     * @param i 非叶子节点在数组中的索引
     * @param length 对多少个元素进行调整
     */
    public static void adjustHeap(int[] arr, int i, int length){
        int temp = arr[i];
        //nt k = i * 2 + 1 k是i的左子节点
        for(int k = i * 2 + 1;k<length;k = k *2 + 1){
            //左字节点小于右子节点
            if (k+1<length && arr[k]<arr[k+1]){
                //k指向右子节点
                k++;
            }
            //如果子节点大于父节点
            if (arr[k]>temp){
                //把较大的值赋值给当前节点
                arr[i] = arr[k];
                i = k;
            }else {
                break;
            }
        }
        arr[i] = temp;
    }
}
