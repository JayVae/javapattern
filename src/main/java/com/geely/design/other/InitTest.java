package com.geely.design.other;

public class InitTest {

    int a = 11;
    int b = 99;

    public InitTest(int a) {
        this.a = a;
    }

    public static void main(String[] args) {
        InitTest first = new InitTest(22);
    }
}
