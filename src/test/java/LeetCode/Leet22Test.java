package LeetCode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Leet22Test {
    private Leet22 leet22;

    @BeforeEach
    public void initialize() {
        leet22 = new Leet22();
    }

    @org.junit.jupiter.api.Test
    public void pubcase1() {
        assertEquals(List.of("((()))","(()())","(())()","()(())","()()()"), leet22.generateParenthesis( 3));
    }

    @Test
    public void pubcase2() {
        assertEquals(List.of("()"), leet22.generateParenthesis( 1));
    }
}
