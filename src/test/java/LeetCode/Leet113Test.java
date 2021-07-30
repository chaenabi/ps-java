package LeetCode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Leet113Test {

    private Leet113 leet113;

    @BeforeEach
    public void initialize() {
        leet113 = new Leet113();
    }

    @Test
    public void pubcase1() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11, new TreeNode(7), new TreeNode(2));
        root.right = new TreeNode(8);
        root.right.right = new TreeNode(13);
        root.right.left = new TreeNode(4, new TreeNode(5), new TreeNode(1));
        assertEquals(List.of(List.of(5, 4, 11, 2), List.of(5, 8, 4, 5)), leet113.pathSum(root,22));
    }

    @Test
    public void pubcase2() {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        assertEquals(Collections.emptyList(), leet113.pathSum(root,5));
    }

    @Test
    public void pubcase3() {
        TreeNode root = new TreeNode(1, new TreeNode(2), null);
        assertEquals(Collections.emptyList(), leet113.pathSum(root,0));
    }
}