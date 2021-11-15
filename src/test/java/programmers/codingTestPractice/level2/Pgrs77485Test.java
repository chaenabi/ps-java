package programmers.codingTestPractice.level2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Pgrs77485Test {

    private Prgs77485 prgs77485 = new Prgs77485();

    @Test
    public void pubcase1() {
        assertArrayEquals(new int[]{8, 10, 25},
                prgs77485.solution(6, 6,
                        new int[][]{{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}}));
    }
    @Test
    public void pubcase2() {
        assertEquals(new int[]{1, 1, 5, 3},
                prgs77485.solution(6, 6,
                        new int[][]{{1, 1, 2, 2}, {1, 2, 2, 3}, {2, 1, 3, 2}, {2, 2, 3, 3}}));
    }
    @Test
    public void pubcase3() {
        assertEquals(new int[]{1},
                prgs77485.solution(6, 6,
                        new int[][]{{1, 1, 100, 97}}));
    }


}
