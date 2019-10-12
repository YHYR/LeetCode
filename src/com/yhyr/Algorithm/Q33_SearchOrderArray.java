package com.yhyr.Algorithm;

/**
 * Subject：假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * 
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 
 * 你可以假设数组中不存在重复的元素。
 * 
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 
 * @author yhyr
 * @since 2019/10/01 17:42
 */
public class Q33_SearchOrderArray {
    /**
     * 运行超时
     * 
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
                } else if (nums[start] > nums[mid] && nums[mid] > target) {
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

    /**
     * 首先寻找旋转点，然后基于二分法进行查找
     *
     * 提交超时
     * 
     * @param nums
     * @param target
     * @return
     */
    public int search2(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid = 0; // 旋转点
        // 寻找旋转点
        while (nums[start] > nums[end]) {
            mid = (start + end) / 2;
            if (start == mid) {
                if (nums[start] < nums[start + 1]) {
                    mid = 0;
                } else {
                    mid = start + 1;
                }
                break;
            }
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                mid += 1;
                break; // [4, 5, 6, 2, 3]
            } else if (nums[mid] < nums[mid - 1] && nums[mid] < nums[mid + 1]) {
                break; // [4, 5, 1, 2, 3]
            } else {
                if (nums[mid] > nums[start]) {
                    start = mid + 1; // [2, 3, 4, 5, 1]
                }
                if (nums[mid] < nums[start]) {
                    end = mid - 1; // [5, 1, 2, 3, 4]
                }
            }
        }
        if (mid == 0) {
            return binarySearch(nums, 0, nums.length - 1, target);
        } else if (target >= nums[mid] && target <= nums[nums.length - 1]) {
            // mid - end
            return binarySearch(nums, mid, nums.length - 1, target);
        } else {
            // start - (mid - 1)
            return binarySearch(nums, 0, mid - 1, target);

        }
    }

    private int binarySearch(int[] nums, int start, int end, int target) {
        int mid;
        while (start <= end) {
            if (nums[start] == target) {
                return start;
            } else if (nums[end] == target) {
                return end;
            } else {
                mid = (start + end) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] > target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
                return binarySearch(nums, start, end, target);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Q33_SearchOrderArray action = new Q33_SearchOrderArray();
        System.out.println(action.search2(new int[] {4, 5, 6, 7, 0, 1, 2}, 0));
    }
}
