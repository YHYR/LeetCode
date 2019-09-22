package com.yhyr.Algorithm;

import com.yhyr.Model.TreeNode;

/**
 * Subject: 给定一个二叉树，找出其最小深度。
 *
 * 注意：最小深度是从根节点到最近叶子节点的最短路径上的节点数量。所以对于[1,2]的树，因为根的右孩子没叶子节点，所以返回左孩子的长度
 * 
 * @author yhyr
 * @since 2019/09/23 1:49
 */
public class Q111_BinaryTreeMinDepth {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = 1 + minDepth(root.left);
        int rightDepth = 1 + minDepth(root.right);
        if (root.left == null) {
            return rightDepth;
        }
        if (root.right == null) {
            return leftDepth;
        }
        return (leftDepth <= rightDepth) ? leftDepth : rightDepth;
    }
}
