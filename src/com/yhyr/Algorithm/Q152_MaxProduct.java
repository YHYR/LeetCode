package com.yhyr.Algorithm;

/**
 * Subject: 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
 *
 * 解题思路：动态规划 最简单的情况：均为非负数，则：max = Max(max * nums[i], nums[i])
 * 如果存在负数，则将用最大值与负数相乘，保证乘积最小，故在偶次负数能可以保证乘积最大；因此当nums[i]<0时需要转化一下imax和imin
 * 
 * @author yhyr
 * @since 2019/10/12 16:30
 */
public class Q152_MaxProduct {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int iMax = 1;
        int iMin = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int tmp = iMin;
                iMin = iMax;
                iMax = tmp;
            }
            iMax = Math.max(iMax * nums[i], nums[i]);
            iMin = Math.min(iMin * nums[i], nums[i]);
            max = Math.max(max, iMax);
        }
        return max;
    }

    public static void main(String[] args) {
        Q152_MaxProduct action = new Q152_MaxProduct();
        System.out.println(action.maxProduct(new int[] {3, 2, -1}));
    }
}
