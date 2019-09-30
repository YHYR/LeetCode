package com.yhyr.Algorithm;

import com.yhyr.Model.TreeNode;

import java.util.LinkedList;
import java.util.Objects;

/**
 * Subject: 二叉树的最近公共祖先
 * 
 * @author yhyr
 * @since 2019/09/30 9:38
 */
public class Q236_LowestCommonAncestor {
    /**
     * 时间复杂度过高
     * 
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q) {
            return root;
        }
        LinkedList<TreeNode> pList = new LinkedList<>();
        LinkedList<Boolean> pListUseFlag = new LinkedList<>();
        search(root, p, pList, pListUseFlag);
        LinkedList<TreeNode> qList = new LinkedList<>();
        LinkedList<Boolean> qListUseFlag = new LinkedList<>();
        search(root, q, qList, qListUseFlag);

        int pLength = pList.size() - 1;
        int qLength = qList.size() - 1;
        for (; pLength >= 0 && qLength >= 0; pLength--, qLength--) {
            if (!Objects.equals(pList.get(pLength).val, qList.get(qLength).val)) {
                return pList.get(pLength + 1);
            }
        }
        return pList.get(pLength + 1);
    }

    private boolean search(TreeNode node, TreeNode target, LinkedList<TreeNode> results, LinkedList<Boolean> useFlag) {
        while (node != null) {
            results.push(node);
            useFlag.push(Boolean.FALSE);
            if (Objects.equals(node.val, target.val)) {
                return true;
            } else {
                node = node.left;
            }
        }
        while (true) {
            useFlag.poll();
            useFlag.push(Boolean.TRUE);
            if (results.peek().right != null) {
                if (search(results.peek().right, target, results, useFlag)) {
                    return true;
                }
            } else {
                results.pop();
                useFlag.pop();
                while (useFlag.peek() == Boolean.TRUE) {
                    results.pop();
                    useFlag.pop();
                }
            }
        }
    }

    public static void main(String[] args) {
        Q236_LowestCommonAncestor action = new Q236_LowestCommonAncestor();
        TreeNode root = new TreeNode(-1);
        TreeNode node1 = new TreeNode(0);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(-2);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(9);
        TreeNode node7 = new TreeNode(3);
        TreeNode node8 = new TreeNode(5);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        node4.left = node7;
        node4.right = node8;
        TreeNode result = action.lowestCommonAncestor(root, new TreeNode(3), new TreeNode(8));
    }
}
