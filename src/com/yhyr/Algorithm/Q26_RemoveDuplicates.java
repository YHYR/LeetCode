package com.yhyr.Algorithm;

/**
 * Subject
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * Tips 双指针法
 *
 * @author yhyr
 * @since 2019/3/27 0027 16:38
 */
public class Q26_RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int left = 0;
        for (int right = 1; right < nums.length; ) {
            if (nums[left] != nums[right]) {
                nums[left + 1] = nums[right];
                left += 1;
            }
            right += 1;
        }
        return left + 1;
    }

    public static void main(String[] args) {
        Q26_RemoveDuplicates action = new Q26_RemoveDuplicates();
        int[] nums = new int[]{0,0, 1, 1, 1, 2, 2, 3, 3, 4};
        action.removeDuplicates(nums);
    }
}
