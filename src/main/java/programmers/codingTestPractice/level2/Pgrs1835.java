package programmers.codingTestPractice.level2;

/**
 * 단체사진찍기
 * https://programmers.co.kr/learn/courses/30/lessons/1835
 * created: 2021-07-30
 */

public class Pgrs1835 {
    private int answer = 0;
    private final String[] friends = {"A", "C", "F", "J", "M", "N", "R", "T"};
    private final int friendqt = friends.length;

    public int solution(int n, String[] data) {
        if (n != data.length) return 0;
        boolean[] visited = new boolean[8];
        dfs("", visited, data);
        return answer;
    }

    private void dfs(String names, boolean[] visited, String[] datas) {
        if (names.length() == 7) {
            if (check(names, datas)) answer++;
            return;
        }

        for (int i = 0; i < friendqt; i++) {
            if (!visited[i]) {
                visited[i] = true;
                String name = names + friends[i];
                dfs(name, visited, datas);
                visited[i] = false;
            }
        }
    }

    private boolean check(String names, String[] datas) {
        for (String data : datas) {
            int position1 = names.indexOf(data.charAt(0));
            int position2 = names.indexOf(data.charAt(2));
            char op = data.charAt(3);
            int index = data.charAt(4) - '0';
            switch (op) {
                case '=':
                    if (!(Math.abs(position1 - position2) == index + 1)) return false;
                    break;
                case '>':
                    if (!(Math.abs(position1 - position2) > index + 1)) return false;
                    break;
                case '<':
                    if (!(Math.abs(position1 - position2) < index + 1)) return false;
                    break;
            }
        }
        return true;
    }
}