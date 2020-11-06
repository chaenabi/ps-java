package programmers.codingTestPractice.bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

// 43163 단어 변환 프로그래머스
public class WordConversion {
   /* public static void main(String[] args) {
        int result = new WordConversion().solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"});
        System.out.println(result);
   }
*/
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] setting = br.readLine().split(" "); // [0] : 마윈과 40인들 (41)  [1] : 순번 (3)
        int people = Integer.parseInt(setting[0]);   // 전체 인원
        int turn = Integer.parseInt(setting[1]); // 몇 번째 순번마다 감옥갈지 결정
        Queue<Integer> order = new ArrayDeque<>();
        List<Integer> remainMember = new ArrayList<>();
        for(int person = 1; person <= people; person++) {  // 순번 부여 실제 작업 (1, 2, 3, .... 41)
            order.add(person);
        }
        while(order.size() > 1) {
            for(int i = 1; i < turn; i++) {
                order.offer(order.poll());
            }
            order.poll();
        }
        @SuppressWarnings("ConstantConditions")
        int lastOne = order.poll();
        System.out.println("전체 인원이 " + people + "명이고 한사람씩 돌아가면서 \n"
                           + turn + "번째마다 감옥에 가게 된다면, \n"
                           + "알리바바는 "+ lastOne + "번 자리에 앉아야 램프의 주인이 된다.");
    }
}
