package com.yhyr.Algorithm;

import java.util.Arrays;

/**
 * Subject: 旋转矩阵2
 * 
 * @author yhyr
 * @since 2019/09/28 10:29
 */
public class Q59_GenerateMatrix {
    public int[][] generateMatrix(int n) {
        int length = n;
        int[][] matrix = new int[length][length];
        int value = 1;
        for (int i = 0; i < length; i++, length--) {
            for (int index = i; index < length; index++) {
                matrix[i][index] = value++;
            }
            for (int index = i + 1; index < length; index++) {
                matrix[index][length - 1] = value++;
            }
            for (int index = length - 2; index >= i; index--) {
                matrix[length - 1][index] = value++;
            }
            for (int index = length - 2; index > i; index--) {
                matrix[index][i] = value++;
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        Q59_GenerateMatrix action = new Q59_GenerateMatrix();
        int[][] matrix = action.generateMatrix(3);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
}
