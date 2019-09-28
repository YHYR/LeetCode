package com.yhyr.Algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * Subject: 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 
 * @author yhyr
 * @since 2019/09/28 23:29
 */
public class Q136_SingleNumber {
    /**
     * 通过异或运算，保证O(n)时间复杂度的同时，实现O(1)的空间复杂度
     * 
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Q136_SingleNumber action = new Q136_SingleNumber();
        System.out.println(action.singleNumber(new int[] {4, 1, 2, 1, 2}));
    }
}
