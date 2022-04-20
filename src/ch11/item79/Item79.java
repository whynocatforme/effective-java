package ch11.item79;

import java.util.ArrayList;
import java.util.List;

public class Item79 {

    private static final List<CallBack> callBackList = new ArrayList<>(); // 공유 자원

    public static void add_callback(CallBack callBack) {
        synchronized (callBackList) {
            callBackList.add(callBack);
        }
    }

    public static void alien_method_call() {
        synchronized (callBackList) {
            System.out.println(Thread.currentThread() + " lock 획득");
            // 동기화 블록 안에서 클라이언트에게 제어를 양도
            for (CallBack callBack : callBackList) {
                callBack.func(callBackList);
            }
            System.out.println(Thread.currentThread() + " lock 반환");
        }
    }
}
