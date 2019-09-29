package com.yhyr.Algorithm;

/**
 * @author yhyr
 * @since 2019/09/30 0:51
 */
public class Q557_ReverseWords {
    public String reverseWords(String s) {
        String[] strArray = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(reverseString(strArray[0].toCharArray()));
        for (int i = 1; i < strArray.length; i++) {
            stringBuilder.append(" " + reverseString(strArray[i].toCharArray()));
        }
        return stringBuilder.toString();
    }

    private String reverseString(char[] s) {
        char tmp;
        for (int i = 0, j = s.length-1; i < j; i++, j--) {
            tmp = s[j];
            s[j] = s[i];
            s[i] = tmp;
        }
        return String.valueOf(s);
    }
}
