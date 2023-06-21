package com.test.completionstage;

import java.util.concurrent.CompletableFuture;

public class Test {

    public static void main(String[] args) {
        //同步进行任务
        CompletableFuture<ModeA> firstCompletableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return new ModeA(2, "second");
        });
        //CompletableFuture<ModeA> firstCompletableFuture = new CompletableFuture<>();
        //firstCompletableFuture.complete(new ModeA(2, "second"));
        System.out.println("1:"+firstCompletableFuture);
        CompletableFuture<ModeB> secondCompletableFuture = firstCompletableFuture.thenCompose(res -> {
            CompletableFuture<ModeB> r = CompletableFuture.completedFuture(new ModeB("2", "second"));
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return r;
        });
        CompletableFuture<String> thirdCompletableFuture = new CompletableFuture<>();
        System.out.println("2:"+secondCompletableFuture);
        CompletableFuture<String> aFinal = secondCompletableFuture.thenCompose(res -> {
            CompletableFuture<String> r = CompletableFuture.completedFuture("final");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return r;
        });
        System.out.println("3:"+aFinal);
        //异步结果回调
        CompletableFuture<String> aFinal2 = thirdCompletableFuture.whenComplete((s, e) -> {
            System.out.println("finish thirdCompletableFuture");
        });
        System.out.println("4:"+thirdCompletableFuture);
        CompletableFuture<String> aFinal3 = aFinal.whenComplete((s, e) -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            thirdCompletableFuture.complete(s + "xxx");
        });
        System.out.println("5:"+thirdCompletableFuture);
        String join = thirdCompletableFuture.toCompletableFuture().join();
        System.out.println("6:"+join);
    }

}
