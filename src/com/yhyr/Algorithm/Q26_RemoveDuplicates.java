package com.yhyr.Algorithm;

/**
 * Subject
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * @author yhyr
 * @since 2019/3/27 0027 16:38
 */
public class Q26_RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int duplicateCount = 0;
        for (int i = 0; i < nums.length - 1 - duplicateCount; ) {
            if (nums[i] == nums[i + 1]) {
                dataMove(nums, i);
                duplicateCount += 1;
            } else {
                i += 1;
            }
        }
        return nums.length - duplicateCount;
    }

    private void dataMove(int[] nums, int position) {
        while (position < nums.length - 1) {
            nums[position] = nums[position + 1];
            position += 1;
        }
    }

    public static void main(String[] args) {
        Q26_RemoveDuplicates action = new Q26_RemoveDuplicates();
        int[] nums = new int[]{1, 1, 2, 3, 3, 4};
        action.removeDuplicates(nums);
    }
}
