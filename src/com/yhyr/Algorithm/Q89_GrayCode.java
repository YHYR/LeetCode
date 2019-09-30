package com.yhyr.Algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * Subject: 格列编码
 * 
 * 格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。
 * 
 * 给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。格雷编码序列必须以 0 开头。
 *
 * 解题思路：找规律
 * 当n = 1时，=> [0, 1]
 * 当n = 2时，=> [00, 01, 11, 10]
 * 当n = 3时，=> [000, 001, 011, 010, 110, 111, 101, 100]
 *
 * n = 2可以看做是：在n=1的基础上，在反向依次增加2
 * n = 3可以看做是：在n=2的基础上，在反向依次增加4
 * @author yhyr
 * @since 2019/09/30 15:43
 */
public class Q89_GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> results = new ArrayList<>();
        if (n == 0) {
            results.add(0);
            return results;
        }
        results.add(0);
        results.add(1);
        if (n == 1) {
            return results;
        }
        int increase;
        for (int i = 2; i <= n; i++) {
            increase = 1 << (i - 1);
            for (int j = results.size() - 1; j >= 0; j--) {
                results.add(results.get(j) + increase);
            }
        }
        return results;
    }

    public static void main(String[] args) {
        Q89_GrayCode action = new Q89_GrayCode();
        action.grayCode(3);
    }
}
