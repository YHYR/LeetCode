package com.yhyr.Algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * Subject:
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * @author yhyr
 * @since 2019/01/04 15:21
 */
public class Q1_TwoSum {
    /**
     * 基于散列表实现
     * 时间复杂度O(n)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.keySet().contains(temp)) {
                return new int[]{map.get(temp), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    /**
     * 第一次提交结果 => 性能最差
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum_1(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Q1_TwoSum action = new Q1_TwoSum();
        int[] nums = {2, 7, 11, 13};
        int target = 24;
        for(int i : action.twoSum(nums, target)) {
            System.out.println(i);
        }
    }
}
