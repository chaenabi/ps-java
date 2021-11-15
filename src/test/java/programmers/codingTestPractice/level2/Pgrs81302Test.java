package programmers.codingTestPractice.level2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Pgrs81302Test {

    Pgrs81302 pgrs81302 = new Pgrs81302();

    /**
     *  거리두기 만족하는 조합
     *  P00  00P   P0   0P
     *  00P  P00   00   00
     *             0P   P0
     *
     *  PX   XP   PXP   P
     *  XP   PX         X
     *                  P
     */

    /**
     * 거리두기 불만족 조합
     *
     * P0P  P
     *      0
     *      P
     *
     * P0   0P   PX   XP
     * XP   PX   0P   P0
     */
    @Test
    public void pubcase1() {

        Arrays.stream(pgrs81302.solution(new String[][]{
                 //1
                {"POOOP",
                "OXXOX",
                "OPXPX",
                "OOXOX",
                "POXXP"},
                // 0
                {"POOPX",
                 "OXPXP",
                 "PXXXO",
                 "OXXXO",
                 "OOOPP"},
                // 1
                {"PXOPX",
                 "OXOXP",
                 "OXPOX",
                 "OXXOP",
                 "PXPOX"},
                // 1
                {"OOOXX",
                 "XOOOX",
                 "OOOXX",
                 "OXOOX",
                 "OOOOO"},
                // 1
                {"PXPXP",
                 "XPXPX",
                 "PXPXP",
                 "XPXPX",
                 "PXPXP"}})).forEach(i -> System.out.print(i + " "));
        System.out.println();
        assertArrayEquals(new int[]{1,0,1,1,1},
                pgrs81302.solution(      // 1
                        new String[][]{{"POOOP",
                                        "OXXOX",
                                        "OPXPX",
                                        "OOXOX",
                                        "POXXP"},
                                          // 0
                                        {"POOPX",
                                         "OXPXP",
                                         "PXXXO",
                                         "OXXXO",
                                         "OOOPP"},
                                         // 1
                                        {"PXOPX",
                                         "OXOXP",
                                         "OXPOX",
                                         "OXXOP",
                                         "PXPOX"},
                                          // 1
                                        {"OOOXX",
                                         "XOOOX",
                                         "OOOXX",
                                         "OXOOX",
                                         "OOOOO"},
                                          // 1
                                        {"PXPXP",
                                         "XPXPX",
                                         "PXPXP",
                                         "XPXPX",
                                         "PXPXP"}}));
    }
}