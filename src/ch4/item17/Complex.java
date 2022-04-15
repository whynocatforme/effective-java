package ch4.item17;

public final class Complex { // final로 선언하여 상속 불가

    private final double real;
    private final double imaginary; // 필드들을 final 로 선언하기

    public static final Complex ZERO = new Complex(0, 0); // 재사용 가능하도록 상수로 제공

    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }

    public Complex plus(Complex c) {
        // 본인에게 더해지는 것이 아닌 본인과 c를 더한 새로운 인스턴스를 생성하므로 'add'가 아닌 'plus'로 네이밍
        // 피연산자는 바뀌지 않으면서 연산 수행하는 함수형 프로그래밍 패러다임
        return new Complex(real + c.real, imaginary + c.imaginary);
    }

    // immutable class 는 복사해도 자기자신과 똑같으므로 clone 할 필요가없다
    // String 의 clone은 멍청이들이 잘못 만든것.. 웬만하면 쓰지말자
}
