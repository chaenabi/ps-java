package LeetCode;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import static java.lang.Math.abs;

/**
 * Matrix Cells in Distance Order
 * https://leetcode.com/problems/matrix-cells-in-distance-order/
 */
public class Leet1030 {

    // 1x2 = 2, rcenter = 0, cCenter = 0 (0, 1)
    // (0, 0) (0, 1)
    // (1, 0) (1, 1)

    // 2x2 = 4, rcenter = 0, cCenter = 1 (0, 1, 1, 2)
    // (0, 0) (0, 1) (0, 2) (0, 3)
    // (1, 0) (1, 1) (1, 2) (1, 3)
    // (2, 0) (2, 1) (2, 2) (2, 3)
    // (3, 0) (3, 1) (3, 2) (3, 3)

    // 2*3 = 6, rcenter = 1, cCenter = 2 (0, 1, 1, 2, 2, 3)
    // (0, 0) (0, 1) (0, 2) (0, 3) (0, 4) (0, 5)
    // (1, 0) (1, 1) (1, 2) (1, 3) (1, 4) (1, 5)
    // (2, 0) (2, 1) (2, 2) (2, 3) (2, 4) (2, 5)
    // (3, 0) (3, 1) (3, 2) (3, 3) (3, 4) (3, 5)
    // (4, 0) (4, 1) (4, 2) (4, 3) (4, 4) (4, 5)
    // (5, 0) (5, 1) (5, 2) (5, 3) (5, 4) (5, 5)

    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        int[][] arr = new int[rows * cols][2];
        int idx = 0;
        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < cols; x++) {
                arr[idx++] = new int[] { y, x };
            }
        }
        Arrays.sort(arr, (a, b) -> abs(a[0] - rCenter) + abs(a[1] - cCenter) - abs(b[0] - rCenter) - abs(b[1] - cCenter));
        return arr;
    }

    public static void main(String[] args) {
        AtomicInteger ints = new AtomicInteger();
        ints.incrementAndGet();
        Arrays.stream(new Leet1030().allCellsDistOrder(1, 2, 0, 0)).flatMapToInt(array -> Arrays.stream(array).flatMap(IntStream::of)).forEach(e -> {
            if (ints.incrementAndGet() % 2 == 0) System.out.print(e + " ");
            else System.out.print(e + ", ");
        });
        System.out.println();
        Arrays.stream(new Leet1030().allCellsDistOrder(2, 2, 0, 1)).flatMapToInt(array -> Arrays.stream(array).flatMap(IntStream::of)).forEach(e -> {
            if (ints.incrementAndGet() % 2 == 0) System.out.print(e + " ");
            else System.out.print(e + ", ");
        });
        System.out.println();
        Arrays.stream(new Leet1030().allCellsDistOrder(2, 3, 1, 2)).flatMapToInt(array -> Arrays.stream(array).flatMap(IntStream::of)).forEach(e -> {
            if (ints.incrementAndGet() % 2 == 0) System.out.print(e + " ");
            else System.out.print(e + ", ");
        });
    }
}
