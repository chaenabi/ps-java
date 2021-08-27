package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * All Elements in Two Binary Search Trees
 * https://leetcode.com/problems/all-elements-in-two-binary-search-trees/
 * 2021-08-18
 */
public class Leet1305 {
    List<Integer> result = new ArrayList<>();

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        inorder(root1);
        inorder(root2);
        Collections.sort(result);

        return result;
    }

    private void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        result.add(node.val);
        inorder(node.right);
    }
}
