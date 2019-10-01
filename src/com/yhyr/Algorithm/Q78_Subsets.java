package com.yhyr.Algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * Subject: 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）
 *
 * @author yhyr
 * @since 2019/09/30 16:56
 */
public class Q78_Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        for (int i = 0; i <= nums.length - 1; i++) {
            List<Integer> sub = new ArrayList<>();
            sub.add(nums[i]);
            results.add(sub);
            findSubSet(nums, i + 1, results, sub);
        }
        results.add(new ArrayList<>());
        return results;
    }

    private void findSubSet(int[] nums, int start, List<List<Integer>> results, List<Integer> sub) {
        for (int i = start; i < nums.length; i++) {
            List<Integer> s = new ArrayList<>(sub);
            s.add(nums[i]);
            results.add(s);
            findSubSet(nums, i + 1, results, s);
        }
    }

    public static void main(String[] args) {
        Q78_Subsets action = new Q78_Subsets();
        action.subsets(new int[] {1, 2, 3, 4});
    }
}
