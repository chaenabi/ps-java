package jobs.part2;

import java.util.Scanner;

/*
문제

N과 시작 숫자 S가 주어지면 숫자 피라미드를 만드는 프로그램을 작성하시오.
예를 들어, N이 5이고 S가 3 이라면, 그 숫자 피라미드는 다음과 같다.

    3
   456
  21987
 3456789
987654321

    시작 숫자 S는 꼭대기부터 1씩 증가한다.
    시작 행의 번호가 1번이라고 했을때, 짝수번째 행은 왼쪽에서 오른쪽으로 1씩 증가하도록 적고, 홀수번째 행은 거꾸로 적는다.
    숫자가 만약 10이 될 경우, 1로 바꾸고 다시 증가한다.

입력

입력의 첫 번째 줄에 N과 시작 숫자 S가 주어진다. ( 1≤N≤100, 1 ≤S≤ 9)


출력

첫 번째 줄부터 숫자 피라미드를 출력한다. (각 줄에 존재하는 공백의 개수와 숫자의 개수를 정확하게 확인해주시바랍니다.)


예제 입력

5 3

예제 출력

    3
   456
  21987
 3456789
987654321
 */
public class NumberPyramid {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int floor = sc.nextInt(), start = sc.nextInt();
        int space = floor - 1, number = 1;
        int pref = start, prel = 0;
        sc.close();
        for (int i = 1; i <= floor; i++) {
            for (int j = 0; j < space; j++) {
                System.out.print(" ");
            }
            space--;

            if (i % 2 == 0) {
                int curf = pref + 1;
                if (curf >= 10) curf = 1;
                for (int j = 0; j < number; j++) {
                    System.out.print(curf);
                    prel = curf;
                    ++curf;
                    if (curf >= 10) curf = 1;
                }
            }
            else {
                int curf = prel;
                if (i == 1) curf = start;
                else {
                    for (int j = 0; j < number; j++) {
                        ++curf;
                        if (curf >= 10) curf = 1;
                    }
                }
                pref = curf;

                for (int j = 0; j < number; j++) {
                    System.out.print(curf);
                    --curf;
                    if (curf <= 0) curf = 9;
                }
            }
            System.out.println();
            number = 2 * i + 1;
        }
    }
}
