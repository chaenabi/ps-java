package LeetCode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Leet1261Test {

    @Test
    public void pubcase1() {
        TreeNode treeNode = new TreeNode(-1, null, new TreeNode(-1));
        Leet1261 leet1261 = new Leet1261(treeNode);
        assertFalse(leet1261.find(1));
        assertTrue(leet1261.find(2));
    }

    @Test
    public void pubcase2() {
        TreeNode treeNode = new TreeNode(-1);
        treeNode.left = new TreeNode(-1, new TreeNode(-1), new TreeNode(-1));
        treeNode.right = new TreeNode(-1);

        Leet1261 leet1261 = new Leet1261(treeNode);
        assertTrue(leet1261.find(1));
        assertTrue(leet1261.find(3));
        assertFalse(leet1261.find(5));
    }
}