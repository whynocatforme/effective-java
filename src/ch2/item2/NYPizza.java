package ch2.item2;

public class NYPizza extends Pizza{
    private final int size; // NYPizza는 필드로 size 가짐

    private NYPizza(Builder builder) {
        super(builder);
        this.size = builder.size;
    }

    public static class Builder extends Pizza.Builder {
        private final int size;

        public Builder(int size) {
            this.size = size;
        }

        @Override
        Pizza build() {
            return new NYPizza(this);
        }

        @Override
        protected Pizza.Builder self() {
            return this;
        }
    }
}
