package com.yhyr.Algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * Subject: 给定一个没有重复数字的序列，返回其所有可能的全排列。
 *
 * @author yhyr
 * @since 2019/09/15 21:01
 */
public class Q46_Permutations {
    /**
     * 实现方法二：基于下标统计，降低空间利用率
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        int[] ids = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ids[0] = i;
            build(nums, ids, 0, resultList);
        }
        return resultList;
    }

    private void build(int[] nums, int[] ids, int index, List<List<Integer>> resultList) {
        if (index == nums.length - 1) {
            List<Integer> result = new ArrayList<>();
            for (int i : ids) {
                result.add(nums[i]);
            }
            resultList.add(result);
        }
        for (int i = 0; i < nums.length; i++) {
            boolean isExist = false;
            for (int j = 0; j <= index; j++) {
                if (ids[j] == i) {
                    isExist = true;
                    break;
                }
            }
            if (!isExist) {
                ids[index + 1] = i;
                build(nums, ids, index + 1, resultList);
            }
        }
    }

    /**
     * 实现方法一：基于元素值进行递归
     * 
     * @param nums
     * @return
     */
    public List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> result = new ArrayList<>();
            result.add(nums[i]);
            build1(nums, result, resultList);
        }
        return resultList;
    }

    /**
     * 实现方法一：效率较差，内存消耗大
     * 
     * @param nums
     * @param result
     * @param resultList
     */
    private void build1(int[] nums, List<Integer> result, List<List<Integer>> resultList) {
        if (result.size() == nums.length) {
            resultList.add(result);
            return;
        }
        for (int elem : nums) {
            if (!result.contains(elem)) {
                List<Integer> tmp = new ArrayList<>(result);
                tmp.add(elem);
                build1(nums, tmp, resultList);
            }
        }
    }

    public static void main(String[] args) {
        Q46_Permutations action = new Q46_Permutations();
        action.permute(new int[] {1, 2, 3}).forEach(result -> System.out.println(result.toString()));
    }
}
