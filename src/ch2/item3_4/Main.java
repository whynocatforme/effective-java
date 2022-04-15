package ch2.item3_4;

public class Main {

    public static void main(String[] args) {
        // public static final 필드 싱글턴
        Singleton1 s1 = Singleton1.singleton1;
        s1.hello();

        // private static final 필드 & 정적팩토리 방식 싱글턴
        Singleton2 s2 = Singleton2.getInstance();
        s2.hello();

        // 원소가 하나인 enum 타입 싱글턴
        Singleton3 s3 = Singleton3.SINGLETON_3;
        s3.hello();
    }
}
