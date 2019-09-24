package com.yhyr.Algorithm;

import com.yhyr.Model.TreeNode;

import java.util.Stack;

/**
 * Subject: 给定一个二叉树，原地将它展开为链表
 *
 * Eg：1-2-5-3-4-null-6 => 1-2-3-4-5-6
 * @author yhyr
 * @since 2019/09/25 1:41
 */
public class Q114_FlattenBinaryTree {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                node.right = node.left;
                stack.push(node.left);
                node.left = null;
            }
            if (node.right == null && !stack.isEmpty()) {
                node.right = stack.peek();
            }
        }
    }

    public static void main(String[] args) {
        Q114_FlattenBinaryTree action = new Q114_FlattenBinaryTree();
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(6);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.right = node5;
        action.flatten(root);
    }
}
