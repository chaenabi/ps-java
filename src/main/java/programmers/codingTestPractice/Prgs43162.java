package programmers.codingTestPractice;

import java.util.*;

/**
 * 네트워크
 * https://programmers.co.kr/learn/courses/30/lessons/43162?language=java
 */
public class Prgs43162 {

    public int solution(int n, int[][] computers) {

        int[] arr = new int[n];
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }

        UnionFind uf = new UnionFind();
        List<Edge> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (i == j) continue;
                if (computers[i][j] == computers[i][j + 1]) {
                    list.add(new Edge(j, j + 1));
                }
            }
        }

        for (Edge edge : list) {
            if (!uf.isSameUnion(arr, edge.node[0], edge.node[1])) {
                uf.union(arr, edge.node[0], edge.node[1]);
            }
        }
// 0 0 2 / 0 2 0

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i == j) continue;
                if (!uf.isSameUnion(arr, arr[i], arr[j])) {
                    ++answer;
                }
            }
        }

        return answer == 0 ? 1 : answer;
    }

    static class UnionFind {

        public int find(int[] arr, int p) {
            if (arr[p] == p) return p;
            return arr[p] = find(arr, arr[p]);
        }

        public void union(int[] arr, int p, int q) {
            p = find(arr, p);
            q = find(arr, q);
            if (p > q) arr[p] = q;
            else arr[q] = p;
        }

        public boolean isSameUnion(int[] arr, int p, int q) {
            p = find(arr, p);
            q = find(arr, q);
            return p == q;
        }
    }

    static class Edge {
        int[] node = new int[2];

        public Edge(int p, int q) {
            this.node[0] = p;
            this.node[1] = q;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "node=" + Arrays.toString(node) +
                    '}';
        }
    }
}
