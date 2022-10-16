package com.ytustr.recursion;

/**
 * 递归小例子
 * @author Ytu-str
 */
public class RecursionTest {
    public static void main(String[] args) {
//        test(10);
        int factorial = factorial(3);
        System.out.println(factorial);
    }

    public static void test(int n){
        if (n > 2){
            test(n - 1);
        }
        System.out.println(n);
    }

    public static int factorial(int n){
        if (n == 1){
            return 1;
        }else {
            return factorial(n - 1) * n; //1*2*3
        }
    }
}
