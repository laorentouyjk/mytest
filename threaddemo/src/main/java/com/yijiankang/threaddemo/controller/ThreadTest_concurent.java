package com.yijiankang.threaddemo.controller;

import org.springframework.web.bind.annotation.RestController;

import static java.lang.Thread.sleep;

/**
 * @author Mr
 * @title: ThreadTest_concurent
 * @projectName mytest
 * @description: TODO
 * @date 2019/7/516:27
 */
@RestController
public class ThreadTest_concurent  implements Runnable {

    String name;
    public ThreadTest_concurent(String name) {
        this.name = name;
    }

    static int tickets = 1000;
    Object ob = "aa";

    @Override
    public void run() {
        while(tickets>0){
            synchronized (ob){
                if(tickets>0){
                    System.out.println(name+"卖出第"+tickets+"张票");
                    tickets--;
                }else{
                    System.out.println(name+"卖完了");
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }



    }


    public static void main(String[] args) {
        for(int i=0;i<100;i++){
            ThreadTest_concurent t1 = new ThreadTest_concurent("窗口"+i);
            Thread   t11 = new Thread(t1);
            t11.start();
        }

    }
}
