package com.yijiankang.threaddemo.controller;

/**
 * @author Mr
 * @title: ThreadTest
 * @projectName mytest
 * @description: TODO 礼让线程,让当前正在执行线程暂停
 * • 不是阻塞线程，而是将线程从运行
 * 状态转入就绪状态
 * • 让cpu调度器重新调度
 * @date 2019/6/2518:01
 */
public class ThreadTest_yield extends Thread {
    String id;
    String name;

    public ThreadTest_yield(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public void run() {
        for(int i=0;i<100;i++){
            System.out.println("join"+i);
        }

    }

    public static void main(String[] args) {
        ThreadTest_yield t1 = new ThreadTest_yield("1","22");
        t1.setPriority(10);//设置线程的优先级   1到10   建议在start()前设置
        t1.start();
        for(int i=0;i<100;i++){
            if(i>3){
                Thread.yield();//main线程暂停
            }
            System.out.println("main"+i);
        }
    }
}
