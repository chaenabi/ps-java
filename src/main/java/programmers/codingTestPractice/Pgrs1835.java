package programmers.codingTestPractice;

// complete search
public class Pgrs1835 {
    // 1. 인덱스 방문 여부 체크 배열.
    static boolean[] check = new boolean[8];
    // 2. 카카오 프렌즈 0~7인덱스까지 각 알파벳을 매칭.
    static char[] friends = {'A','C','F','J','M','N','R','T'};

    static int answer;

    // 16. 주어진 조건 data에 맞는지 검사하는 메소드
    public static boolean isPossible(StringBuilder sb, String[] data){
        // 17. 조건 배열 data를 탐색.
        for(int i = 0 ; i<data.length;i++){
            // 18. 조건의 0번 인덱스와 2번 인덱스는 조건을 제시한 프렌즈, 상대 프렌즈이므로, 그 사이 거리를 구한다.
            // 단, 둘 사이의 프렌즈 수를 구해야 하기 때문에 최종 값에 -1.
            int gap = Math.abs(sb.indexOf(String.valueOf(data[i].charAt(0))) - sb.indexOf(String.valueOf(data[i].charAt(2))))-1;
            // 19. 조건의 4번 인덱스는 주어진 정수값.
            int condition_gap = data[i].charAt(4) - '0';

            // 20. 조건의 3번 인덱스는 대소비교 문자이므로 이에 따라 분기처리.
            switch(data[i].charAt(3)){
                // 21. 각 경우에 따라 조건에 맞지 않다면 false.
                case '=' :
                    if(gap != condition_gap) return false;
                    break;

                case '>' :
                    if(gap <= condition_gap) return false;
                    break;

                case '<':
                    if(gap >= condition_gap) return false;
                    break;
            }

        }

        // 22. 나머지는 true.
        return true;
    }

    // 6. dfs 메소드(인덱스, 경우의 수 순열을 저장할 객체, 조건 메소드에 전달 할 data 배열)
    public static void dfs(int idx,StringBuilder sb, String[] data){
        // 7. idx == 마지막 프렌즈인 경우 조건을 검사 및 종료.
        if(idx == friends.length){
            // 8. 조건 검사 메소드 호출.
            if(isPossible(sb,data)){
                answer++;
            }
            return;
        }

        // 9. 전역변수로 선언한 문자형 배열을 탐색.
        for(int i = 0 ; i < friends.length;i++){
            // 10. 방문한 경우 패스.
            if(check[i]) continue;
            // 11. 방문처리 후,
            check[i] = true;
            // 12. 프렌즈에 해당하는 문자를 StringBuilder 객체에 붙인다.
            sb.append(friends[i]);
            // 13. 인덱스 증가 및 StringBuilder와 함께 재귀호출.
            dfs(idx+1,sb,data);
            // 14. 방문처리 해제.
            check[i] = false;
            // 15. 위에 붙인 문자를 다시 제거.
            sb.delete(idx,friends.length);
        }
    }

    public int solution(int n, String[] data) {
        // 3. 모든 경우의 수를 만들 StringBuilder 객체.
        StringBuilder sb = new StringBuilder();
        // 4. 초기화 해주어야 통과가 된다.
        answer = 0;
        // 5. dfs메소드 호출.
        dfs(0,sb,data);

        return answer;
    }
}
