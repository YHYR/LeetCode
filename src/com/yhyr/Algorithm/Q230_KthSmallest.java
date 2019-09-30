package com.yhyr.Algorithm;

import com.yhyr.Model.TreeNode;

import java.util.Stack;

/**
 * Subject: 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 * 
 * @author yhyr
 * @since 2019/09/30 14:20
 */
public class Q230_KthSmallest {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        int index = 1;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (index++ == k) {
                return stack.peek().val;
            }
            node = stack.pop();
            if (node.right == null) {
                if (!stack.isEmpty()) {
                    if (index++ == k) {
                        return stack.peek().val;
                    }
                    node = stack.pop();
                }
            }
            node = node.right;
        }
        return 0;
    }
}
