package com.yhyr.Algorithm;

import com.yhyr.Model.TreeNode;


/**
 * Subject: 根据一个树的前序和中序遍历构造二叉树；假设没有重复元素
 *
 * 解题思路：采用递归的思想
 * Step 1，根据前序和中序确定根节点
 * Step 2，然后将前中序列分别拆分成两个部分
 * Step 3，拆分的部分分别作为根节点的左右孩子，继续执行Step1和Step2即可
 * 
 * @author yhyr
 * @since 2019/09/21 16:19
 */
public class Q105_BuildTreeByPreorderAndInorder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        return build(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart == preEnd && inStart == inEnd) {
            return new TreeNode(preorder[preStart]);
        }
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        // 寻找中序的划分范围
        int inIndex = inStart;
        while (inorder[inIndex] != preorder[preStart]) {
            inIndex++;
        }
        // 寻找前序的划分范围
        int preIndex = preStart;
        if (inIndex != inStart) {
            while (preorder[preIndex] != inorder[inIndex - 1]) {
                preIndex++;
            }
        }
        root.left = build(preorder, inorder, preStart + 1, preIndex, inStart, inIndex - 1);
        root.right = build(preorder, inorder, preIndex + 1, preEnd, inIndex + 1, inEnd);
        return root;
    }

    public static void main(String[] args) {
        Q105_BuildTreeByPreorderAndInorder action = new Q105_BuildTreeByPreorderAndInorder();
        // 常规用例
//         int[] preorder = {1, 2, 4, 5, 3, 6, 7};
//         int[] inorder = {4, 2, 5, 1, 6, 3, 7};
        // 特殊用例 1
        // int[] preorder = {1, 2};
        // int[] inorder = {2, 1};
        // 特殊用例 2
        // int[] preorder = {1, 2};
        // int[] inorder = {1, 2};
        // 特殊用例 3
        // int[] preorder = {1, 2, 3};
        // int[] inorder = {3, 2, 1};
        // 特殊用例 4
        // int[] preorder = {1, 2, 3};
        // int[] inorder = {1, 2, 3};
        // 特殊用例 5 暂不满足
        int[] preorder = {3, 2, 1, 4};
        int[] inorder = {1, 2, 3, 4};
        TreeNode root = action.buildTree(preorder, inorder);
    }
}
