package com.yijiankang.threaddemo.controller;

import java.util.concurrent.*;

public class CallableTest implements Callable {
    String id;
    String name;

    public CallableTest(String id, String name) {
        this.id = id;
        this.name = name;
    }
    @Override
    public Object call() throws Exception {
        System.out.println("id"+id+"名称"+name);
        return null;
    }

    public static void main(String[] args) {
        CallableTest callableTest = new CallableTest("1","张三");
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<Boolean> result = executorService.submit(callableTest);
        try {
            Boolean aBoolean = result.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }
}
