package ch4.item17;

public class PreventExtending {
    // final 예약어없이 상속 불가하게 만드는법
    private PreventExtending() {}

    public static PreventExtending newInstance() {
        return new PreventExtending();
    }
}
