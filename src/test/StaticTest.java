package test;

class StaticSuper {
    static  {
        System.out.println("Parent stat block");
    }

    StaticSuper(){
        System.out.println("Parent constructor");
    }
}

public class StaticTest extends StaticSuper{
    static  int rand;
    static {
        rand = (int)(Math.random()*10);
        System.out.println("Static block " + rand);
    }
    StaticTest(){
        System.out.println("Constructor");
    }

    public static void main(String[] args) {
        System.out.println("Inside main");
        StaticTest st = new StaticTest();
    }
}