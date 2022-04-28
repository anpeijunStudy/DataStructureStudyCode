package com.dataStructure.SparseArray.Sparse;

/**
 * @author 安珮军
 * @version 1.0
 * @Description:稀疏数组
 */
public class SpareArrayTest {
    public static void main(String[] args) {
        // 创建一个二维数组
        int[][] twoDimensionArrays = new int[11][11];
        // 存储值
        twoDimensionArrays[3][9] = 1;
        twoDimensionArrays[6][9] = 2;

        // 输出原始二维数组
        System.out.println("输出原始二维数组");
        printArray(twoDimensionArrays);
        // 二维数组转稀疏数组
        int[][] sparseArrays = twoDimensionTOSparseArray(twoDimensionArrays);
        System.out.println("稀疏数组");
        printArray(sparseArrays);
        // 稀疏数组转二维数组
        int[][] twoDimension = sparseArrayToTwoDimension(sparseArrays);
        System.out.println("输出转变二维数组");
        printArray(twoDimension);
    }

    /**
     * 二维数组转稀疏数组
     */
    public static int[][] twoDimensionTOSparseArray(int[][] twoDimensionArrays) {
        // 先遍历数组得到非0个数
        int sum = 0;
        for (int i = 0; i < twoDimensionArrays.length; i++) {
            for (int j = 0; j < twoDimensionArrays[i].length; j++) {
                if (twoDimensionArrays[i][j] != 0) {
                    sum++;
                }
            }
        }
        // 创建的稀疏数组应该是int[非零个数加一][3]
        int[][] sparseArrays = new int[sum + 1][3];
        // 赋值
        sparseArrays[0][0] = twoDimensionArrays.length;// 数组的行
        sparseArrays[0][1] = twoDimensionArrays.length;// 数组的列
        sparseArrays[0][2] = sum;

        // 遍历二维数组将非值存放
        int temp = 0;// 记录非零数组
        for (int i = 0; i < twoDimensionArrays.length; i++) {
            for (int j = 0; j < twoDimensionArrays[i].length; j++) {
                if (twoDimensionArrays[i][j] != 0) {
                    temp++;
                    sparseArrays[temp][0] = i;// 行
                    sparseArrays[temp][1] = j;// 列
                    sparseArrays[temp][2] = twoDimensionArrays[i][j];// 值
                }
            }
        }
        // 返回稀疏数组
        return sparseArrays;
    }

    /**
     * 稀疏数组转二维数组
     */
    public static int[][] sparseArrayToTwoDimension(int[][] sparseArrays) {
        // 创建二维数组
        // 稀疏组数的sparseArrays[0][0]代表行sparseArrays[0][1]代表列
        int[][] twoDimensionArrays = new int[sparseArrays[0][0]][sparseArrays[0][1]];
        // 赋值
        for (int i = 1; i < sparseArrays.length; i++) {
            twoDimensionArrays[sparseArrays[i][0]][sparseArrays[i][1]] = sparseArrays[i][2];
        }
        return twoDimensionArrays;
    }

    /**
     * 输出数组
     */
    public static void printArray(int[][] arrays) {
        for (int[] array : arrays) {
            for (int price : array) {
                System.out.print("\t" + price);
            }
            System.out.println();
        }
    }

}
