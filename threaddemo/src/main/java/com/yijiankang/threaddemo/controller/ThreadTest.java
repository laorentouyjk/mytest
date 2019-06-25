package com.yijiankang.threaddemo.controller;

/**
 * @author Mr
 * @title: ThreadTest
 * @projectName mytest
 * @description: TODO
 * @date 2019/6/2518:01
 */
public class ThreadTest extends Thread {
    String id;
    String name;

    public ThreadTest(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("id"+id+"名称"+name);
    }

    public static void main(String[] args) {
        ThreadTest t1 = new ThreadTest("1","张三");

        ThreadTest t2 = new ThreadTest("2","李四");

        ThreadTest t3 = new ThreadTest("3","王五");
        t1.start();
        t2.start();
        t3.start();
    }
}
