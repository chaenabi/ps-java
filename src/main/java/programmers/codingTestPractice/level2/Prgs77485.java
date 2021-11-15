package programmers.codingTestPractice.level2;

import java.util.ArrayList;
import java.util.List;

/**
 * 행렬 테두리 회전하기
 * https://programmers.co.kr/learn/courses/30/lessons/77485?language=java
 * 2021-08-25
 */
public class Prgs77485 {

    int[][] array;

    public int[] solution(int rows, int columns, int[][] queries) {

        array = initcase(rows + 1, columns + 1);

        printQueries(array);

        for (int x = 0; x < queries.length; x++) {
            rotate(queries[x][0], queries[x][1], queries[x][2], queries[x][3]);
        }

        printQueries(array);


        int[] answer = {};
        return answer;
    }

    private void rotate(int x1, int y1, int x2, int y2) {
        List<Integer> list = new ArrayList<>();
        int copy, overwrite, temp;
        // ?
        while (y1 < y2) {
            list.add(array[x1][y1]);
            overwrite = array[x1][y1 + 1];
            copy = array[x1][y1];
            array[x1][++y1] = copy;
        }

    }

    private int[][] initcase(int rows, int columns) {
        int[][] initialArray = new int[rows][columns];
        int inc = 0;
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                initialArray[i][j] = ++inc;
            }
        }
        return initialArray;
    }

    private void printQueries(int[][] queries) {
        for(int[] query : queries) {
            for (int element : query) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
