package ch11.item79;

import java.util.ArrayList;
import java.util.List;

public class Item79_modified {

    private static final List<CallBack> callBackList = new ArrayList<>(); // 공유 자원

    public static void add_callback(CallBack callBack) {
        synchronized (callBackList) {
            callBackList.add(callBack);
        }
    }

    public static void alien_method_call() {

        List<CallBack> snapshot = null;

        synchronized (callBackList) {
            System.out.println(Thread.currentThread() + " lock 획득");
            snapshot = new ArrayList<>(callBackList);
            System.out.println(Thread.currentThread() + " lock 반환");
        }

        for (CallBack callBack : snapshot) {
            callBack.func(callBackList);
        }
    }
}
