package com.yhyr.Algorithm;

/**
 * Subject
 * 实现 strStr() 函数。
 * <p>
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。
 * 如果不存在，则返回-1。
 *
 * @author yhyr
 * @since 2019/3/28 0028 10:02
 */
public class Q28_StrStr {
    public int strStr(String haystack, String needle) {
        if (haystack.isEmpty() && needle.isEmpty()) {
            return -1;
        }
        char[] haystackArray = haystack.toCharArray();
        char[] needleArray = needle.toCharArray();
        for (int i = 0; i < haystackArray.length - needleArray.length + 1; i++) {
            int j = 0;
            int temp = i;
            while (j < needleArray.length) {
                if (haystackArray[temp] == needleArray[j]) {
                    temp += 1;
                    j += 1;
                } else {
                    break;
                }
            }
            if (j == needleArray.length) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Q28_StrStr action = new Q28_StrStr();
        String haystack = "a";
        String needle = "a";
        int a = action.strStr(haystack, needle);
    }
}
