package ch2.item2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Pizza {
    // 빌더 패턴은 계층적으로 설계된 클래스와 함께 쓰기 좋음

    private final List<String> toppings;

    protected Pizza(Builder builder) {
        toppings = Collections.unmodifiableList(builder.toppings);
    }

    abstract static class Builder {
        // 추상 클래스는 추상 빌더를 가진다
        private final List<String> toppings = new ArrayList<>();

        abstract Pizza build();

        public Builder addTopping(String topping) {
            toppings.add(topping);
            return self();
        }

        protected abstract Builder self();
    }

    public List<String> getToppings() {
        return toppings;
    }
}
