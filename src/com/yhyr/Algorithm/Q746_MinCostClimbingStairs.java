package com.yhyr.Algorithm;

/**
 * Subject: 数组的每个索引做为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。
 * 
 * 每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
 * 
 * 您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。
 * 
 * @author yhyr
 * @since 2019/10/11 22:00
 */
public class Q746_MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            if (dp[i-1] + cost[i] < dp[i-2] + cost[i]) {
                dp[i] = dp[i-1] + cost[i];
            } else {
                dp[i] = dp[i-2] + cost[i];
            }
        }
        return (dp[dp.length - 1] < dp[dp.length - 2]) ? dp[dp.length - 1] : dp[dp.length - 2];
    }

    public static void main(String[] args) {
        Q746_MinCostClimbingStairs action = new Q746_MinCostClimbingStairs();
        System.out.println(action.minCostClimbingStairs(new int[] {1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }
}
