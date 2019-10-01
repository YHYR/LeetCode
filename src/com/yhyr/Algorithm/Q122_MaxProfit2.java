package com.yhyr.Algorithm;

/**
 * Subject: 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 解题思路：通过分别记录每个波内的最大利润和全局范围内的最大利润；然后选择值较大的情况
 *
 * @author yhyr
 * @since 2019/10/01 15:26
 */
public class Q122_MaxProfit2 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0 || prices.length == 1) {
            return 0;
        }
        int minValue = prices[0]; // 全局最小值
        int result = 0; // 全局最大波峰 - 全局最小波谷
        int troughMinValue = prices[0]; // 单个波谷值
        int singleTroughResult = 0; // 单个波内的最大利润
        int totalTroughResult = 0; // 全局范围内所有波的最大利润
        int tmp;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minValue) {
                minValue = prices[i];
            } else {
                tmp = prices[i] - minValue;
                result = (result < tmp) ? tmp : result;
            }
            if (prices[i] < prices[i - 1]) {
                troughMinValue = prices[i];
                totalTroughResult += singleTroughResult;
                singleTroughResult = 0;
            } else {
                singleTroughResult = prices[i] - troughMinValue;
            }
        }
        totalTroughResult += singleTroughResult;
        return (totalTroughResult > result) ? totalTroughResult : result;
    }

    public static void main(String[] args) {
        Q122_MaxProfit2 action = new Q122_MaxProfit2();
        System.out.println(action.maxProfit(new int[] {7, 1, 3, 5, 2, 4, 7}));
    }
}
