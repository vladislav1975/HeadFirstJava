package test;

public class TestException {
    public static void main(String[] args) {
        int a,b;
        a = 5;
        b = 0;
        try {
            System.out.println(a/b);
        } catch (ArithmeticException e) {
            System.out.println("Error");
        }
        System.out.println("By");
    }


}
