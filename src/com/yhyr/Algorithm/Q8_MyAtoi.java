package com.yhyr.Algorithm;

/**
 * Subject: 实现一个 atoi 函数，使其能将字符串转换成整数。
 * 
 * 用long型来接受结果集，从而方便越界的判断
 * 
 * @author yhyr
 * @since 2019/10/04 21:52
 */
public class Q8_MyAtoi {
    public int myAtoi(String str) {
        char[] chars = str.trim().toCharArray();
        if (chars.length == 0 || !(chars[0] >= '0' && chars[0] <= '9' || chars[0] == '-' || chars[0] == '+')) {
            return 0;
        }
        boolean flag = chars[0] == '-';
        int index = (chars[0] == '-' || chars[0] == '+') ? 1 : 0;
        long value = 0;
        for (; index < chars.length; index++) {
            if (chars[index] >= '0' && chars[index] <= '9') {
                value = value * 10 + Integer.valueOf(String.valueOf(chars[index]));
                if (value > Integer.MAX_VALUE) {
                    if (flag) {
                        return Integer.MIN_VALUE;
                    } else {
                        return Integer.MAX_VALUE;
                    }
                }
            } else {
                break;
            }
        }
        if (flag) {
            value *= -1;
        }
        return (int)value;
    }

    public static void main(String[] args) {
        Q8_MyAtoi action = new Q8_MyAtoi();
        System.out.println(action.myAtoi("+42"));
    }
}
