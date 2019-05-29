package com.dev.practice.exectutor;

import org.apache.commons.lang3.SerializationUtils;

import java.io.Serializable;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceDemo {
    public static void main(String[] args) {

        /*Thread t1=new Thread(new MyThread("a"));
        t1.start();
        Thread t2=new Thread(new MyThread("b"));
        t2.start();
*/
        ExecutorService es= Executors.newFixedThreadPool(10);
        Future f=es.submit(new MyThread("a"));
        Future f1=es.submit(new MyThread("b"));
//        System.out.println("is cancelled:"+f.isCancelled());
//        f.cancel(true);
//        System.out.println("f.cancel():1");
//        System.out.println("is cancelled."+f.isCancelled());
//        System.out.println("f.cancel():2");
//        System.out.println("f.isDone:"+f.isDone());
//        es.submit(new MyThread("b"));


    }
}


class MyThread implements  Serializable, Callable<String> {

    String name;

    public MyThread(String name) {
        this.name=name;

    }


    @Override
    public String call() throws Exception {
        int i=1;
        while(i<=100){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name+":"+i);
            i++;
        }
        return "finished Execution."+name;
    }
}
