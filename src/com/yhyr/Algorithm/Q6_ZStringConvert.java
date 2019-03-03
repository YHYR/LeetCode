package com.yhyr.Algorithm;

import java.util.*;

/**
 * Subject
 * Z字形变换
 *
 * @author yhyr
 * @since 2019/2/28 0028 22:12
 */
public class Q6_ZStringConvert {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int step = 2 * numRows - 2;
        Map<Integer, String> summary = new HashMap<>();

        for (int i = 0; i < s.length(); i += step) {
            Map<Integer, String> temp;
            if (i + step > s.length()) {
                temp = build(s.substring(i, s.length()), numRows);
            } else {
                temp = build(s.substring(i, i + step), numRows);
            }

            temp.forEach((key, str) -> {
                if (summary.keySet().contains(key)) {
                    summary.put(key, summary.get(key) + str);
                } else {
                    summary.put(key, str);
                }
            });
        }

        String result = "";
        for (String ss : summary.values()) {
            result += ss;
        }
        return result;
    }

    private Map<Integer, String> build(String s, Integer numRows) {
        Map<Integer, String> map = new HashMap();
        char[] c = s.toCharArray();
        int index = 1;
        for (char cc : c) {
            if (index <= numRows) {
                map.put(index, String.valueOf(cc));
            } else {
                int key = numRows - (index - numRows);
                map.put(key, map.get(key) + cc);
            }
            index++;
        }
        return map;
    }

    public static void main(String[] args) {
        String s = "A";
        int numRows = 1;
        Q6_ZStringConvert action = new Q6_ZStringConvert();
        System.out.println(action.convert(s, numRows));

    }
}
