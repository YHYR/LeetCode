package com.yhyr.Algorithm;

/**
 * Subject
 * 最长公共前缀
 *
 * @author yhyr
 * @since 2019/3/2 0002 18:05
 */
public class Q14_LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        for (int i = 1; i <= strs[0].length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (!strs[j].startsWith(strs[0].substring(0, i))) {
                    if (i == 1) {
                        return "";
                    } else {
                        return strs[0].substring(0, i - 1);
                    }
                }
            }
        }
        return strs[0];
    }

    public static void main(String[] args) {
        Q14_LongestCommonPrefix action = new Q14_LongestCommonPrefix();
        String[] strs = {"a", "b"};
        System.out.println(action.longestCommonPrefix(strs));
    }
}
