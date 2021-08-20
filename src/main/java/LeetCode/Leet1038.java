package LeetCode;

/**
 * Binary Search Tree to Greater Sum Tree
 * https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
 * 2021-08-11
 */
public class Leet1038 {
    int nodeSum = 0;
    public TreeNode bstToGst(TreeNode root) {
        if (root == null) return null;

        bstToGst(root.right);
        root.val += nodeSum;
        nodeSum = root.val;
        bstToGst(root.left);
        return root;
    }
}
