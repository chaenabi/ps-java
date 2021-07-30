package programmers.codingTestPractice.bfsdfs;

import java.util.*;
// 여행경로 프로그래머스
import static java.util.Collections.reverseOrder;
import static java.util.stream.Collectors.toUnmodifiableList;

//  {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}}
//  {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}}
//  {{"ICN", "A"}, {"ICN", "B"}, {"ICN", "A"}}
//  {{"ICN","A"},{"A","B"},{"B","A"},{"A","ICN"},{"ICN","A"}}
// {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}}
// {{"ICN", "B"}, {"ICN", "B"}, {"A", "B"}}
public class TripPath {

    public static void main(String[] args) {
        String[] result = new TripPath().solution(new String[][] {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}});
        for (String s : result) {
            if (s != null)
                System.out.print(s + " ");
        }
    }

    public String[] solution(String[][] tickets) {
        int len = tickets.length;
        List<String> answer = new ArrayList<>();
        boolean[] visited = new boolean[len * len];
        Stack<String> stack = new Stack<>();
        List<String> list = new ArrayList<>();
        List<String> orderedList;
        stack.push(tickets[0][0]);
        while (!stack.empty()) {
            String nowloc = stack.pop();
            answer.add(nowloc); // to return
            int row = tickets.length;
            // find all available to visit
            for(int i = 0; i < row; i++) {
                for(int j = 0; j < tickets[i].length; j++) {

                    if(nowloc.equals(tickets[i][0])) {
                        if(!visited[i]) {
                            list.add(tickets[i][1]);
                            visited[i] = true;
                        }
                    }
                }
            }
            // sort
            orderedList = list.stream().sorted(reverseOrder()).collect(toUnmodifiableList());
            for(String candidate : orderedList) {
                stack.push(candidate);
            }
            list.clear();
        }

        return answer.stream().map(String::valueOf).toArray(String[]::new);
    }
}
