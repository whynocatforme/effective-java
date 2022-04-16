package ch11.item78;

import java.util.concurrent.atomic.AtomicInteger;

public class TestVolatile {

    // 배타적 실행 지원 안함.
    private static int num = 0;

    // 배타적 실행도 지원 (Compare and set)
    private static final AtomicInteger atomicNum = new AtomicInteger(0);

    private static synchronized void generateNumber() {
        // ++ 연산은 사실 두 연산이 합쳐진것
        System.out.println(num);
        num++;
    }

    public static void test_with_synchronized() {
        Thread thread = new Thread(TestVolatile::peekNum);
        thread.start();
        peekNum();
    }

    private static void peekNum() {
        int i = 0;
        while (++i < 100) {
            generateNumber();
        }
    }

    private static void generateAtomicNumber() {
        int andIncrement = atomicNum.incrementAndGet();
        System.out.println(andIncrement);
    }

    public static void test_with_atomic() {
        Thread thread = new Thread(TestVolatile::peekAtomicNum);
        thread.start();
        peekAtomicNum();
    }

    private static void peekAtomicNum() {
        int i = 0;
        while (++i < 100) {
            generateAtomicNumber();
        }
    }
}
