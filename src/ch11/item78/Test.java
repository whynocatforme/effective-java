package ch11.item78;

public class Test {

    // boolean 은 atomic type으로 배타적 수행적(원자성)을 보장하지만 동기화 없이는 스레드 간 통신을 보장하지 않음
    private static Boolean bool = false;

    // volatile은 배타적 수행은 보장하지 않지만 항상 최신의 값을 읽게 해줌
    private static volatile Boolean bool_volatile = false;

    public static void loop() throws InterruptedException {
        Thread thread = new Thread(() -> {
            int i = 0;
            while (!bool) {
                i++;
            }
        });
        thread.start();

        Thread.sleep(1000);
        bool = true;
    }

    public static void loop_break() throws InterruptedException {
        Thread thread = new Thread(() -> {
            int i = 0;
            while (true) {
                i++;
                synchronized (bool) {
                    if (bool) break;
                }
            }
        });
        thread.start();

        Thread.sleep(1000);
        synchronized (bool) {
            bool = true;
        }
    }

    public static void loop_break_with_functions() throws InterruptedException {
        Thread thread = new Thread(() -> {
            int i = 0;
            while (!getBool()) {
                i++;
            }
        });
        thread.start();

        Thread.sleep(1000);
        setBoolTrue();
    }

    private static synchronized void setBoolTrue() {
        bool = true;
    }

    private static synchronized boolean getBool() {
        return bool;
    }

    public static void loop_with_volatile() throws InterruptedException {
        Thread thread = new Thread(() -> {
            int i = 0;
            while (!bool_volatile) {
                i++;
            }
        });
        thread.start();

        Thread.sleep(1000);
        bool_volatile = true;
    }
}
