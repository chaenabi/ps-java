package LeetCode;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Leet1038Test {
    private Leet1038 leet1038;

    @BeforeEach
    public void initialize() {
        leet1038 = new Leet1038();
    }

    @Test
    public void pubcase1() {
        TreeNode node = new TreeNode(4);
        node.left = new TreeNode(1);
        node.right = new TreeNode(6);
        node.left.left = new TreeNode(0);
        node.left.right = new TreeNode(2);
        node.right.left = new TreeNode(5);
        node.right.right = new TreeNode(7);


        assertThat(leet1038.bstToGst(node)).isEqualTo(node);
    }
}