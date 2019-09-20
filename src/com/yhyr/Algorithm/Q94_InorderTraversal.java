package com.yhyr.Algorithm;

import com.yhyr.Model.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Subject：二叉树中序遍历
 * 
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

    /**
     * 非递归解法
     *
     * 首先遍历左孩子，用current指针代表当前所遍历的位置，通过current是否为空来作为下次循环时是否进行左孩子的遍历判断
     * 
     * @param root
     * @return
     */
    private List<Integer> inorderTraversalNonRecursive(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            results.add(curr.val);
            curr = curr.right;
        }
        return results;
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
        System.out.println("====");
        action.inorderTraversalNonRecursive(root).forEach(System.out::println);
    }
}
