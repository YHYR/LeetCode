package com.yhyr.Algorithm;

import com.yhyr.Model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
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
}
