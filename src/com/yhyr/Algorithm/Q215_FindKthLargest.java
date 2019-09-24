package com.yhyr.Algorithm;

/**
 * Subject: 数组中的第K个最大元素
 *
 * 解题思路：
 * 
 * 方案一 先排序在取第K个值 时间复杂度较高logN，且无效排序过多
 * 
 * 方案二 采用堆排序，只需要建立K个最大堆即可
 * 
 * @author yhyr
 * @since 2019/09/25 0:49
 */
public class Q215_FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        for (int i = nums.length - 1; i >= 0; i--) {
            int maxValue = maxHeapSort(nums, i);
            nums[0] = nums[i];
            nums[i] = maxValue;
            if (i + k == nums.length) {
                return maxValue;
            }
        }
        return 0;
    }

    private int maxHeapSort(int[] nums, int length) {
        int mid = length / 2;
        if ((length % 2 != 0)) {
            mid += 1;
        }
        for (int i = mid; i >= 0; i--) {
            int leftChild = i * 2 + 1;
            int rightChild = i * 2 + 2;
            if (leftChild <= length) {
                if (nums[leftChild] > nums[i]) {
                    int tmp = nums[i];
                    nums[i] = nums[leftChild];
                    nums[leftChild] = tmp;
                }
            }
            if (rightChild <= length) {
                if (nums[rightChild] > nums[i]) {
                    int tmp = nums[i];
                    nums[i] = nums[rightChild];
                    nums[rightChild] = tmp;
                }
            }
        }
        return nums[0];
    }

    public static void main(String[] args) {
        Q215_FindKthLargest action = new Q215_FindKthLargest();
        int[] array = new int[] {3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(action.findKthLargest(array, 4));

    }
}
