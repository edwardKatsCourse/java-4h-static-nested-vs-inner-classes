package com.company.static_nested;

import java.util.Comparator;

public class NestedApplication { //Appl

    public static void main(String[] args) {
        String a = Outer.staticName;

        for (int i = 0; i < 3; i++) {
            new Outer("abc");
        }

        System.out.println("1,000,000 new Outers");
        System.out.println("1 (ONE) Outer.staticName");


        com.company.static_nested.Outer.StaticNested nested = new Outer.StaticNested();

        System.out.println(nested.getOuterField());

        new Outer();


        new Outer.StaticNested();


//        com.company.static_nested.Outer outer = new com.company.static_nested.Outer();
//        Outer outer = new Outer("");


    }
}


class Outer {

    static String staticName;
    String name;


    private static String privateStaticName;
    private String privateName;


    static class StaticNested {
        public StaticNested() {
            System.out.println("static nested");
            privateStaticName = "hello";
        }

        public String getOuterField() {
            return privateStaticName;
        }
    }





    public Outer() {
        System.out.println("outer");
    }

    public Outer(String name) {
        System.out.println("outer(String)");
        this.name = name;
    }


}