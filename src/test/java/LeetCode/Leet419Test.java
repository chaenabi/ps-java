package LeetCode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Leet419Test {

    Leet419 leet419 = new Leet419();

    @Test
    public void pubcase1() {
        assertEquals(2, leet419.countBattleships(new char[][]{{'X','.','.','X'},{'.','.','.','X'},{'.','.','.','X'}}));
    }

    @Test
    public void pubcase2() {
        assertEquals(0, leet419.countBattleships(new char[][]{{'.'}}));
    }

}