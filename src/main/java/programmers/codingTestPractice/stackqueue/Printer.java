/*
package programmers.codingTestPractice.stackqueue;

import java.util.*;

// https://programmers.co.kr/learn/courses/30/lessons/42587
// 프린터
// 아직 못품
public class Printer {
    public static void main(String[] args) {
        new Printer();
        int result = solution(new int[]{ 1, 1, 9, 1, 1, 1}, 2);
        System.out.println(result);
    }

    private static int solution(int[] priorities, int location) {
        int answer = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        for (int priority : priorities) {
            list.add(priority);
        }
        // priority 배열을 순회하며 자신보다 큰 값(더 높은 우선순위)이 있는지 확인한다.
        //있으면 준비된 덱의 맨 뒤로 보낸다.
        //없으면 덱의 제일 앞부분으로 보낸다.
        for(int i = 0; i < priorities.length; i++) {
            for(int j = i; j < priorities.length; j++) {
                if(j == i) continue; // 기준점 자신은 비교하지 않는다.
                if(priorities[i] < priorities[j]) { // 더 큰 값이 있으면...
                    list.add(priorities[i]);
                    list.remove((Integer) j);
                    list.add(0, priorities[j]);
                }
            }
        }
        System.out.println(list);



        return answer;
    }
}
*/
