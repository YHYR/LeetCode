package com.yhyr.Algorithm;

import java.util.*;

/**
 * Subject:
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * @author yhyr
 * @since 2019/01/05 13:25
 */
public class Q3_LongestSubString {
    public int lengthOfLongestSubstring(String s) {
        char[] charArray = s.toCharArray();
        int begin = 0;
        int end = 1;
        if (charArray.length == 0) {
            return 0;
        }
        List<Integer> resultList = new ArrayList<>();
        buildSubString(charArray, begin, end, resultList);
        return Collections.max(resultList);
    }

    private void buildSubString(char[] strArray, int begin, int end, List<Integer> resultList) {
        List<Character> subStrList = new ArrayList<>();
        boolean flag = true;

        for (int i = begin; i < end; i++) {
            subStrList.add(strArray[i]);
        }
        while (flag && end < strArray.length) {
            char next = strArray[end];
            for (int i = 0; i < subStrList.size(); i++) {
                if (next == subStrList.get(i)) {
                    begin = begin + i + 1;
                    flag = false;
                    break;
                }
            }

            if (flag) {
                end = end + 1;
                subStrList.add(next);
            }
        }
        resultList.add(subStrList.size());

        if (end < strArray.length) {
            buildSubString(strArray, begin, end, resultList);
        }
    }

    private int lengthOfLongestSubstring2(String s) {
        Set<Character> set = new HashSet<>();
        int len = 0;
        int left = 0;
        int right = 0;
        while (left < s.length() && right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right++));
                len = (len > right - left) ? len : right - left;
            } else {
                set.remove(s.charAt(left++));
            }
        }
        return len;
    }

    public static void main(String[] args) {
        Q3_LongestSubString action = new Q3_LongestSubString();
        System.out.println(action.lengthOfLongestSubstring2("dvdf"));

    }

}
