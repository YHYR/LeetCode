package com.yhyr.Algorithm;


/**
 * Subject: 有n阶台阶，每次可以爬1阶或2阶，一共有多少中爬行方法
 * 
 * @author yhyr
 * @since 2019/09/24 0:28
 */
public class Q70_ClimbStairs {
    /**
     * 用树结构的解法超时
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n == 0) {
            return 0;
        }
        int[] result = new int[1];
        climb(n, result);
        return result[0];
    }

    private void climb(int n, int[] result) {
        if (n == 0) {
            result[0] = result[0] + 1;
        }
        if (n > 0) {
            climb(n - 1, result);
        }
        if (n > 1) {
            climb(n - 2, result);
        }
    }

    /**
     * 官方解法
     * @param n
     * @return
     */
    public int fib(int n) {
        if (n == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }

    public static void main(String[] args) {
        Q70_ClimbStairs action = new Q70_ClimbStairs();
        System.out.println(action.climbStairs(3));
    }
}
