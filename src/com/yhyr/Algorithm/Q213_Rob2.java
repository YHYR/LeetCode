package com.yhyr.Algorithm;

/**
 * Subject: 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，
 * 
 * 这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，
 * 
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 * 
 * @author yhyr
 * @since 2019/10/12 0:53
 */
public class Q213_Rob2 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return nums[0] > nums[1] ? nums[0] : nums[1];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[0] > nums[1] ? nums[0] : nums[1];
        for (int i = 2; i < nums.length - 1; i++) {
            if (dp[i - 2] + nums[i] > dp[i - 1]) {
                dp[i] = dp[i - 2] + nums[i];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        int x = dp[dp.length - 2];
        dp[1] = nums[1];
        dp[2] = nums[1] > nums[2] ? nums[1] : nums[2];
        for (int i = 3; i < nums.length; i++) {
            if (dp[i - 2] + nums[i] > dp[i - 1]) {
                dp[i] = dp[i - 2] + nums[i];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        int y = dp[dp.length - 1];
        return x > y ? x : y;
    }

    public static void main(String[] args) {
        Q213_Rob2 action = new Q213_Rob2();
        System.out.println(action.rob(new int[] {1, 3, 1, 3, 100}));
    }
}
