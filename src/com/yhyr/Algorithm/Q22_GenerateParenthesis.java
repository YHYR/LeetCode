package com.yhyr.Algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * Subject：
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 解题思路：
 * 采用递归的思路构造所有有效的结果集。有效结果集成立的条件为：
 * + 1，当左括号总个数count小于n时，左括号后面可追加右括号或左括号；反之只能匹配右括号
 * + 2，当左括号总个数count小于n，且未匹配左括号个数大于零时，右括号后面可追加左括号或右括号
 * + 3，当左括号总个数count小于n，但未匹配左括号个数等于零时，右括号后面可追加左括号
 *
 * 可以把整个实现思路抽象成一棵树来理解：
 * ----------------------------- (
 * ----------------- (( ----------------------()
 * --------- ((( --------- (() ------------- ()(
 * --------- ((() -- (()( --- (()) --- ()(( ------ ()()
 * .......................................................
 * @author yhyr
 * @since 2019/09/15 14:41
 */
public class Q22_GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        List<String> resultList = new ArrayList<>();
        if (n == 0) {
            return resultList;
        }
        int count = 1; // 左括号总个数
        int index = 1; // 未参与匹配的左括号个数
        String result = "(";
        generate(n, count, index, result, resultList);
        return resultList;
    }

    private void generate(int n, int count, int index, String result, List<String> resultList) {
        if (count == n) {
            while (index-- > 0) {
                result += ")";
            }
            resultList.add(result);
            return;
        }
        if (result.endsWith(")")) {
            if (index > 0) {
                generate(n, count, index - 1, result + ")", resultList);
            }
            generate(n, count + 1, index + 1, result + "(", resultList);
        } else {
            generate(n, count + 1, index + 1, result + "(", resultList);
            generate(n, count, index - 1, result + ")", resultList);
        }
    }

    public static void main(String[] args) {
        Q22_GenerateParenthesis action = new Q22_GenerateParenthesis();
        action.generateParenthesis(3).forEach(System.out::println);
    }
}
