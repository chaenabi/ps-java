package LeetCode;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Leet797Test {

    Leet797 leet797 = new Leet797();

    @Test
    public void pubcase1() {
        assertEquals(List.of(List.of(0, 1, 3), List.of(0, 2, 3)),
                    leet797.allPathsSourceTarget(new int[][]{{1, 2}, {3}, {3}, {}}));
    }

    @Test
    public void pubcase2() {
        assertEquals(List.of(List.of(0, 4), List.of(0, 3, 4), List.of(0, 1, 3, 4), List.of(0, 1, 2, 3, 4), List.of(0, 1, 4)),
                    leet797.allPathsSourceTarget(new int[][]{{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}}));
    }

    @Test
    public void pubcase3() {
        assertEquals(List.of(List.of(0, 1)),
                    leet797.allPathsSourceTarget(new int[][]{{1}, {}}));
    }

    @Test
    public void pubcase4() {
        assertEquals(List.of(List.of(0, 1, 2, 3), List.of(0, 2, 3), List.of(0, 3)),
                leet797.allPathsSourceTarget(new int[][]{{1, 2, 3}, {2}, {3}, {}}));
    }

    @Test
    public void pubcase5() {
        assertEquals(List.of(List.of(0, 1, 2, 3), List.of(0, 3)),
                leet797.allPathsSourceTarget(new int[][]{{1, 3}, {2}, {3}, {}}));
    }
}