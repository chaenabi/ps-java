package LeetCode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Leet103Test {
    private Leet103 leet103;

    @BeforeEach
    public void init() {
        leet103 = new Leet103();
    }

    @Test
    public void pubcase1() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        assertEquals(List.of(List.of(3),List.of(20, 9), List.of(15, 7)), leet103.zigzagLevelOrder(root));
    }

    @Test
    public void pubcase2() {
        TreeNode root = new TreeNode(1);
        assertEquals(List.of(List.of(1)), leet103.zigzagLevelOrder(root));
    }

    @Test
    public void pubcase3() {
        assertEquals(Collections.emptyList(), leet103.zigzagLevelOrder(null));
    }

    @Test
    public void hidcase1() {
        TreeNode root = new TreeNode(1, new TreeNode(2), null);
        assertEquals(List.of(List.of(1), List.of(2)), leet103.zigzagLevelOrder(root));
    }

    @Test
    public void hidcase2() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2, new TreeNode(4), new TreeNode(5));
        root.right = new TreeNode(3);
        assertEquals(List.of(List.of(1), List.of(3, 2), List.of(4, 5)), leet103.zigzagLevelOrder(root));
    }

    @Test
    public void hidcase3() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2, new TreeNode(4), null);
        root.right = new TreeNode(3, new TreeNode(5), null);
        assertEquals(List.of(List.of(1), List.of(3, 2), List.of(4, 5)), leet103.zigzagLevelOrder(root));
    }
}