package com.ytustr.recursion;

/**
 * 8皇后问题
 * @author Ytu-str
 */
public class Queue8 {
    int max = 8;
    int[] array = new int[max];
    static int count = 0;
    public static void main(String[] args) {
        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.println("解法：" + count);
    }

    /**
     * check是每一次递归时，进入到check中都有for (int i = 0; i < max; i++) ，所以会有回溯
     * @param n
     */
    private void check(int n){
        if (n == max){
            print();
            return;
        }
        //依次放入皇后，判断是否有冲突
        for (int i = 0; i < max; i++) {
            //先把当前这个皇后，放到该行第一列
            array[n] = i;
            if (judge(n)){
                check(n + 1);
            }
        }
    }

    /**
     *
     * @param n 第几个皇后
     * @return
     */
    private boolean judge(int n){
        for (int i = 0; i < n; i++) {
            if (array[n] == array[i] || Math.abs(n - i) == Math.abs(array[n] - array[i])){
                return false;
            }
        }
        return true;
    }

    private void print(){
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.printf(array[i] + " ");
        }
        System.out.println();
    }
}
