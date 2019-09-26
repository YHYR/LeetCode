package com.yhyr.Algorithm;

import java.util.Arrays;

/**
 * Subject: 有序数组。
 * 
 * 说明:
 * 
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/merge-sorted-array 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author yhyr
 * @since 2019/09/26 23:30
 */
public class Q88_Merge2SortArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = 1;
        int i = m - 1;
        int j = n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[m + n - index++] = nums1[i--];
            } else if (nums1[i] == nums2[j]) {
                nums1[m + n - index++] = nums1[i--];
                nums1[m + n - index++] = nums2[j--];
            } else {
                nums1[m + n - index++] = nums2[j--];
            }
        }
        while (i >= 0) {
            nums1[m + n - index++] = nums1[i--];
        }
        while (j >= 0) {
            nums1[m + n - index++] = nums2[j--];
        }
    }

    public static void main(String[] args) {
        Q88_Merge2SortArray action = new Q88_Merge2SortArray();
        int[] nums1 = {0, 0};
        int[] nums2 = {1};
        action.merge(nums1, 0, nums2, 1);
        System.out.println(Arrays.toString(nums1));
    }
}
