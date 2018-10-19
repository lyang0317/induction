package com.test.calculate;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class CallMonitorEngine {

    private static Integer EXCEED_NUM = 8;

    public static Map<String, Integer> MAP = new ConcurrentHashMap();


    public static boolean isExceedNum() {
        long l = System.currentTimeMillis();
        Set<Map.Entry<String, Integer>> entries = MAP.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> next = iterator.next();
            String key = next.getKey();
            Integer value = next.getValue();
            if(Long.parseLong(key) + 1000 > l) {
                if(value >= EXCEED_NUM) {
                    return true;
                }
            } else {
                iterator.remove();
            }
        }
        return false;
    }

    public static void incrementNum() {

        Set<Map.Entry<String, Integer>> entries = MAP.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> next = iterator.next();
            String key = next.getKey();
            Integer value = next.getValue();
            MAP.put(key, ++value);
        }

        String l = String.valueOf(System.currentTimeMillis());
        MAP.putIfAbsent(l, 1);
    }

}
