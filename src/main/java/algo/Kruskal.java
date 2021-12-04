package algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * UnionFind, Kruskal을 이용한 최소신장트리 생성
 */
class UnionFind {

    int find(int[] arr, int a) {
        if (arr[a] == a) return a;
        return arr[a] = find(arr, arr[a]);
    }

    void union(int[] arr, int a, int b) {
        a = find(arr, a);
        b = find(arr, b);

        if (a < b) arr[b] = a;
        else arr[a] = b;
    }

    boolean isSameUnion(int[] arr, int a, int b) {
        a = find(arr, a);
        b = find(arr, b);
        return a == b;
    }
}

class Edge implements Comparable<Edge> {
    int[] node = new int[2];
    int distance;

    public Edge(int a, int b, int distance) {
        this.node[0] = a;
        this.node[1] = b;
        this.distance = distance;
    }

    @Override
    public int compareTo(Edge edge) {
        return Integer.compare(this.distance, edge.distance);
    }

    @Override
    public String toString() {
        return "Edge{" +
                "node=" + Arrays.toString(node) +
                ", distance=" + distance +
                '}';
    }
}

public class Kruskal {

    public static void main(String[] args) {

        int n = 7; // 7의 정점
        int m = 11; // 11개의 간선
        List<Edge> list = new ArrayList<>();
        UnionFind uf = new UnionFind();

        list.add(new Edge(1, 7, 12));
        list.add(new Edge(1, 4, 28));
        list.add(new Edge(1, 2, 67));
        list.add(new Edge(2, 4, 24));
        list.add(new Edge(2, 5, 62));
        list.add(new Edge(3, 5, 20));
        list.add(new Edge(3, 6, 37));
        list.add(new Edge(4, 7, 13));
        list.add(new Edge(5, 6, 45));
        list.add(new Edge(5, 7, 73));
        list.add(new Edge(1, 5, 17));

        // 오름차순 정렬
        Collections.sort(list);

        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        int sum = 0;
        for (Edge edge : list) {
            // 사이클이 발생하지 않는 경우 그래프에 포함시킨다.
            if (!uf.isSameUnion(parent, edge.node[0], edge.node[1] )) {
                sum += edge.distance;
                uf.union(parent, edge.node[0], edge.node[1]);
            }
        }

        System.out.println(sum);

    }

}

/*

최소 신장 트리(Minimum Spanning Tree, MST) 구현하기
(edge1, edge2, distance)
(1, 7, 12)
(1, 4, 28)
(1, 2, 67)
(2, 4, 24)
(2, 5, 62)
(3, 5, 20)
(3, 6, 37)
(4, 7, 13)
(5, 6, 45)
(5, 7, 73)

 */
