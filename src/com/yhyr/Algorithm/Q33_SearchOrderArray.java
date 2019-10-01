package com.yhyr.Algorithm;

/**
 * @author yhyr
 * @since 2019/10/01 17:42
 */
public class Q33_SearchOrderArray {
    /**
     * 超时
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return (nums[0] == target) ? 0 : -1;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start <= end) {
            mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            } else {
                if (nums[start] == target) {
                    return start;
                }
                if (nums[end] == target) {
                    return end;
                }
                if (nums[start] < target && nums[mid] > target) {
                    end = mid - 1;
                } else if (nums[start] < target && nums[mid] < target) {
                    start = mid + 1;
                } else if (nums[start] < nums[mid] && nums[mid] > target) {
                    // [4,5,6,7,0,1,2] 1
                    start = mid + 1;
                } else if (nums[start] < nums[mid] && nums[mid] < target) {
                    // [3, 4, 5, 6, 7, 1, 2] 7
                    start = mid + 1;
                } else if (nums[start] > nums[mid] && nums[mid] > target){
                    // [5, 1, 2, 3, 4] 1
                    end = mid - 1;
                } else if (nums[start] > nums[mid] && nums[mid] < target) {
                    // [5, 1, 2, 3, 4] 3
                    start = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Q33_SearchOrderArray action = new Q33_SearchOrderArray();
        System.out.println(action.search(new int[] {8, 1, 2, 3, 4, 5, 6, 7}, 6));
    }
}
