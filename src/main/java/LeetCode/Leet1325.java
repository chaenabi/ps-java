package LeetCode;

/**
 * Delete Leaves With a Given Value
 * https://leetcode.com/problems/delete-leaves-with-a-given-value/
 */
public class Leet1325 {

    TreeNode newNode = new TreeNode();

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        deleteNodes(root, target);
        getAliveNodes(root);
        return newNode;
    }


    private void deleteNodes(TreeNode node, int target) {
        if (node == null) return;
        if (node.left != null) deleteNodes(node.left, target);
        if (node.val == target) node.val = Integer.MIN_VALUE;
        if (node.right != null) deleteNodes(node.right, target);
    }

    private void getAliveNodes(TreeNode node) {
        if (node == null) return;
        if (node.left != null) {
            if (node.val == Integer.MIN_VALUE) newNode.left = new TreeNode();
            else newNode.left = new TreeNode(node.val);
            getAliveNodes(node.left);

        }
        if (node.right != null) {
            if (node.val == Integer.MIN_VALUE) newNode.right = new TreeNode();
            else newNode.right = new TreeNode(node.val);
            getAliveNodes(node.right);
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        node.left.left = new TreeNode(2);
        node.right.left = new TreeNode(2);
        node.right.right = new TreeNode(4);

        TreeNode answer = new Leet1325().removeLeafNodes(new TreeNode(1, null, new TreeNode(3, null, new TreeNode(4))), 2);
        printInorder(answer);
        System.out.println();
        printInorder(node);
    }

    private static void printInorder(TreeNode node) {
        if (node == null) return;
        System.out.print(node.val + " ");
        printInorder(node.left);
        printInorder(node.right);
    }

}
