package com.yhyr.Algorithm;

import java.util.Collections;

/**
 * Subject: 整数转罗马数字
 *
 * @author yhyr
 * @since 2019/3/2 0002 16:11
 */
public class Q12_IntToRoman {

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            if (num > 1000) {
                sb.append(String.join("", Collections.nCopies(num / 1000, "M")));
                num = num % 1000;
                continue;
            } else if (num >= 900) {
                sb.append("CM");
                num = num - 900;
                continue;
            } else if (num >= 500) {
                sb.append("D");
                num = num - 500;
                continue;
            } else if (num >= 400) {
                sb.append("CD");
                num = num - 400;
                continue;
            } else if (num >= 100) {
                sb.append(String.join("", Collections.nCopies(num / 100, "C")));
                num = num % 100;
                continue;
            } else if (num >= 90) {
                sb.append("XC");
                num = num - 90;
                continue;
            } else if (num >= 50) {
                sb.append("L");
                num = num - 50;
                continue;
            } else if (num >= 40) {
                sb.append("XL");
                num = num - 40;
                continue;
            } else if (num >= 10) {
                sb.append(String.join("", Collections.nCopies(num / 10, "X")));
                num = num % 10;
                continue;
            } else if (num == 9) {
                sb.append("IX");
                return sb.toString();
            } else if (num >= 5) {
                sb.append("V");
                num = num - 5;
                continue;
            } else if (num == 4) {
                sb.append("IV");
                return sb.toString();
            } else if (num < 4) {
                sb.append(String.join("", Collections.nCopies(num, "I")));
                return sb.toString();
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Q12_IntToRoman action = new Q12_IntToRoman();
        int num = 100;
        System.out.println(action.intToRoman(num));
    }
}
