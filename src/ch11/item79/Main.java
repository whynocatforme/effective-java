package ch11.item79;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    private static void concurrent_modification_exception() {
        Item79.add_callback(callBackList -> {
            if (callBackList == null) return;
            synchronized (callBackList) {
                callBackList.remove(0);
            }
        });

        // 같은 스레드에서 재진입 & 자기자신을 수정
        Item79.alien_method_call();
    }

    private static void new_thread() {

        Item79.add_callback(callBackList -> {
            System.out.println("0번 콜백 실행중");
        });

        Item79.add_callback(callBackList -> {
            if (callBackList == null) return;

            Thread thread = new Thread(()-> {
                synchronized (callBackList) {
                    System.out.println(Thread.currentThread() + " lock 획득");
                    callBackList.remove(1);
                    System.out.println(Thread.currentThread() + " lock 반환");
                }
            });

            thread.start();
        });

        Item79.add_callback(callBackList -> {
            System.out.println("2번 콜백 실행중");
        });

        // 같은 스레드에서 재진입 & 자기자신을 수정
        Item79.alien_method_call();
    }

    private static void deadlock() {

        Item79.add_callback(callBackList -> {
            System.out.println("0번 콜백 실행중");
        });

        Item79.add_callback(callBackList -> {
            if (callBackList == null) return;

            ExecutorService exec = Executors.newSingleThreadExecutor();
            try {
                exec.submit(() -> {
                    synchronized (callBackList) {
                        System.out.println(Thread.currentThread() + " lock 획득");
                        callBackList.remove(1);
                        System.out.println(Thread.currentThread() + " lock 반환");
                    }
                }).get(); // 여기서 교착상태 빠짐
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Item79.add_callback(callBackList -> {
            System.out.println("2번 콜백 실행중");
        });

        // 같은 스레드에서 재진입 & 자기자신을 수정
        Item79.alien_method_call();
    }

    public static void main(String[] args) {
        // 동기화 블록 안에서 클라이언트에게 제어를 양도하면 안됨
        // 클라이언트에서 같은 리소스에 대한 동기화블록이 또있으면?
        // 자기 자신이 콜백을 거쳐서 수정하여 ConcurrentModificationException 발생 가능성
        // 다른 스레드에서? 교착상태 빠질 가능성 등...
        // 외계인 메서드 호출을 동기화 블록 바깥으로 옮기기 (CopyOnWriteArrayList 등)

        concurrent_modification_exception();

        new_thread();

        deadlock();
    }
}
