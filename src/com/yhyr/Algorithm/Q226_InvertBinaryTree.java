package com.yhyr.Algorithm;

import com.yhyr.Model.TreeNode;

/**
 * Subject: 反转二叉树
 * 
 * @author yhyr
 * @since 2019/09/23 23:34
 */
public class Q226_InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null || root.left == null && root.right == null) {
            return root;
        }
        TreeNode tmp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(tmp);
        return root;
    }

    public static void main(String[] args) {
        Q226_InvertBinaryTree action = new Q226_InvertBinaryTree();
        TreeNode root = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;

        TreeNode invertNode = action.invertTree(root);
    }
}
