package com.yijiankang.threaddemo.controller;

/**
 * @author Mr
 * @title: ThreadTest
 * @projectName mytest
 * @description: TODO  join合并线程,待此线程执
 * 行完成后，再执行其他线
 * 程，其他线程阻塞
 * @date 2019/6/2518:01
 */
public class ThreadTest_join extends Thread {
    String id;
    String name;

    public ThreadTest_join(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public void run() {
        for(int i=0;i<100;i++){
            System.out.println("join"+i);
        }

    }

    public static void main(String[] args) throws InterruptedException {
        ThreadTest_join t1 = new ThreadTest_join("1","22");
        t1.start();
        for(int i=0;i<100;i++){
            if(i==50){
                t1.join();//main线程阻塞
            }
            System.out.println("main"+i);
        }
    }
}
