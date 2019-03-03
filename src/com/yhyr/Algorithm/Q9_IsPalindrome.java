package com.yhyr.Algorithm;

/**
 * Subject:
 * 判断一个数字是否是回文数
 *
 * @author yhyr
 * @since 2019/2/28 0028 23:52
 */
public class Q9_IsPalindrome {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return Boolean.FALSE;
        } else if (x == 0) {
            return Boolean.TRUE;
        } else {
            if (x == reverse(x)) {
                return Boolean.TRUE;
            } else {
                return Boolean.FALSE;
            }
        }
    }

    private int reverse(int x) {
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
        Q9_IsPalindrome action = new Q9_IsPalindrome();
        int x = 121;
        System.out.println(action.isPalindrome(x));
    }
}
