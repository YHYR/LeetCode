package com.yhyr.Algorithm;

/**
 * Subject: 给定长度为n的整数数组nums，其中n > 1，返回输出数组output，其中output[i]等于nums中除nums[i]之外其余各元素的乘积。
 * 
 * @author yhyr
 * @since 2019/09/30 1:06
 */
public class Q238_ProductExceptSelf {
    /**
     * 效率极差
     * 
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = 1;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < result.length; j++) {
                if (i != j) {
                    result[j] *= nums[i];
                } else {
                    result[j] *= 1;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Q238_ProductExceptSelf action = new Q238_ProductExceptSelf();
        action.productExceptSelf(new int[] {9, 0, -2});
    }
}
