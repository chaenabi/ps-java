package LeetCode;

/**
 *  https://leetcode.com/problems/recover-binary-search-tree/
 *  2021-07-21 Wed
 */

public class Leet99 {
    TreeNode first, second;
    TreeNode prev = new TreeNode(Integer.MIN_VALUE);

    private static TreeNode initCase() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3, null, new TreeNode(2));

        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(4, new TreeNode(2), null);

        return (root);
    }

    public static void main(String[] args) {
        new Leet99().recoverTree(initCase());
    }

    public void recoverTree(TreeNode root) {
        printInorder(root);
        preorder(root);

        int temp = first.val;
        first.val = second.val;
        second.val = temp;

        System.out.println();
        printInorder(root);
    }

    private void preorder(TreeNode node) {
        if (node == null) return;
        if (first == null && prev.val > node.val) first = prev;
        if (first != null && prev.val > node.val) second = node;
        prev = node;
        preorder(node.left);
        preorder(node.right);
    }

    private void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);

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

    private void postorder(TreeNode node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        if (first == null && prev.val > node.val) first = prev;
        if (first != null && prev.val > node.val) second = node;
        prev = node;
    }
}
