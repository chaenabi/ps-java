package LeetCode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Leet26Test {

    @Test
    void testExample1() {
        Leet26 solution = new Leet26();
        int[] nums = {1, 1, 2};
        int k = solution.removeDuplicates(nums);

        assertEquals(2, k);
        assertArrayEquals(new int[]{1, 2}, java.util.Arrays.copyOf(nums, k));
    }

    @Test
    void testExample2() {
        Leet26 solution = new Leet26();
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int k = solution.removeDuplicates(nums);

        assertEquals(5, k);
        assertArrayEquals(new int[]{0, 1, 2, 3, 4}, java.util.Arrays.copyOf(nums, k));
    }

    @Test
    void testSingleElement() {
        Leet26 solution = new Leet26();
        int[] nums = {1};
        int k = solution.removeDuplicates(nums);

        assertEquals(1, k);
        assertArrayEquals(new int[]{1}, java.util.Arrays.copyOf(nums, k));
    }

    @Test
    void testNoD uplicates() {
        Leet26 solution = new Leet26();
        int[] nums = {1, 2, 3, 4, 5};
        int k = solution.removeDuplicates(nums);

        assertEquals(5, k);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, java.util.Arrays.copyOf(nums, k));
    }

    @Test
    void testAllSame() {
        Leet26 solution = new Leet26();
        int[] nums = {1, 1, 1, 1, 1};
        int k = solution.removeDuplicates(nums);

        assertEquals(1, k);
        assertEquals(1, nums[0]);
    }
}