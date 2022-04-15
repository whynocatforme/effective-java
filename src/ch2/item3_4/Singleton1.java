package ch2.item3_4;

public class Singleton1 {
    public static final Singleton1 singleton1 = new Singleton1();

    private Singleton1() {}

    public void hello() {
        System.out.println("hello");
    }
}
