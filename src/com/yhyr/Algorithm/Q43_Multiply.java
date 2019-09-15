package com.yhyr.Algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yhyr
 * @since 2019/09/15 15:47
 */
public class Q43_Multiply {
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        int[] array1 = str2IntArray(num1);
        int[] array2 = str2IntArray(num2);
        List<String> resultList = new ArrayList<>();
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                int tmp = array1[i] * array2[j];
                String tmpStr = String.valueOf(tmp);
                for (int k = 0; k < i + j; k++) {
                    tmpStr += "0";
                }
                resultList.add(tmpStr);
            }
        }
        int[] resultArray = str2IntArray(resultList.get(0));
        for (int i = 1; i < resultList.size(); i++) {
            int[] elemArray = str2IntArray(resultList.get(i));
            resultArray = arrayAdd(resultArray, elemArray);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = resultArray.length - 1; i >= 0; i--) {
            sb.append(resultArray[i]);
        }
        return sb.toString();
    }

    private int[] arrayAdd(int[] array1, int[] array2) {
        if (array1.length < array2.length) {
            int[] tmp = array2;
            array2 = array1;
            array1 = tmp;
        }
        boolean flag = false; // 进位标识符
        int index = 0;
        while (index < array2.length) {
            int tmp = array1[index] + array2[index];
            if (flag) {
                tmp += 1;
            }
            if (tmp < 10) {
                array1[index] = tmp;
                flag = false;
            } else {
                array1[index] = tmp - 10;
                flag = true;
            }
            index++;
        }
        if (!flag) {
            return array1;
        }
        if (index == array1.length) {
            return resize(array1);
        }
        for (int i = index; i < array1.length; i++) {
            int tmp = array1[i] + 1;
            if (tmp < 10) {
                array1[i] = tmp;
                return array1;
            } else {
                array1[i] = 0;
            }
        }
        return resize(array1);
    }

    private int[] resize(int[] array) {
        int[] result = new int[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i];
        }
        result[array.length] = 1;
        return result;
    }

    private int[] str2IntArray(String str) {
        char[] chars = str.toCharArray();
        int[] result = new int[chars.length];
        int index = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            result[index++] = Integer.valueOf(String.valueOf(chars[i]));
        }
        return result;
    }

    public static void main(String[] args) {
        Q43_Multiply action = new Q43_Multiply();
        System.out.println(action.multiply("24", "25"));
    }
}
