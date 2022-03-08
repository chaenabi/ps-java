package programmers.codingTestPractice.level1;

public class Prgs12948 {

    public String solution(String phone_number) {
        String star = phone_number.substring(0, phone_number.length() - 4);
        String numbers = phone_number.substring(star.length());
        return star.replaceAll(".", "*") + numbers;
    }

    public static void main(String[] args) {
        System.out.println(new Prgs12948().solution("01033334444"));
        System.out.println(new Prgs12948().solution("027778888"));
    }
}
