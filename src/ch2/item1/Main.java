package ch2.item1;

public class Main {

    public static void main(String[] args) {
        System.out.println(Parent.newChild(1) instanceof Child1); // true
        System.out.println(Parent.getInstance().equals(Parent.getInstance())); // true
        System.out.println(Parent.newInstance().equals(Parent.newInstance())); // false
    }
}
