/*
package programmers.codingTestPractice.level2;

import java.util.Arrays;

*/
/*
한자리 숫자가 적힌 종이 조각이 흩어져있습니다.
흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.

각 종이 조각에 적힌 숫자가 적힌 문자열 numbers 가 주어졌을 때,
종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.

  제한사항
  numbers 는 길이 1 이상 7 이하인 문자열입니다.
  numbers 는 0~9까지 숫자만으로 이루어져 있습니다.
  "013"은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.

  입출력 예
  numbers	return
  "17"	    3
  "011"	    2

예제 #1
[1, 7]으로는 소수 [7, 17, 71]를 만들 수 있습니다.

예제 #2
[0, 1, 1]으로는 소수 [11, 101]를 만들 수 있습니다.
11과 011은 같은 숫자로 취급합니다.

*//*

public class Prgs42839 {

    private static int[] combs;

    public int solution(String numbers) {
        // numbers를 split하여 1자리 문자열 배열로 만들기
        String[] nums = numbers.split("");

        // permutation 으로 뽑아내기
        permutation(nums);

        // combs를 순회하며 소수인지 판별하고 소수이면 카운트++
        int cnt = isPrime(combs);
        return cnt;
    }

    private int[] permutation(String[] numbs, int depth, int n, int r) {
        if (depth == r) {

        }
        return null;
    };
}


*/
