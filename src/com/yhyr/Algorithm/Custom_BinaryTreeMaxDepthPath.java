package com.yhyr.Algorithm;

import com.yhyr.Model.TreeNode;

/**
 * Subject: 二叉树最长路径；是Q104的升级版
 * 
 * @author yhyr
 * @since 2019/09/23 23:00
 */
public class Custom_BinaryTreeMaxDepthPath {

    public String maxDepthPath(TreeNode root) {
        if (root == null) {
            return "";
        }
        String leftPath = String.valueOf(root.val) + maxDepthPath(root.left);
        String rightPath = String.valueOf(root.val) + maxDepthPath(root.right);
        return (leftPath.length() >= rightPath.length()) ? leftPath : rightPath;
    }

    public static void main(String[] args) {
        Custom_BinaryTreeMaxDepthPath action = new Custom_BinaryTreeMaxDepthPath();
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node4.left = node6;
        System.out.println(action.maxDepthPath(root));
    }
}
