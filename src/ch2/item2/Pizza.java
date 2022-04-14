package ch2.item2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Pizza {

    private final List<String> toppings;

    protected Pizza(Builder builder) {
        toppings = Collections.unmodifiableList(builder.toppings);
    }

    abstract static class Builder {
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
