package ch2.item2;

public class Calzone extends Pizza{
    private final String sauce;

    private Calzone(Builder builder) {
        super(builder);
        this.sauce = builder.sauce;
    }

    public static class Builder extends Pizza.Builder {
        private final String sauce;

        public Builder(String sauce) {
            this.sauce = sauce;
        }

        @Override
        Pizza build() {
            return new Calzone(this);
        }

        @Override
        protected Pizza.Builder self() {
            return this;
        }
    }

}
