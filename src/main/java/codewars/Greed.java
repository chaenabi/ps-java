package codewars;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

// https://www.codewars.com/kata/5270d0d18625160ada0000e4/train/java
public class Greed {
    public static int greedy(int[] dice) {
        int[] counts = new int[6];
        int[] scores = new int[]{1000, 200, 300, 400, 500, 600, 100, 50};
        int sum = 0;

        for (int d : dice) {
            ++counts[d - 1];
        }
        for (int i = 0; i < 6; i++) {
            sum += (counts[i] / 3) * scores[i];
            counts[i] %= 3;
        }

        sum += counts[0] * scores[6];
        sum += counts[4] * scores[7];

        return sum;
    }
}


class GreedTest {
    @Test
    public void testExample() {
        assertEquals("Score for [5,1,3,4,1] must be 250:", 250, Greed.greedy(new int[]{5, 1, 3, 4, 1}));
        assertEquals("Score for [1,1,1,3,1] must be 1100:", 1100, Greed.greedy(new int[]{1, 1, 1, 3, 1}));
        assertEquals("Score for [2,4,4,5,4] must be 450:", 450, Greed.greedy(new int[]{2, 4, 4, 5, 4}));
        assertEquals("Score for [6,6,6,6,6] must be 450:", 600, Greed.greedy(new int[]{6, 6, 6, 6, 6}));
    }
}