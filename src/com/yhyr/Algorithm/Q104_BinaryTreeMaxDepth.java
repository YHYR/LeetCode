package com.yhyr.Algorithm;

import com.yhyr.Model.TreeNode;

/**
 * Subject: 给定一个二叉树，找出其最大深度
 * @author yhyr
 * @since 2019/09/23 1:03
 */
public class Q104_BinaryTreeMaxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = 0;
        int rightDepth = 0;
        if (root.left != null) {
            leftDepth = 1 + maxDepth(root.left);
        }
        if (root.right != null) {
            rightDepth = 1 + maxDepth(root.right);
        }
        return (leftDepth >= rightDepth) ? leftDepth : rightDepth;
    }

    public static void main(String[] args) {
        Q104_BinaryTreeMaxDepth action = new Q104_BinaryTreeMaxDepth();
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node2.left = node4;
        node2.right = node5;
        node5.left = node6;
        System.out.println(action.maxDepth(root));
    }
}
