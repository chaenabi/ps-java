package programmers.codingTestPractice;

import java.util.Arrays;
import java.util.PriorityQueue;

import static java.util.stream.Collectors.toCollection;

// More Spicy
// https://programmers.co.kr/learn/courses/30/lessons/42626
public class Prgs42626 {

    public int solution(int[] scoville, int K) {

        PriorityQueue<Integer> queue = Arrays.stream(scoville)
                .boxed()
                .collect(toCollection(PriorityQueue::new));

        int cnt = 0;

        while (queue.peek() != null && queue.peek() <= K) {
            if (queue.size() == 1) return -1;
            queue.offer(queue.poll() + queue.poll() * 2);
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(new Prgs42626().solution(new int[]{1, 2, 3, 9, 10, 12}, 7));
    }

}
