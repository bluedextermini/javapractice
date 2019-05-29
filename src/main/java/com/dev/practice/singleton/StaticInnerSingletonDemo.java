package com.dev.practice.singleton;

 class StaticInnerSingleton{
    private StaticInnerSingleton() {
    }

    private static class Impl{
        private static StaticInnerSingleton INSTANCE= new StaticInnerSingleton();
    }

    public static StaticInnerSingleton getInstance(){
        return Impl.INSTANCE;
    }
}

public class StaticInnerSingletonDemo{

    public static void main(String[] args) {
        StaticInnerSingleton  o1= StaticInnerSingleton.getInstance();
        StaticInnerSingleton o2=  StaticInnerSingleton.getInstance();

        System.out.println(o1==o2);
    }
}


