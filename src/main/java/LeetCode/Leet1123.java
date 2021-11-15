package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Lowest Common Ancestor of Deepest Leaves
 * https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/
 */
public class Leet1123 {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if (root == null) return null;
        return bfs(root);
    }

    public TreeNode bfs(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode leaf = null;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null && node.right != null) leaf = node;
            if (node.left == null && node.right == null) leaf = node;
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        return leaf;
    }
}
