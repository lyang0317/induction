package com.test.calculate;

public class ServiceA {

    public void callA() {
        if(CallMonitorEngine.isExceedNum()) {
            return;
        } else {
            CallMonitorEngine.incrementNum();
            System.out.println("service A start");
        }
    }

}
