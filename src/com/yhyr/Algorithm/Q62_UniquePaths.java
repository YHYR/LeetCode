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
        return findPath(m, n);
    }

    /**
     * 递归
     *
     * 思路简单，代码实现也很精简，但是提交超时；因为递归反复压栈出栈太耗时
     * @param m
     * @param n
     * @return
     */
    private int findPath(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        return findPath(m - 1, n) + findPath(m, n - 1);
    }

    public static void main(String[] args) {
        Q62_UniquePaths action = new Q62_UniquePaths();
        System.out.println(action.uniquePaths(3, 3));
    }
}
