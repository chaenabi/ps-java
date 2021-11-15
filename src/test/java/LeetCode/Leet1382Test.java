package LeetCode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Leet1382Test {

    Leet1382 leet1382 = new Leet1382();

    @Test
    public void pubcase1() {

        TreeNode node = new TreeNode(1, null, new TreeNode(2));
        node.right.right = new TreeNode(3, null, new TreeNode(4));

    }

}