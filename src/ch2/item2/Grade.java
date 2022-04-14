package ch2.item2;

public class Grade {

    private final int korean;
    private final int math;
    private final int english;
    private final int electiveCourse1;
    private final int electiveCourse2;
    private final int electiveCourse3;

    public Grade(Builder builder) {
        this.korean = builder.korean;
        this.math = builder.math;
        this.english = builder.english;
        this.electiveCourse1 = builder.electiveCourse1;
        this.electiveCourse2 = builder.electiveCourse2;
        this.electiveCourse3 = builder.electiveCourse3;
    }

    public static class Builder {
        private final int korean; // 필수
        private final int math; // 필수
        private final int english; // 필수
        private int electiveCourse1 = 0;
        private int electiveCourse2 = 0;
        private int electiveCourse3 = 0;

        public Builder(int korean, int math, int english) {
            this.korean = korean;
            this.math = math;
            this.english = english;
        }

        public Builder electiveCource1(int electiveCourse1) {
            // 연쇄적으로 호출되기 위해서 자기 자신을 반환
            this.electiveCourse1 = electiveCourse1;
            return this;
        }

        public Builder electiveCource2(int electiveCourse2) {
            this.electiveCourse2 = electiveCourse2;
            return this;
        }

        public Builder electiveCource3(int electiveCourse3) {
            this.electiveCourse3 = electiveCourse3;
            return this;
        }

        public Grade build() {
            return new Grade(this);
        }
    }

    public int getKorean() {
        return korean;
    }

    public int getMath() {
        return math;
    }

    public int getEnglish() {
        return english;
    }

    public int getElectiveCourse1() {
        return electiveCourse1;
    }

    public int getElectiveCourse2() {
        return electiveCourse2;
    }

    public int getElectiveCourse3() {
        return electiveCourse3;
    }
}
