package LeetCode;

import java.util.*;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 * 2021-07-20 Tue
 */

public class Leet102 {
    static TreeNode initCase() {
        TreeNode root = new TreeNode(3);
                 root.left = new TreeNode(9, null, null);
                 root.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));

        TreeNode root2 = new TreeNode(1);

        TreeNode root3 = new TreeNode();

        TreeNode root4 = new TreeNode(1);
                 root4.left = new TreeNode(2, new TreeNode(4), null);
                 root4.right = new TreeNode(3, null, new TreeNode(5));

        return (root);
    }

    public static void main(String[] args) {
        TreeNode root;
        List<List<Integer>> result = new Leet102().levelOrder(root = initCase());
        System.out.println(result);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> answer = new ArrayList<>();
        queue.offer(root);

        if (root == null) return answer;

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if (current != null) {
                    list.add(current.val);
                    if (current.left != null) queue.offer(current.left);
                    if (current.right != null) queue.offer(current.right);
                }
            }
            answer.add(list);
        }

        return answer;
    }
}


