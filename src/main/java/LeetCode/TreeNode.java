package LeetCode;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Test {

    public static void main(String[] args) {

        TreeNode tr = new TreeNode(1);
        tr.left = new TreeNode(2);
        tr.right = new TreeNode(3);

    }

}

