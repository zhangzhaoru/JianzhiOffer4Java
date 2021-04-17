package com.zhangzhaoru.java;

import org.junit.Test;
import org.w3c.dom.ls.LSInput;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @BelongsProject: JianzhiOffer
 * @BelongsPackage: com.zhangzhaoru.java
 * @Author: ZhangZhaoru
 * @Date: 2021/4/14 9:09 下午
 * @Description: 数组工具类
 */
public class ArrayUtils {

    private static final int RIGHT = 1;
    private static final int DOWN = 2;
    private static final int LEFT = 3;
    private static final int UP = 4;

    /**
     * 判断矩阵是否包含目标
     *
     * @param target
     * @param data
     * @return
     */
    public static boolean findTarget(int target, int[][] data) {
        int row = data.length;
        int col = data[0].length;
        int i = 0;
        int j = col - 1;
        while (i < row && j >= 0) {
            if (data[i][j] < target) {
                i++;
            } else if (data[i][j] > target) {
                j--;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * @param n
     * @return
     */
    public static int Fibonacci(int n) {
        return dsp4Fibonacci(n);
    }

    private static int dsp4Fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        return dsp4Fibonacci(n - 1) + dsp4Fibonacci(n - 2);
    }

    public static int[] reOrderArray(int[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = 0; j < data.length - i - 1; j++) {
                if (data[j] % 2 == 0 && data[j + 1] % 2 != 0) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
        return data;
    }

    /**
     * 顺时针打印矩阵
     *
     * @param matrix
     * @return
     */
    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int count = m * n;
        int i = 0;
        int j = 0;
        int[][] tags = new int[m][n];
        ArrayList<Integer> list = new ArrayList<>();
        int direction = RIGHT;
        int k = 1;
        while (k <= count) {
            if(k==count){
                list.add(matrix[i][j]);
                k++;
            }else if (RIGHT == direction) {
                if (j < n-1  && tags[i][j+1] == 0) {
                    list.add(matrix[i][j]);
//                    System.out.print(matrix[i][j]+" ");
                    tags[i][j] = 1;
                    j++;
                    k++;
                } else {
                    direction = DOWN;
                }
            } else if (DOWN == direction) {
                if (i < m - 1 && tags[i+1][j] == 0) {
                    list.add(matrix[i][j]);
//                    System.out.print(matrix[i][j]+" ");
                    tags[i][j] = 1;
                    i++;
                    k++;
                } else {
                    direction = LEFT;
                }
            } else if (LEFT == direction) {
                if (j >= 1 && tags[i][j-1] == 0) {
                    list.add(matrix[i][j]);
//                    System.out.print(matrix[i][j]+" ");
                    tags[i][j] = 1;
                    j--;
                    k++;
                } else {
                    direction = UP;
                }

            } else if (UP == direction) {
                if (i >= 1 && tags[i-1][j] == 0) {
                    list.add(matrix[i][j]);
//                    System.out.print(matrix[i][j]+" ");
                    tags[i][j] = 1;
                    i--;
                    k++;
                } else {
                    direction = RIGHT;
                }
            }

        }
        return list;
    }

    @Test
    public void testPrintMatrix() {
//        int[][] data = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}, {13,14,15,16}};
//        int[][] data = new int[][]{{1}};
        int[][] data = new int[][]{{1,2},{3,4}};

        ArrayList<Integer> list = printMatrix(data);
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();
    }

}
