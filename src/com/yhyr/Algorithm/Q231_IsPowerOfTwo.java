package com.yhyr.Algorithm;

/**
 * Subject: 判断一个整数是否是2的幂次方
 * 
 * @author yhyr
 * @since 2019/09/29 22:55
 */
public class Q231_IsPowerOfTwo {
    /**
     * 超时
     * 
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {
        if (n == 0) {
            return false;
        }
        int val = 1;
        while (true) {
            if (val == n) {
                return true;
            } else if (val < n) {
                val = val << 1;
            } else {
                return false;
            }
        }
    }

    public boolean isPowerOfTwo2(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        Q231_IsPowerOfTwo action = new Q231_IsPowerOfTwo();
        System.out.println(action.isPowerOfTwo(50));
    }
}
