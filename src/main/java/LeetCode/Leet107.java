package LeetCode;

import java.util.*;
import java.util.stream.Collectors;

public class Leet107 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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

        List<List<Integer>> result = new ArrayList<>();

        for (int i = answer.size() - 1; i >= 0; i--) {
            result.add(answer.get(i));
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20));
        new Leet107().levelOrderBottom(root).forEach(System.out::println);
    }

}
