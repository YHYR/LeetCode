package com.yhyr.Algorithm;

/**
 * Subject: 验证回文串
 * 
 * @author yhyr
 * @since 2019/09/24 21:42
 */
public class Q125_IsPalindrome {
    public boolean isPalindrome(String s) {
        char[] chars = s.toLowerCase().toCharArray();
        int i = 0;
        int j = chars.length - 1;
        while (i < j) {
            while (i < chars.length &&!(chars[i] >= '0' && chars[i] <= '9') && !(chars[i] >= 'a' && chars[i] <= 'z')) {
                i++;
            }
            while (j >= 0 && !(chars[j] >= '0' && chars[j] <= '9') && !(chars[j] >= 'a' && chars[j] <= 'z')) {
                j--;
            }
            if (i <= j) {
                if (chars[i] == chars[j]) {
                    i++;
                    j--;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Q125_IsPalindrome action = new Q125_IsPalindrome();
         System.out.println(action.isPalindrome("A man, a plan, a canal: Panama "));
    }
}
