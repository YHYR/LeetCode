package com.yhyr.Algorithm;

import com.sun.deploy.util.StringUtils;
import com.yhyr.Model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Subject：二叉树后序遍历
 * 
 * @author yhyr
 * @since 2019/09/19 23:00
 */
public class Q145_PostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
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
        if (treeNode.right != null) {
            traversal(treeNode.right, results);
        }
        results.add(treeNode.val);
    }

    /**
     * 非递归解法
     *
     * ---------1
     * -------2--3
     * ------4-5-6-7
     * 上述树的后序遍历结果为：4-5-2-6-7-3-1；从后往前看可以看做是：先遍历根在遍历右节点，后遍历左节点
     *
     * 所以按照先根后右再左的顺序遍历，并将值按照栈的方式先入后出的存入List即可
     * @param root
     * @return
     */
    public List<Integer> postorderTraversalNonRecursive(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        LinkedList<Integer> results = new LinkedList<>();
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                results.addFirst(root.val);
                root = root.right;
            }
            root = stack.pop().left;
        }
        return results;
    }

    /**
     * LeetCode官方解法
     *
     * @param root
     * @return
     */

    public List<Integer> postorderTraversalNonRecursive2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        LinkedList<Integer> results = new LinkedList<>();
        if (root == null) {
            return results;
        }
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            results.addFirst(node.val);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        return results;
    }


    public static void main(String[] args) {
        Q145_PostorderTraversal action = new Q145_PostorderTraversal();
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
        action.postorderTraversal(root).forEach(System.out::println);
        System.out.println("====");
        action.postorderTraversalNonRecursive(root).forEach(System.out::println);
        System.out.println("====");
        action.postorderTraversalNonRecursive2(root).forEach(System.out::println);
    }
}
