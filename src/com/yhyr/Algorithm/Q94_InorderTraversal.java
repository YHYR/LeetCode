package com.yhyr.Algorithm;

import com.yhyr.Model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yhyr
 * @since 2019/09/19 22:28
 */
public class Q94_InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        if (root != null) {
            traversal(root, results);
        }
        return results;
    }

    private void traversal(TreeNode treeNode, List<Integer> results) {
        if (treeNode.left != null) {
            traversal(treeNode.left, results);
        }
        results.add(treeNode.val);
        if (treeNode.right != null) {
            traversal(treeNode.right, results);
        }
    }

    public static void main(String[] args) {
        Q94_InorderTraversal action = new Q94_InorderTraversal();
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
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        action.inorderTraversal(root).forEach(System.out::println);
    }
}
