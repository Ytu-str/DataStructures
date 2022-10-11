package com.ytustr.sparsearray;

/**
 * 稀疏数组
 *
 * @author Ytu-str
 */
public class SparseArray {
    public static void main(String[] args) {
        int[][] chessArr = new int[11][11];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;

        for (int[] row : chessArr) {
            for (int item : row) {
                System.out.printf("%d\t",item);
            }
            System.out.println();
        }

        //计算有效数据个数
        int sum = 0;
        for (int i = 0; i < chessArr.length; i++) {
            for (int j = 0; j < chessArr.length; j++) {
                if (chessArr[i][j] != 0){
                    sum++;
                }
            }
        }

        int[][] sparseArray = new int[sum+1][3];
        //把稀疏数组第一行数据填上
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = sum;
        //给稀疏数组填数据
        int count = 0;
        for (int i = 0; i < chessArr.length; i++) {
            for (int j = 0; j < chessArr.length; j++) {
                if (chessArr[i][j] != 0){
                    count ++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chessArr[i][j];
                }
            }
        }
        System.out.println("稀疏数组：");
        for (int[] ints : sparseArray) {
            for (int item : ints) {
                System.out.printf("%d\t",item);
            }
            System.out.println();
        }
        //恢复为二维数组
        int[][] chessArray2 = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1; i < sparseArray.length; i++) {
            chessArray2[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        for (int[] row : chessArray2) {
            for (int item : row) {
                System.out.printf("%d\t",item);
            }
            System.out.println();
        }
    }
}
