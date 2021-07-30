package programmers.codingTestPractice.heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import static java.util.stream.Collectors.toCollection;

/**
 *  https://programmers.co.kr/learn/courses/30/lessons/42626
 *  2021-07-23
 */

public class MoreSpicy {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        for (int n : scoville) System.out.print(n + " ");
        System.out.println();
        PriorityQueue<Integer> queue = Arrays.stream(scoville).boxed()
                                             .collect(toCollection(PriorityQueue::new));

        System.out.println(queue);
        while (queue.peek() < K) {
            if (queue.size() == 1) return -1;
            int min = queue.poll();
            int nextMin = queue.poll();
            int operation = min + (nextMin * 2);
            queue.offer(operation);
            answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] scoville = {2,9, 3,1,10,12};
        int K = 7;
        System.out.println(new MoreSpicy().solution(scoville, K));
    }
}
