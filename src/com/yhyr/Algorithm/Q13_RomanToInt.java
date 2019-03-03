package com.yhyr.Algorithm;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Subject
 * 罗马数据转Int
 *
 * @author yhyr
 * @since 2019/3/2 0002 17:42
 */
public class Q13_RomanToInt {

    Map<String, Integer> romanMapping = new LinkedHashMap<String, Integer>(){
        {
            put("M", 1000);
            put("CM", 900);
            put("D", 500);
            put("CD", 400);
            put("C", 100);
            put("XC", 90);
            put("L", 50);
            put("XL", 40);
            put("X", 10);
            put("IX", 9);
            put("V", 5);
            put("IV", 4);
            put("I", 1);
        }
    };
    public int romanToInt(String s) {
        int result = 0;
        while (s != null && !s.equals("")){
            for (String key : romanMapping.keySet()) {
                if (s.startsWith(key)) {
                    result += romanMapping.get(key);
                    s = s.replaceFirst(key, "");
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Q13_RomanToInt action = new Q13_RomanToInt();
        String s = "MCMXCIV";
        System.out.println(action.romanToInt(s));
    }
}
