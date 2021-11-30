package com.test.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Test {

    public static void main(String[] args) {
        Map map1 = new HashMap<String, String>();
        Map map2 = new ConcurrentHashMap<String, String>();
        List list = new ArrayList<String>();
        for (int i = 0; i < 10000; i++) {
            ThreadLocal threadLocal = new ThreadLocal<String>();
            String si = String.valueOf(i);
            map1.put(si, si);
            map2.put(si, si);
            list.add(si);
            threadLocal.set(si);
        }
    }
}
