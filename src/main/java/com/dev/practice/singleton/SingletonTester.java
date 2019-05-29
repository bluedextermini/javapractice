package com.dev.practice.singleton;

import java.util.function.Supplier;

class SingletonTester
{
    public static boolean isSingleton(Supplier<Object> func)
    {
        // todo
        Object o1= func.get();
        Object o2= func.get();
        return o1==o2;
    }
}