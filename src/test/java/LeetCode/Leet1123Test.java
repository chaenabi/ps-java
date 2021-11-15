package LeetCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Leet1123Test {

    Leet1123 leet1123 = new Leet1123();

    @Test
    @DisplayName("[3,5,1,6,2,0,8,null,null,7,4]")
    public void pubcase1() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5, new TreeNode(6),
                new TreeNode(2, new TreeNode(7), new TreeNode(4)));
        root.right = new TreeNode(1, new TreeNode(0), new TreeNode(8));

        assertThat(new TreeNode(2, new TreeNode(7), new TreeNode(4))).isEqualTo(leet1123.lcaDeepestLeaves(root));
    }

    @Test
    @DisplayName("[1]")
    public void pubcase2() {
        TreeNode root = new TreeNode(1);
        assertEquals(new TreeNode(1), leet1123.lcaDeepestLeaves(root));
    }

    @Test
    @DisplayName("[0,1,3,null,2]")
    public void pubcase3() {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(2);
        assertEquals(new TreeNode(2), leet1123.lcaDeepestLeaves(root));
    }
}