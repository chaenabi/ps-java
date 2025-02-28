package programmers.codingTestPractice.level2;

class Static {
    public static String s = "Static Variable";
}


public class Main {
    public static void main(String[] args) {
        Static static1;
        static1 = null;
        static1.s = "aaa";
        System.out.println(static1.s);
        System.out.println(Static.s);
    }
}
