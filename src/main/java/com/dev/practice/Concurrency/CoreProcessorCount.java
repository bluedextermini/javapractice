package com.dev.practice.Concurrency;

public class CoreProcessorCount {
    public static void main(String[] args) {

        System.out.println(Runtime.getRuntime().availableProcessors());
        System.out.println(Runtime.getRuntime().freeMemory()/(1024*1024));
    }

}
