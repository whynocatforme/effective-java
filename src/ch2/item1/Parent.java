package ch2.item1;

public class Parent {

    private String name;
    private static final Parent parent = new Parent();

    public static Parent newInstance() {
        // 이름을 가질수 있음
        return new Parent();
    }

    public static Parent getInstance() {
        // 호출될 때마다 인스턴스 생성하지 않아도 됨
        return parent;
    }

    public static Parent newChild(int type) {
        // 반환타입의 하위객체를 반환할 수 있다
        // 입력 매개변수에 따라 매번 다른 클래스의 객체를 반환할 수 있다
        if (type == 1) {
            return new Child1();
        }
        return new Child2();
    }
}
