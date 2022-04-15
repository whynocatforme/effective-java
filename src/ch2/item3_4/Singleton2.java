package ch2.item3_4;

public class Singleton2 {

    private static final Singleton2 singleton2 = new Singleton2();

    private Singleton2() {}

    public static Singleton2 getInstance() {
        return singleton2;
    }

    public void hello() {
        System.out.println("hello");
    }
}
