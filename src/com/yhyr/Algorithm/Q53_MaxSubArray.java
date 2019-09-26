package com.yhyr.Algorithm;

/**
 * Subject: 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 
 * @author yhyr
 * @since 2019/09/26 23:03
 */
public class Q53_MaxSubArray {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int result = 0;
        int length = nums.length - 1;
        for (int i = 0; i <= length; i++) {
            // 初始化max
            if (max < nums[i]) {
                max = nums[i];
            }
            // 连续相加和小于等于零，直接pass；重置result重新计算
            if (result + nums[i] <= 0) {
                result = 0;
                continue;
            }
            if (result + nums[i] > 0) {
                result += nums[i];
                if (result > max) {
                    max = result;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Q53_MaxSubArray action = new Q53_MaxSubArray();
        int[] num = {-2, 1};
        System.out.println(action.maxSubArray(num));
    }
}
