package codewars;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindOdd {
    public static int findIt(int[] a) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int j : a) {
            map.put(j, map.getOrDefault(j, 0) + 1);
        }
        return map.entrySet()
                .stream()
                .filter(entry -> entry.getValue() % 2 != 0)
                .map(Map.Entry::getKey)
                .findFirst()
                .get();
    }
}

class FindOddTest {
    private static void doTest(int[] input, int expected) {
        String message = String.format("for array = %s\n", Arrays.toString(input));
        int actual = FindOdd.findIt(input);
        assertEquals(expected, actual, message);
    }

    @Test
    public void sampleTests() {
        doTest(new int[]{20, 1, -1, 2, -2, 3, 3, 5, 5, 1, 2, 4, 20, 4, -1, -2, 5}, 5);
        doTest(new int[]{1, 1, 2, -2, 5, 2, 4, 4, -1, -2, 5}, -1);
        doTest(new int[]{20, 1, 1, 2, 2, 3, 3, 5, 5, 4, 20, 4, 5}, 5);
        doTest(new int[]{10}, 10);
        doTest(new int[]{1, 1, 1, 1, 1, 1, 10, 1, 1, 1, 1}, 10);
        doTest(new int[]{5, 4, 3, 2, 1, 5, 4, 3, 2, 10, 10}, 1);
    }
}