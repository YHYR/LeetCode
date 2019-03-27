package com.yhyr.Algorithm;

/**
 * Subject
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * <p>
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * <p>
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * @author yhyr
 * @since 2019/3/27 0027 9:25
 */
public class Q4_FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length + nums2.length];
        int index = 0;
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                result[index] = nums1[i];
                i++;
            } else {
                result[index] = nums2[j];
                j++;
            }
            index++;
        }
        while (i < nums1.length) {
            result[index++] = nums1[i++];
        }
        while (j < nums2.length) {
            result[index++] = nums2[j++];
        }

        if (result.length % 2 == 0) {
            return (result[result.length / 2 - 1] + result[result.length / 2]) * 1.0 / 2;
        } else {
            return result[result.length / 2];
        }
    }

    public static void main(String[] args) {
        Q4_FindMedianSortedArrays action = new Q4_FindMedianSortedArrays();
        int[] nums1 = new int[]{1, 3};
        int[] nums2 = new int[]{2, 4};
        action.findMedianSortedArrays(nums1, nums2);
    }
}
