package LeetCode;

/**
 *  https://leetcode.com/problems/recover-binary-search-tree/
 *  2021-07-21 Wed
 */

public class Leet99 {


    private static TreeNode initCase() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3, null, new TreeNode(2));

        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(4, new TreeNode(2), null);

        return (root);
    }

    TreeNode first, second;
    TreeNode prev = new TreeNode(Integer.MIN_VALUE);

    public static void main(String[] args) {
        new Leet99().recoverTree(initCase());
    }

    public void recoverTree(TreeNode root) {
        //printInorder(root);
        inorder(root);

        int temp = first.val;
        first.val = second.val;
        second.val = temp;

        System.out.println();
        //printInorder(root);
    }

    private void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        // 1 3 2 4 6 5 7 // 1 2 3 4 5 6 7 8
        if (first == null && prev.val > node.val) first = prev;
        if (first != null && prev.val > node.val) second = node;
        prev = node;

        inorder(node.right);
    }

    private void printInorder(TreeNode node) {
        if (node == null) return;
        printInorder(node.left);
        System.out.print(node.val);
        printInorder(node.right);
    }
}
