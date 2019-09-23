package com.yhyr.Algorithm;

import com.yhyr.Model.TreeNode;

import java.util.Objects;

/**
 * Subject: 对称二叉树
 * @author yhyr
 * @since 2019/09/24 1:06
 */
public class Q101_SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        if (root.left == null || root.right == null) {
            return false;
        }
        return judge(root.left, root.right);
    }

    private boolean judge(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null) {
            return true;
        }
        if (leftNode == null || rightNode == null) {
            return false;
        }
        if (!Objects.equals(leftNode.val, rightNode.val)) {
            return false;
        }
        return judge(leftNode.left, rightNode.right) && judge(leftNode.right, rightNode.left);
    }

    public static void main(String[] args) {
        Q101_SymmetricTree action = new Q101_SymmetricTree();
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(3);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        System.out.println(action.isSymmetric(root));
    }
}
