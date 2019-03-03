package com.yhyr.Algorithm;

/**
 * Subject:
 * 将一个32位的整数翻转; 如果翻转结果溢出, 返回结果为0
 *
 * @author yhyr
 * @since 2019/2/28 0028 23:29
 */
public class Q7_ReverseIntNum {
    public int reverse(int x) {
        String str = (x >= 0) ? String.valueOf(x) : String.valueOf(x * -1);
        char[] chars = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            chars[str.length() - i - 1] = str.charAt(i);
        }
        int result;
        try {
            result = Integer.parseInt(String.valueOf(chars));
            if (x < 0) {
                result = result * -1;
            }
        } catch (Exception e) {
            result = 0;
        }
        return result;
    }

    public static void main(String[] args) {
        Q7_ReverseIntNum action = new Q7_ReverseIntNum();
        int x = -11012000;
        System.out.println(action.reverse(x));
    }
}
