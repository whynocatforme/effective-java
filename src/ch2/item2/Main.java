package ch2.item2;

import ch2.item2.Grade.Builder;

public class Main {

    public static void main(String[] args) {
        Grade grade = new Builder(80, 100, 70)
            .electiveCource1(50)
            .electiveCource2(80)
            .build();

        System.out.println(grade.getMath()); // 100
        System.out.println(grade.getElectiveCourse3()); // 0

        Pizza pizza = new NYPizza.Builder(15)
            .addTopping("파인애플")
            .addTopping("베이컨")
            .build();
        System.out.println(pizza instanceof NYPizza); // true
        System.out.println(pizza.getToppings()); // 파인애플, 베이컨

        Pizza pizza2 = new Calzone.Builder("칼초네 소스")
            .addTopping("할라피뇨")
            .build();
        System.out.println(pizza2 instanceof Calzone); // true
        System.out.println(pizza2.getToppings()); // 할라피뇨
    }
}
