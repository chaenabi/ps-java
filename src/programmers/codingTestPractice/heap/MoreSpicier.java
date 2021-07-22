package programmers.codingTestPractice.heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import static java.util.stream.Collectors.toCollection;

/**
 *  https://programmers.co.kr/learn/courses/30/lessons/42626
 *  2021-07-23
 */

public class MoreSpicier {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> queue = Arrays.stream(scoville).boxed()
                                             .collect(toCollection(PriorityQueue::new));

        System.out.println(queue);
        while (queue.peek() != null && queue.peek() >= K) {
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
        int[] scoville = {1,2,3,9,10,12};
        int K = 7;
        System.out.println(new MoreSpicier().solution(scoville, K));
    }
}
