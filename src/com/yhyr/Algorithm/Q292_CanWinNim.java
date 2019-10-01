package com.yhyr.Algorithm;

/**
 * Subject: 你和你的朋友，两个人一起玩 Nim 游戏：桌子上有一堆石头，每次你们轮流拿掉 1 - 3 块石头。 拿掉最后一块石头的人就是获胜者。你作为先手。
 * 
 * @author yhyr
 * @since 2019/10/01 16:50
 */
public class Q292_CanWinNim {
    /**
     * 通过非来控制奇偶性
     *
     * Eg：假设每次都去三个，且n = 9，则canWinNim(9) = !canWinNim(6) = !!canWinNim(3) = canWinNim(3) = true
     *
     * @param n
     * @return
     */
    public boolean canWinNim(int n) {
        if (n <= 0) {
            return false;
        }
        if (n <= 3) {
            return true;
        }
        return !canWinNim(n - 1) || !canWinNim(n - 2) || !canWinNim(n - 3);
    }

    public boolean canWinNim2(int n) {
        return n % 4 != 0;
    }

    public static void main(String[] args) {
        Q292_CanWinNim action = new Q292_CanWinNim();
        System.out.println(action.canWinNim(5));
    }
}
