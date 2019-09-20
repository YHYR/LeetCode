package com.yhyr.Algorithm;

import com.yhyr.Model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Subject：二叉树前序遍历
 * 
 * @author yhyr
 * @since 2019/09/19 22:57
 */
public class Q144_PreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        if (root != null) {
            traversal(root, results);
        }
        return results;
    }

    private void traversal(TreeNode treeNode, List<Integer> results) {
        results.add(treeNode.val);
        if (treeNode.left != null) {
            traversal(treeNode.left, results);
        }
        if (treeNode.right != null) {
            traversal(treeNode.right, results);
        }
    }

    /**
     * 非递归解法
     * 
     * @param root
     * @return
     */
    private List<Integer> preorderTraversalNonRecursive(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                results.add(curr.val);
                curr = curr.left;
            }
            curr = stack.pop().right;
        }
        return results;
    }

    private List<Integer> preorderTraversalNonRecursive2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        LinkedList<Integer> results = new LinkedList<>();
        if (root == null) {
            return results;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            results.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return results;
    }

    public static void main(String[] args) {
        Q144_PreorderTraversal action = new Q144_PreorderTraversal();
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
        action.preorderTraversal(root).forEach(System.out::println);
        System.out.println("====");
        action.preorderTraversalNonRecursive(root).forEach(System.out::println);
        System.out.println("====");
        action.preorderTraversalNonRecursive2(root).forEach(System.out::println);
    }
}
