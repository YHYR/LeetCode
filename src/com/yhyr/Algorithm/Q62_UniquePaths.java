package com.yhyr.Algorithm;

/**
 * @author yhyr
 * @since 2019/09/27 23:43
 */
public class Q62_UniquePaths {
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        return findPathByRecursive(m, n);
    }

    /**
     * 基于递归的动态规划
     *
     * 思路简单，代码实现也很精简，但是提交超时；因为递归反复压栈出栈太耗时
     * 
     * @param m
     * @param n
     * @return
     */
    private int findPathByRecursive(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        // return findPathByRecursive(m - 1, n) + findPathByRecursive(m, n - 1);
        return findPathByIterator(m, n);
    }


    /**
     * 将递归式动态规划改写成迭代
     * 动态规划公示：f(m, n) = f(m-1)(n) + f(m)(n-1)
     * 以3*3为例，左下角坐标为(0,0)，则从原点出发，向左向上值均为1，其他节点按照公式进行计算
     *
     * 1,1,1
     * 1,2,3
     * 1,3,6
     * @param m
     * @param n
     * @return
     */
    private int findPathByIterator(int m, int n) {
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            result[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            result[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                result[i][j] = result[i - 1][j] + result[i][j - 1];
            }
        }
        return result[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Q62_UniquePaths action = new Q62_UniquePaths();
        System.out.println(action.uniquePaths(3, 2));
    }
}
