package com.yhyr.Algorithm;

import java.util.Arrays;

/**
 * @author yhyr
 * @since 2019/09/27 23:10
 */
public class Q16_ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = 0;
        int minStep = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                int tmp;
                if (sum == target) {
                    return target;
                } else if (sum < target) {
                    start++;
                    tmp = target - sum;
                } else {
                    end--;
                    tmp = sum - target;
                }
                if (tmp < minStep) {
                    minStep = tmp;
                    result = sum;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Q16_ThreeSumClosest action = new Q16_ThreeSumClosest();
        int[] num = {-1, 2, 1, -4};
        int target = 1;
        System.out.println(action.threeSumClosest(num, target));
    }
}
