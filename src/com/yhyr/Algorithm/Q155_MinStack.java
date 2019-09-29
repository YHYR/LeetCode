package com.yhyr.Algorithm;

import java.util.Stack;

/**
 * Subject: 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 * 
 * @author yhyr
 * @since 2019/09/29 20:42
 */
public class Q155_MinStack {
    Stack<Integer> elemStack;
    Stack<Integer> minStack;

    public Q155_MinStack() {
        elemStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        elemStack.add(x);
        if (minStack.isEmpty()) {
            minStack.add(x);
        } else {
            if (minStack.peek() >= x) {
                minStack.push(x);
            }
        }
    }

    public void pop() {
        if (elemStack.isEmpty()) {
            return;
        }
        int val = elemStack.pop();
        if (val == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        if (elemStack.isEmpty()) {
            return -1;
        }
        return elemStack.peek();
    }

    public int getMin() {
        if (minStack.isEmpty()) {
            return -1;
        }
        return minStack.peek();
    }

}
