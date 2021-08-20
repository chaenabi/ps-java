package LeetCode;

import java.util.*;

/**
 * Path Sum II
 * https://leetcode.com/problems/path-sum-ii/
 * created: 2021-07-30
 */
public class Leet113 {
    private List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) return Collections.emptyList();
        result = new ArrayList<>();
        preorder(root, targetSum, new ArrayList<>());
        return result;
    }

    private void preorder(TreeNode node, int targetSum, List<Integer> list) {
        list.add(node.val);

        if (node.left == null && node.right == null && node.val == targetSum) {
            result.add(list);
            return;
        }

        if (node.left != null) preorder(node.left, targetSum - node.val, new ArrayList<>(list));
        if (node.right != null) preorder(node.right, targetSum - node.val, new ArrayList<>(list));
    }
}