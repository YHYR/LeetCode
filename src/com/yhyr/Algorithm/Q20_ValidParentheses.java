package com.yhyr.Algorithm;

import java.util.Stack;

/**
 * Subject:
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 * @author: yhyr
 * @since: 2019/3/25 0025 10:31
 */
public class Q20_ValidParentheses {
    public boolean isValid(String s) {
        Stack<String> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            String cs = Character.toString(c);

            if (stack.isEmpty() && (cs.equals(")") || cs.equals("]") || cs.equals("}"))) {
                return false;
            }

            if ("(".equals(cs) || "[".equals(cs) || "{".equals(cs)) {
                stack.push(cs);
            } else {
                String stackTop = stack.peek();
                if (("(".equals(stackTop) && ")".equals(cs)) || ("[".equals(stackTop) && "]".equals(cs)) || ("{".equals(stackTop) && "}".equals(cs))) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Q20_ValidParentheses action = new Q20_ValidParentheses();
        String s = "[])";
        System.out.println(action.isValid(s));
    }
}
