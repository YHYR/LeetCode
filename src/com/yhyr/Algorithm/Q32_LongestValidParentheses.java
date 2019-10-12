package com.yhyr.Algorithm;

/**
 * Subject: 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 *
 * 解题思路：动态规划
 * 初始化int数组dp，依次遍历每一个字符
 * Step1 如果是(，则将对应下标置为0，继续遍历；
 * Step2 如果是)，则从当前下标i开始往前追溯寻找第一个值为0的元素j；将该i和j都置为1
 * Step3 如果往前追溯遍历遇到-1，则退出遍历，将当前下标置为-1
 * Step4 如果遍历到第一个元素也没找到0，则将i置为-1
 * Step5 遍历dp数组，找出连续最大值
 *
 * @author yhyr
 * @since 2019/10/07 20:58
 */
public class Q32_LongestValidParentheses {

    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                dp[i] = 0;
            } else {
                int j = i - 1;
                for (; j >= 0; j--) {
                    if (dp[j] == 0) {
                        dp[j] = 1;
                        dp[i] = 1;
                        break;
                    } else if (dp[j] == 1) {
                        continue;
                    } else if (dp[j] == -1) {
                        dp[i] = -1;
                        break;
                    }
                }
                if (j < 0) {
                    dp[i] = -1;
                }
            }
        }
        int max = 0;
        int count = 0;
        for (int i : dp) {
            if (i == 1) {
                count += 1;
            } else {
                max = (max > count) ? max : count;
                count = 0;
            }
        }
        return (max > count) ? max : count;
    }

    public static void main(String[] args) {
        Q32_LongestValidParentheses action = new Q32_LongestValidParentheses();
         System.out.println(action.longestValidParentheses("(()(((()"));
    }
}
