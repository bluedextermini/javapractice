package com.dev.practice.test;

public class OverrideDemo {

    public static double add(int a,double b ){
        return (double)a+b;
    }
    public static double add(double a,int b ){
        return a+(double)b+10;
    }

    public static void main(String[] args) {
//        System.out.println(add(1,2));
    }
}
