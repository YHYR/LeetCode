package com.yhyr.Algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * Subject: 旋转矩阵
 * 
 * @author yhyr
 * @since 2019/09/28 9:45
 */
public class Q54_SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0) {
            return result;
        }
        int m = matrix.length - 1;
        int n = matrix[0].length - 1;
        for (int i = 0, j = 0; i <= m && j <= n; i++, j++, m--, n--) {
            for (int index = j; index <= n; index++) {
                result.add(matrix[i][index]);
            }
            for (int index = i + 1; index <= m; index++) {
                result.add(matrix[index][n]);
            }
            // 消除 m,0 -> m,n时，从n到0反向打印的情况
            for (int index = n - 1; index >= j && m > i; index--) {
                result.add(matrix[m][index]);
            }
            // 消除0,n -> m,n时，从m到0反向打印的情况
            for (int index = m - 1; index > i && n > j; index--) {
                result.add(matrix[index][j]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Q54_SpiralOrder action = new Q54_SpiralOrder();
        int[][] matrix = new int[3][4];
        matrix[0][0] = 1;
        matrix[0][1] = 2;
        matrix[0][2] = 3;
        matrix[0][3] = 4;
        matrix[1][0] = 5;
        matrix[1][1] = 6;
        matrix[1][2] = 7;
        matrix[1][3] = 8;
        matrix[2][0] = 9;
        matrix[2][1] = 10;
        matrix[2][2] = 11;
        matrix[2][3] = 12;

        // int[][] matrix = new int[3][3];
        // matrix[0][0] = 1;
        // matrix[0][1] = 2;
        // matrix[0][2] = 3;
        // matrix[1][0] = 4;
        // matrix[1][1] = 5;
        // matrix[1][2] = 6;
        // matrix[2][0] = 7;
        // matrix[2][1] = 8;
        // matrix[2][2] = 9;
        System.out.println(action.spiralOrder(matrix).toString());
    }
}
