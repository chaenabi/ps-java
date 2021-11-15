package programmers.codingTestPractice.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Prgs60058Test {

    Prgs60058 prgs60058 = new Prgs60058();

    @Test
    public void pubcases() {
        assertEquals(prgs60058.solution("(()())()"), "(()())()");
        assertEquals(prgs60058.solution(")("), "()");
        assertEquals(prgs60058.solution("()))((()"), "()(())()");
    }

}