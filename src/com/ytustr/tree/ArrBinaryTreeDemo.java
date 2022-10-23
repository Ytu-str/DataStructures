package com.ytustr.tree;

/**
 * 顺序存储二叉树
 * @author Ytu-str
 */
public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        arrBinaryTree.perOrder();
    }
}
class ArrBinaryTree{

    private int[] arr;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    public void perOrder(){
        this.perOrder(0);
    }

    /**
     * 顺序存储二叉树前序遍历
     * @param index 数组下标
     */
    public void perOrder(int index){
        if (arr == null || arr.length == 0){
            return;
        }
        System.out.printf(arr[index] + " ");
        //向左递归
        if ((index * 2 + 1) < arr.length){
            perOrder(2 * index + 1);
        }
        //向右递归
        if ((index * 2 + 2) < arr.length){
            perOrder(index * 2 + 2);
        }
    }
}
