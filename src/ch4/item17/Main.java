package ch4.item17;

public class Main {
    /*
    1. setter 제공하지 않는다
    2. final 클래스로 정의하는 등의 방법으로 상속을 막는다
    3. 모든 필드를 final로 선언한다
    4. 모든 필드를 private으로 선언한다
    5. 가변 컴포넌트가 있다면 (List등?) 외부에서 참조를 얻지 못하게 한다
     */

    public static void main(String[] args) {

        // 불변클래스 단점 : 다단계 연산 중 중간단계 객체가 모두 버려질경우 성능 문제
        long startTime = System.currentTimeMillis();
        String str1 = "h" + "e" + "l" + "l" + "o";
        String str2 = "w" + "o" + "r" + "l" + "d";
        System.out.println(str1 + str2);
        System.out.println(System.currentTimeMillis() - startTime);

        // 성능문제 해결: 중간객체 생성없이 다단계 연산을 제공하는 StringBuilder 를 씀!
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        startTime = System.currentTimeMillis();
        sb1.append("h");
        sb1.append("e");
        sb1.append("l");
        sb1.append("l");
        sb1.append("o");
        sb2.append("w");
        sb2.append("o");
        sb2.append("r");
        sb2.append("l");
        sb2.append("d");
        System.out.println(sb1.append(sb2));
        System.out.println(System.currentTimeMillis() - startTime);
    }
}
