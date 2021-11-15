package programmers.codingTestPractice.level2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Prgs72411Test {

    @Test
    public void pubcase1() {
        assertArrayEquals(new Prgs72411().solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[]{2, 3, 4}),
                new String[]{"AC", "ACDE", "BCFG", "CDE"});
    }

    @Test
    public void pubcase2() {
        assertArrayEquals(new Prgs72411().solution(new String[]{"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"}, new int[]{2, 3, 5}),
                new String[]{"ACD", "AD", "ADE", "CD", "XYZ"});
    }

    @Test
    public void pubcase3() {
        assertArrayEquals(new Prgs72411().solution(new String[]{"XYZ", "XWY", "WXA"}, new int[]{2, 3, 4}),
                new String[]{"WX", "XY"});
    }

}