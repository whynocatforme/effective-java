package ch11.item79;

import java.util.List;

@FunctionalInterface
public interface CallBack {
    void func(List<CallBack> callBackList);
}
