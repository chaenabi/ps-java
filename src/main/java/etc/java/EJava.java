package etc.java;

public class EJava {
    static final int i = 42;

    static int calculate() {
        System.out.println("Calculate...");
        return i;
    }

    static int getI() {
        return calculate();
    }

    public static void main(String[] args) {
        //final int fizz1 = calculate();
        String str = null;
        assert str == null;
    }
}
