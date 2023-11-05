package test;

public class TestExceptions {
    public static void main(String[] args) {
        //String test = "no";
        String test = "yes";

        try {
            System.out.println("Start try");
            doRisky(test);
            System.out.println("End try");
        } catch (Exception se){
            System.out.println("Scary exception");
        } finally {
            System.out.println("Finally");
        }
        System.out.println("End main");
    }

    static void doRisky(String test) throws Exception {
        System.out.println("Start risky test");
        if (test.equals("yes")) throw new Exception();
        System.out.println("End risky test");
        return;
    }
}