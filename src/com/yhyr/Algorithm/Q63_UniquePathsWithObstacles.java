package com.yhyr.Algorithm;

/**
 * Subject: 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * 
 * 解题思路：动态规划 当nums[i][j] == 0时(即无障碍物)：dp[i] = dp[i-1][j] + dp[i][j-1]
 * 
 * 当nums[i][j] == 1时(即有障碍物)：dp[i] = 0
 * 
 * 同时在初始化矩形两条边时需要注意一些特殊场景
 * 
 * @author yhyr
 * @since 2019/10/16 23:54
 */
public class Q63_UniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        boolean flag = false;
        for (int i = 0; i < obstacleGrid.length; i++) {
            if (flag || obstacleGrid[i][0] == 1) {
                dp[i][0] = 0;
                flag = true;
            } else {
                dp[i][0] = 1;
            }
        }
        flag = false;
        for (int i = 0; i < obstacleGrid[0].length; i++) {
            if (flag || obstacleGrid[0][i] == 1) {
                dp[0][i] = 0;
                flag = true;
            } else {
                dp[0][i] = 1;
            }
        }
        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[obstacleGrid.length - 1][obstacleGrid[obstacleGrid.length - 1].length - 1];
    }

    public static void main(String[] args) {
        Q63_UniquePathsWithObstacles action = new Q63_UniquePathsWithObstacles();
        // int[][] nums = new int[][] {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int[][] nums = new int[][] {{0, 0}, {1, 1}, {0, 0}};
        System.out.println(action.uniquePathsWithObstacles(nums));
    }
}
