package com.yhyr.Algorithm;

/**
 * Subject:
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
