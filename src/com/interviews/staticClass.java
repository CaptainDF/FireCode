package com.interviews;

class A {
    static {
        System.out.println("static A");
    }
    { System.out.println("I'm A class"); }

    public A() {
        System.out.println("I’m A");
    }
}

class B extends A {
    static {
        System.out.println("static B");
    }
    { System.out.println("I'm B class"); }
    public B() {
        System.out.println("I’m B");
    }
}

class Test {

    public static void main(String[] args) {
        A a = new B();
        B b = new B();

    }
}

