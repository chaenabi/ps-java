package LeetCode;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Find Elements in a Contaminated Binary Tree
 * https://leetcode.com/problems/find-elements-in-a-contaminated-binary-tree/
 * 2021-08-19
 */
public class Leet1261 {

    TreeNode node;
    Set<Integer> set;

    public Leet1261(TreeNode root) {
        set = new LinkedHashSet<>();
        recoverTree(root, 0);
    }

    private void recoverTree(TreeNode node, int val) {
        if (node == null) {
            return;
        }
        node.val = val;
        set.add(val);
        if (node.left != null) recoverTree(node.left, 2 * val + 1);
        if (node.right != null) recoverTree(node.right, 2 * val + 2);
    }

    public boolean find(int target) {
        return set.contains(target);
    }
}
