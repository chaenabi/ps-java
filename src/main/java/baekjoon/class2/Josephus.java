package baekjoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/11866
// 요세푸스 문제 0
public class Josephus {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] setting = br.readLine().split(" ");
        int people = Integer.parseInt(setting[0]);   // 전체 인원
        int turn = Integer.parseInt(setting[1]); // 순번
        if(people >= 1 && people <= 1000 || turn >= 1 && turn <= 1000) {
            Queue<Integer> order = new ArrayDeque<>();
            List<String> killedOrder = new ArrayList<>();

            killedOrder.add("<");
            for(int person = 1; person <= people; person++) {  // 순번 부여 실제 작업 (1, 2, 3, ... n)
                order.add(person);
            }
            while(order.size() > 0) {  // 실제 로직. 더 이상 남아있는 순번이 없을 때까지 리스트에 담으며 반복한다.
                for(int i = 1; i < turn; i++) {
                    order.offer(order.poll());
                }
                killedOrder.add(order.poll() + ", ");
            }
            String removeLastComma = killedOrder.get(killedOrder.size() - 1); // 마지막 순번 콤마 제거
            killedOrder.remove(killedOrder.get(killedOrder.size() - 1));
            removeLastComma = String.valueOf(removeLastComma.split(",")[0]); // 제거 종료
            killedOrder.add(removeLastComma); // 콤마 제거된 순번을 다시 리스트에 추가
            killedOrder.add(">");
            //killedOrder.forEach(System.out::print); 출력때문에 오류인지 확실하지 않으나 주석처리하고 아래 코드로 변경
            String result = String.join("", killedOrder);
            System.out.println(result);
        }
    }
}
// 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19
//     x     x     x       x        x        x
// 1 2 4 5 7 8 10 11 13 14 16 17 19
//   x     x      x        x
//