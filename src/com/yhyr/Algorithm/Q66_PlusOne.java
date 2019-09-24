package com.yhyr.Algorithm;

import java.util.Arrays;

/**
 * Subject: 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字
 * 
 * @author yhyr
 * @since 2019/09/24 22:29
 */
public class Q66_PlusOne {
    public int[] plusOne(int[] digits) {
        int bitFlag;
        int sum = digits[digits.length - 1] + 1;
        if (sum == 10) {
            digits[digits.length - 1] = 0;
            bitFlag = 1;
        } else {
            digits[digits.length - 1] = sum;
            return digits;
        }
        for (int i = digits.length - 2; i >= 0; i--) {
            int tmp = digits[i] + bitFlag;
            if (tmp == 10) {
                digits[i] = 0;
                bitFlag = 1;
            } else {
                digits[i] = tmp;
                bitFlag = 0;
                break;
            }
        }
        if (bitFlag == 1) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            for (int i = 0; i < digits.length; i++) {
                result[i + 1] = digits[i];
            }
            return result;
        }
        return digits;
    }

    public static void main(String[] args) {
        Q66_PlusOne action = new Q66_PlusOne();
        System.out.println(Arrays.toString(action.plusOne(new int[] {1, 2, 3})));
    }
}
