package jobs.part6;

import java.util.Scanner;

// 일반적인 순열의 경우, 재귀호출 필요
public class Permutation {

    private static void perm(int x, int r, char[] result, int n) {
        // 현재 x번째 for이고, r중 for문이 필요하다. (r이 2이면, 2중 for문)
        if (x >= r) {
            boolean flag = false;

            // 여기에 도달했다는것은, result안에 숫자가 다 채워졌다는 뜻이다.
            // 중복 체크 (aa, bb, cdda, dcad 이런거 제외)
            label: for (int i = 0; i < r; i++) {
                for (int j = 0; j < r; j++) {
                    if (i != j && result[i] == result[j]) {
                        flag = true;
                        break label;
                    }
                }
            }
            if (!flag) {
                String s = "";
                for (int i = 0; i < r; i++) {
                    s += result[i];
                }
                System.out.println(s);
            }
        }
        else {
            for (char i = 97; i < n + 97; i++) {
                result[x] = i;
                perm(x + 1, r, result, n);
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        sc.close();
        perm(0, r, new char[11], n);

        /*
          서로 다른 n개의 원소들 중에서 r개만을 뽑아 일렬로 나열하는 것을 순열이라 한다.
          예를들어 3개의 원소 a, b, c중에서 2개만을 뽑아 나열하면 ab, ac, ba, cd, ca, db의 6가지 경우가 있다.
          n과 r이 주어질때, n개의 소문자 중에서 r개만을 뽑아 나열하는 모든 경우를 출력하라.
          단, a부터 시작해 연속으로 n개의 알파벳을 갖고 있다고 하자.
          사전순으로 나열하세요.


          n = 4, r = 3 일때
          // 3중 for문으로 만든다.
          for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {

                }
            }
        }
                i     j     k
                0     0     0   -> aaa
                0     0     1   -> aab
                0     0     2   -> aac
                0     0     3

                0     1     0   -> aba
                0     1     1   -> abb
                0     1     2
                0     1     3

                0     2     0
                0     2     1
                0     2     2
                0     2     3   ->  abd

                0     3     0   ->  aca
                0     3     1
                0     3     2
                0     3     3   ->  add

                1     0     0
                1     0     1
                1     0     2
                1     0     3

                1     1     0
                1     1     1
                1     1     2
                1     1     3

                1     2     0
                1     2     1   -> bcb
                ...
         */
        /*
           n = 4, r = 2 일때..
            2중포문으로 만든다.
            for (int i = 0; i < n; i++) {
               for (int j = 0; j < n; j++) {

               }
            }

            i    j
            0    0   -> aa
            0    1   -> ab
            0    2
            0    3   -> ad

            1    0
            1    1  -> bb
            1    2
            1    3  -> bd

            2    0  -> ca
            2    1
            2    2
            2    3

            3    0
            3    1 -> db
            3    2
            3    3 -> dd


            따라서 r이 4라면, 4중포문이 필요하게 된다.
            여기서 문제가 생긴다. 중첩되는 for문을 r의 값에 따라 바꿀수가 없기 떄문.

            그래서 재귀를 활용하면 좋다.
            void myFor (int x, int r) {
                // 총 r개의 for문이 중첩되어야 한다.
                //   지금 x번째 for문이다.
            }

            myFor(2, 4)  -> 4개의 for문 중첩, 지금 2번째 for문

            void myFor (int x, int r) {
                if (x > r) return;
                else {
                    for (i = 0; i < n; i++) {
                        result[x] = i;
                        myFor(x + 1, r);
                    }
                }
            }
            위 코드 동작 순서
            myFor (1, 4)
               -> result[1] = 0;
                  myFor(2, 4)
                  -> result[2] = 0;
                     myFor(3, 4)
                     -> result[3] = 0;
                         myFor(4, 4)
                         -> result[4] = 0;
                            myFor(5, 4)  // 5가 4보다 크르모 return;으로 종료
                            -> 이제 이 순서에서 중요한점은,
                                myFor(4, 4)의 for문의 i는 1증가하고,
                                result[4] = 1; 을 실행하고,
                                myFor(5, 4)를 다시 실행하게 된다.

                                result[4] = 2;
                                myFor(5, 4)를 다시 실행.
                                result[4] = 3;
                                myFor(5, 4)를 다시 실행.
                                그리고 myFor(4, 4)는 모두 실행되었으므로 종료.

                         -> 이제 이 순서에서 중요한 점은,
                            myFor(3, 4)의 for문의 i는 1증가하고,
                            result[3] = 1; 을 실행하고,
                            mysqlFor(4, 4)를 다시 실행함.

                            여기까지 진행했으면 result 배열은 아래와 같이 되었을 것이다.

                            index:   [0]    [1]    [2]     [3]     [4]     [5]    [6]
                            value:           0      1       0       3

         */
    }


}