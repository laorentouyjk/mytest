package com.yijiankang.threaddemo.controller;

public class Racer implements Runnable {
    public static String winner;
    @Override
    public void run() {
        for(int distance=1;distance<=100;distance++){
            System.out.println(Thread.currentThread().getName()+ "-->"+distance);
            boolean flag = this.isWin(distance);
            if(flag){
                break;
            }}}
    public boolean isWin(int distance) {
        if(winner!=null) { //有胜利者
            return true;
        }else {
            if(distance==100) {
                winner =Thread.currentThread().getName();
                System.out.println("winner==>"+winner);
                return true;
            }
            return false;
        }}

    public static void main(String[] args) {
        Racer racer = new Racer();
        Thread thread = new Thread(racer);
        thread.start();
    }
}
