package com.yhyr.Algorithm;

import java.util.*;

/**
 * Subject:
 * 给定一个仅包含数字2-9的字符串，返回所有它可能表示的字母组合。数字到字母的映射与电话按键相同。
 * @author yhyr
 * @since 2019/09/15 11:00
 */
public class Q17_LetterCombination {
    private static Map<Character, List<String>> numLetterMapping = new HashMap<Character, List<String>>() {
        {
            put('2', Arrays.asList("a", "b", "c"));
            put('3', Arrays.asList("d", "e", "f"));
            put('4', Arrays.asList("g", "h", "i"));
            put('5', Arrays.asList("j", "k", "l"));
            put('6', Arrays.asList("m", "n", "o"));
            put('7', Arrays.asList("p", "q", "r", "s"));
            put('8', Arrays.asList("t", "u", "v"));
            put('9', Arrays.asList("w", "x", "y", "z"));
        }
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        char[] chars = digits.toCharArray();
        if (chars.length == 0) {
            return result;
        }
        result = numLetterMapping.get(chars[0]);
        for (int i = 1; i < chars.length; i++) {
            result = combination(result, numLetterMapping.get(chars[i]));
        }
        return result;
    }

    private List<String> combination(List<String> list1, List<String> list2) {
        List<String> result = new ArrayList<>();
        for (String s1 : list1) {
            for (String s2 : list2) {
                result.add(s1 + s2);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Q17_LetterCombination action = new Q17_LetterCombination();
        List<String> result = action.letterCombinations("234");
        result.forEach(System.out::println);
    }
}
