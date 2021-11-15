package programmers.codingTestPractice.level2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Pgrs17677Test {

    Pgrs17677 prgs17677 = new Pgrs17677();

    @Test
    public void pubcase1() {
        assertEquals(16384, prgs17677.solution("FRANCE","french"));
    }

    @Test
    public void pubcase2() {
        assertEquals(65536, prgs17677.solution("handshake","shake hands"));
    }

    @Test
    public void pubcase3() {
        assertEquals(43690, prgs17677.solution("aa1+aa2","AAAA12"));
    }

    @Test
    public void pubcase4() {
        assertEquals(65536, prgs17677.solution("E=M*C^2","e=m*c^2"));
    }

    @Test
    public void hidcase1() {
        assertEquals(43690, prgs17677.solution("aaaa+bbb", "aaa+bbbb"));
    }
    // "aaaa+bbb", "aaa+bbbb"

    // aa aa aa bb bb (A) (aaaa+bbb를 두글자씩 끊어서 만듬)
    // aa aa bb bb bb (B) (aaa+bbbb를 두글자씩 끊어서 만듬)

    // intersect (교집합)
    // aa aa bb bb (4개)

    // union (합집합)
    // aa aa aa bb bb bb (6개)

    // 4/6 -> 43690
}