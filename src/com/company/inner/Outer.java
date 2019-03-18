package com.company.inner;

public class Outer {

    private Integer innersCount = 0;
    private static Integer globalInnersCount = 0;

    class Inner {

        public Inner() {
            innersCount++;
            globalInnersCount++;

            System.out.println("Inners per current outer: " + innersCount);
            System.out.println("Inners total: " + globalInnersCount);
            System.out.println();
        }
    }
}

class TestApplication {
    public static void main(String[] args) {
        //VALID - 1 outer - many inners
        Outer outer = new Outer();
        Outer.Inner inner1_1 = outer.new Inner();
        Outer.Inner inner1_2 = outer.new Inner();
        Outer.Inner inner1_3 = outer.new Inner();
        Outer.Inner inner1_4 = outer.new Inner();

        //VALID - 1 outer - 1 inner
        Outer outer2 = new Outer();
        Outer.Inner inner2_1 = outer2.new Inner();


        //VALID - 1 outer - 0 inners
        Outer outer3 = new Outer();

        //INVALID - 0 outer - 1 inner
//        new Outer.Inner();

    }
}
