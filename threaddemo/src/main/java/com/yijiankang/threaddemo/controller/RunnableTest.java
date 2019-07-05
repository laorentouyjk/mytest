package com.yijiankang.threaddemo.controller;

public class RunnableTest implements Runnable {
    String id;
    String name;

    public RunnableTest(String id, String name) {
        this.id = id;
        this.name = name;
    }
    @Override
    public void run() {
        System.out.println("id"+id+"名称"+name);
    }

    public static void main(String[] args) {
      /*  RunnableTest runnableTest = new RunnableTest("1","张三");
        RunnableTest runnableTest1 = new RunnableTest("2","李四");
        RunnableTest runnableTest2 = new RunnableTest("3","王五");
        Thread t1 = new Thread(runnableTest);
        Thread t2= new Thread(runnableTest1);
        Thread t3 = new Thread(runnableTest2);
        t1.start();
        t2.start();
        t3.start();*/
    }
}
