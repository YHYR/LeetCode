package com.yhyr.Algorithm;

/**
 * Subject
 * 最长回文串
 *
 * @author yhyr
 * @since 2019/01/09 19:35
 */
public class Q5_LongestPalindrome {
    public String longestPalindrome(String s) {
        if (s.length() > 1) {
            char[] charArray = s.toCharArray();
            String result = "";
            for (int i = 0; i < charArray.length - 1; i++) {
                // 执行两遍 待优化
                String r1 = checkPalindrome(charArray, s, i, i);
                String r2 = checkPalindrome(charArray, s, i, i+1);
                String r3 = (r1.length() > r2.length()) ? r1 : r2;
                if (r3.length() > result.length()) {
                    result = r3;
                }
            }
            return result;

        } else if (s.length() == 1) {
            return s.substring(0, 1);
        } else {
            return "";
        }
    }
    private String checkPalindrome(char[] charArray, String s, int left, int right) {
        while (left >= 0 && right <=charArray.length - 1) {
            if (charArray[left] == charArray[right]) {
                left--;
                right++;
            } else {
                break;
            }
        }
        return s.substring(left+1, right);
    }

    public static void main(String[] args) {
        Q5_LongestPalindrome action = new Q5_LongestPalindrome();
        System.out.println(action.longestPalindrome("a"));
    }
}
