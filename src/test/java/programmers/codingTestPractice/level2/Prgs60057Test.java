package programmers.codingTestPractice.level2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Prgs60057Test {

    @Test
    public void pubcase() {
        Prgs60057 prgs60057 = new Prgs60057();
        assertEquals(7, prgs60057.solution("aabbaccc"));
        assertEquals(9, prgs60057.solution("ababcdcdababcdcd"));
        assertEquals(8, prgs60057.solution("abcabcdede"));
        assertEquals(14, prgs60057.solution("abcabcabcabcdededededede"));
        assertEquals(17, prgs60057.solution("xababcdcdababcdcd"));
    }
}