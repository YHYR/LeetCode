package com.yhyr.Algorithm;

import com.yhyr.Model.TreeNode;

import java.util.*;

/**
 * @author yhyr
 * @since 2019/09/29 23:12
 */
public class Q235_LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pList = new ArrayList<>();
        searchNode(root, p, pList);
        List<TreeNode> qList = new ArrayList<>();
        searchNode(root, q, qList);
        int index = 0;
        for (; index < pList.size() && index < qList.size(); index++) {
            if (Objects.equals(pList.get(index).val, qList.get(index).val)) {
                continue;
            }
            return pList.get(index - 1);
        }
        return pList.get(index - 1);
    }

    private void searchNode(TreeNode root, TreeNode target, List<TreeNode> list) {
        list.add(root);
        if (Objects.equals(root.val, target.val)) {
            return;
        } else if (root.val > target.val) {
            searchNode(root.left, target, list);
        } else {
            searchNode(root.right, target, list);
        }
    }

    public static void main(String[] args) {
        Q235_LowestCommonAncestor action = new Q235_LowestCommonAncestor();
        TreeNode root = new TreeNode(6);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(0);
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
        TreeNode result = action.lowestCommonAncestor(root, new TreeNode(2), new TreeNode(4));
    }
}
