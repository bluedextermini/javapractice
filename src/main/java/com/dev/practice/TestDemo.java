package com.dev.practice;

public class TestDemo  implements Runnable{

    private String str;
    @Override
    public void run() {

    }

    public TestDemo() {
    }

    public TestDemo(String str) {
        this.str = str;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public static void main(String[] args) {
        System.out.println("test");
    }
}
