package programmers.codingTestPractice.level1;
/**

    테스트 케이스 1: 
    n = 5, lost = { 1, 2, 4}, reserve = {1, 3}
   
    들을수있는 학생: 1번, 2번, 3번, 5번
*/

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {

        Set<Integer> lostSet = Arrays.stream(lost)
                                     .boxed()
                                     .collect(Collectors.toSet());

        Set<Integer> reserveSet = Arrays.stream(reserve)
                                        .boxed()
                                        .collect(Collectors.toSet());

        //    n = 5, lost = { 1, 2, 4}, reserve = {1, 3}
        Set<Integer> newLosted = lostSet.stream()
                .filter(e -> {
                    if (reserveSet.contains(e)) {
                        reserveSet.remove(e);
                        return false;
                    }
                    return !reserveSet.contains(e);
                })
                .collect(Collectors.toSet());


        newLosted.forEach(System.out::print);
        System.out.println("--------------------------");
        reserveSet.forEach(System.out::print);
        //    n = 5, lost = { 1, 2, 4}, reserve = {1, 3}
        // newLosted = { 2, 4}
        for (int l : newLosted) {
            if (reserveSet.contains(l - 1)) {
                reserveSet.remove(l - 1);
            } else if (reserveSet.contains(l + 1)) {
                reserveSet.remove(l + 1);
            } else {
                n -= 1;
            }

        }

        return n;
    }

    public static void main(String[] args) {
        new Solution().solution(5, new int[]{1, 2, 4}, new int[]{1, 3});
    }

}