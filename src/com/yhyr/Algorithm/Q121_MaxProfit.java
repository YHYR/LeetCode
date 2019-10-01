package com.yhyr.Algorithm;

/**
 * Subject: 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 * 
 * 注意你不能在买入股票前卖出股票。
 * 
 * @author yhyr
 * @since 2019/09/28 14:34
 */
public class Q121_MaxProfit {
    /**
     * 暴力解法
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices.length == 0 || prices.length == 1) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] < prices[j]) {
                    int tmp = prices[j] - prices[i];
                    result = (tmp > result) ? tmp : result;
                }
            }
        }
        return result;
    }

    /**
     * O(n)时间复杂度的高效解法
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        if (prices.length == 0 || prices.length == 1) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int result = 0;
        int tmp;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] <= min) {
                min = prices[i];
            } else {
                tmp = prices[i] - min;
                result = (tmp > result) ? tmp : result;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Q121_MaxProfit action = new Q121_MaxProfit();
        System.out.println(action.maxProfit2(new int[] {7, 1, 5, 3, 6, 4}));
    }
}
