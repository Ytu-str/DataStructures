package com.ytustr.recursion;

/**
 * 迷宫问题
 * @author Ytu-str
 */
public class MiGong {
    public static void main(String[] args) {
        int[][] map = new int[8][7];
        //使用1表示墙,上下全部置为1
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        //左右全部置为1
        for (int j = 0; j < 8; j++) {
            map[j][0] = 1;
            map[j][6] = 1;
        }
        map[3][2] = 1;
        map[3][1] = 1;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        setWay(map,1,1);
        System.out.println("地图");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
    //1.map表示地图
    //2.i,j表示地图从哪个位置开始出发（1，1）
    //3.如果小球能到（6，5）位置，说明找到
    //4.约定：当map[i][j]为0时，表示没有走过，1为墙，2为通路可以走，3标识已经走过，不通
    //5.在走迷宫时，需要确定一个策略，先走下->右->上->左，如果走不通再回溯
    /**
     *
     * @param map 地图
     * @param i 从哪个位置开始找
     * @param j 从哪个位置开始找
     * @return 如果找到路了返回true,否则返回false
     */
    public static boolean setWay(int[][] map, int i, int j){
        if (map[6][5] == 2){
            return true;
        }else {
            if (map[i][j] == 0){
                //下->右->上->左
                //假定该点可以走通
                map[i][j] = 2;
                //向下走
                if (setWay(map,i+1,j)){
                    return true;
                    //向右走
                }else if (setWay(map,i,j+1)){
                    return true;
                    //向上走
                }else if (setWay(map,i-1,j)){
                    return true;
                    //向左走
                }else if (setWay(map,i,j-1)){
                    return true;
                }else {
                    //说明该点走不通
                    map[i][j] = 3;
                    return false;
                }
            }else {
                return false;
            }
        }
    }
}
