package com.yhyr.Algorithm;

import com.yhyr.Model.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Subject: 二叉树层次遍历
 *
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 * @author yhyr
 * @since 2019/09/20 15:25
 */
public class Q102_LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        if (root == null) {
            return results;
        }
        traversal(Collections.singletonList(root), results);
        return results;
    }

    private void traversal(List<TreeNode> treeNodes, List<List<Integer>> results) {
        List<Integer> result = new ArrayList<>();
        List<TreeNode> nodeList = new ArrayList<>();
        for (TreeNode node :treeNodes) {
            result.add(node.val);
            if (node.left != null) {
                nodeList.add(node.left);
            }
            if (node.right != null) {
                nodeList.add(node.right);
            }
        }
        results.add(result);
        if (nodeList.size() > 0) {
            traversal(nodeList, results);
        }
    }

    public static void main(String[] args) {
        Q102_LevelOrder action = new Q102_LevelOrder();
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
        action.levelOrder(root).forEach(result -> System.out.println(result.toString()));
    }
}
