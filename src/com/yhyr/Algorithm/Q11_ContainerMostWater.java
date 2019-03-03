package com.yhyr.Algorithm;

/**
 * Subject
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * Tips: 双指针法 => 移动方向为值小的一边移向值大的一边
 * 时间复杂度 O(n)
 * 空间复杂度O(1)
 *
 * @author yhyr
 * @since 2019/3/2 0002 15:04
 */
public class Q11_ContainerMostWater {

    public int maxArea(int[] height) {
        if (height.length == 2) {
            return Math.min(height[0], height[1]);
        }
        int maxArea = 0;
        for (int i = 0, j = height.length - 1; i < j; ) {
            int temp;
            if (height[i] < height[j]) {
                temp = height[i] * (j - i);
                i++;
            } else {
                temp = height[j] * (j - i);
                j--;
            }
            maxArea = Math.max(maxArea, temp);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        Q11_ContainerMostWater action = new Q11_ContainerMostWater();
        int[] height = {2, 3, 4, 5, 18, 17, 6};
        System.out.println(action.maxArea(height));
    }
}
