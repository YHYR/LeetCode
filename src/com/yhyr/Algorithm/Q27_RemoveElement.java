package com.yhyr.Algorithm;

/**
 * Subject
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * @author yhyr
 * @since 2019/3/28 0028 9:37
 */
public class Q27_RemoveElement {
    public int removeElement(int[] nums, int val) {
        int left = -1;
        int right = 0;
        while (right < nums.length) {
            if (nums[right] != val) {
                nums[left + 1] = nums[right];
                left += 1;
            }
            right += 1;
        }
        return left + 1;
    }

    public static void main(String[] args) {
        Q27_RemoveElement action = new Q27_RemoveElement();
        int[] nums = new int[]{3, 2, 2, 3};
        action.removeElement(nums, 3);
    }
}
