package com.yhyr.Algorithm;

/**
 * @author yhyr
 * @since 2019/09/30 0:48
 */
public class Q344_ReverseString {
    public void reverseString(char[] s) {
        char tmp;
        for (int i = 0, j = s.length-1; i < j; i++, j--) {
            tmp = s[j];
            s[j] = s[i];
            s[i] = tmp;
        }
    }
}
