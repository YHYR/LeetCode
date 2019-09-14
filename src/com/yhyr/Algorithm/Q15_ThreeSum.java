package com.yhyr.Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Subject: 给定一个包含n个整数的数组nums，判断nums中是否存在三个元素a,b,c；使得a+b+c=0；找出所有满足条件且不重复的三元组
 * 
 * 解题思路:
 *  Step 1：首先将数组按升序排序，只需遍历负数的部分，用来作为元素a
 *  Step 2：然后将a的下一个作为b，将数组最后一个元素作为b，判断a+b+c=0是否成立
 *  Step 3：如果成立则bc同时改变(分别向右向左移动)；如果之和大于零，则b左右；之和小于零则c右移
 *
 * 注意事项：
 *  a) 在用数组的负数部分作为元素a进行遍历时，需要消除同值被多次遍历的情况
 *  b) 在a+b+c=0成立时，移动bc时需要排除同值情况
 *
 * @author yhyr
 * @since 2019/09/14 15:11
 */
public class Q15_ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        nums = quickSort(nums, 0, nums.length - 1);
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                return resultList;
            }
            // 消除a出现相同值的情况
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int b = i + 1;
            int c = len - 1;
            while (b < c) {
                int sum = nums[i] + nums[b] + nums[c];
                if (sum == 0) {
                    resultList.add(Arrays.asList(nums[i], nums[b], nums[c]));
                    // 消除b和c重复的情况
                    while (b < c && nums[b] == nums[b + 1]) {
                        b++;
                    }
                    while (b < c && nums[c] == nums[c - 1]) {
                        c--;
                    }
                    // 如果满足公式，则b和c同时改变
                    b++;
                    c--;
                } else if (sum < 0) {
                    b++;
                } else {
                    c--;
                }
            }
        }
        return resultList;
    }

    private int[] quickSort(int[] nums, int b, int c) {
        if (b < c) {
            int middle = partition(nums, b, c);
            quickSort(nums, b, middle - 1);
            quickSort(nums, middle + 1, c);
        }
        return nums;
    }

    private int partition(int[] nums, int b, int c) {
        int key = nums[b];
        while (b < c) {
            while (b < c && nums[c] >= key) {
                c--;
            }
            nums[b] = nums[c];
            while (b < c && nums[b] <= key) {
                b++;
            }
            nums[c] = nums[b];
        }
        nums[b] = key;
        return b;
    }

    public static void main(String[] args) {
        Q15_ThreeSum action = new Q15_ThreeSum();
        int[] nums = {-1, 0, 1, 2, -1, -4, 3, 2, 4, -2, -2, 1, 1};
        List<List<Integer>> resultList = action.threeSum(nums);
        resultList.forEach(result -> System.out.println(result.toString()));
    }
}
