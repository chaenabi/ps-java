package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static java.util.stream.Collectors.toList;
import java.util.stream.Stream;

/**
 * https://leetcode.com/problems/all-possible-full-binary-trees/
 * 2021-07-23 Fri
 */

public class Leet894 {
    // n must be odd

    public List<TreeNode> allPossibleFBT(int n) {
        if (n % 2 == 0) return Collections.emptyList();
        if (n == 1) return Stream.generate(TreeNode::new).limit(1).collect(toList());
        List<TreeNode> list = new ArrayList<>();

        for (int i = 1; i < n; i += 2) {
            for (TreeNode l : allPossibleFBT(i))
                for (TreeNode r : allPossibleFBT(n - i - 1)) {
                    TreeNode root = new TreeNode(0);
                    root.left = l;
                    root.right = r;
                    list.add(root);
                }
        }

        return list;
    }

    public static void main(String[] args) {
        new Leet894().allPossibleFBT(7).forEach(e -> {

        });
    }
}
